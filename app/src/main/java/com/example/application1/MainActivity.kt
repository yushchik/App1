package com.example.application1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.os.storage.StorageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import com.example.application1.databinding.ActivityMainBinding
import java.io.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //ЗАПИСЬ В ФАЙЛ
        //Имя файла
        val filename = "MyFile"
        //Содержимое файла
        val contents = "Contents for APP "
        val contents2 = "Contents for APP авлваолавлоал "
        //Открываем поток для записи
        this.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(contents.toByteArray())
        }

//
//
//        //ЧТЕНИЕ ИЗ ФАЙЛА
        this.openFileInput(filename).bufferedReader().useLines { lines ->
            var result = ""
            lines.forEach {
                result += it
            }
            binding.tv.text = result
        }

        //ВЫВОД СПИСКА ФАЙЛОВ
        val files = this.fileList()
        files.forEach {
            println("my files: $it")
        }


        //СОЗДАНИЕ, ЗАПИСЬ И ВЫВОД ФАЙЛА В КЕШЕ

        val fileTempName = "temp_file"
        val contentsForTemp = "Temp Contents "
        File.createTempFile(fileTempName, null, this.cacheDir)

        val tempFiles = this.cacheDir.listFiles()
        val file2 = File(this.cacheDir, tempFiles[0].name)

        val fw = FileWriter(file2.absoluteFile)
        val bw = BufferedWriter(fw)
        bw.write(contentsForTemp)
        bw.close()

        file2.bufferedReader().useLines { lines ->
            var result = ""
            lines.forEach {
                result += it
            }
            binding.tv.text = result
        }


        //СОЗДАНИЕ И ЗАПИСЬ В ExternalStorage
//
        val externalState = Environment.getExternalStorageState()
        println("getExternalStorageState: $externalState")
        //Получаем состояние хранилища
        //Название файла
        val externalFileName = "MyExternalFile"
        val contentsExternal = "Contents for External "

        //Производим проверку состояния
        if (externalState == Environment.MEDIA_MOUNTED) {
            //Создаем файл в хранилище
            val file = File(this.getExternalFilesDir("LOCAL"), externalFileName)
            //Создаем буфер для записи, используем use, чтобы закрыть потом поток
            BufferedWriter(FileWriter(file)).use {
                //Пишем в файл
                it.write(contentsExternal)
            }
        }
//
//        //СЧИТЫВАНИЕ ИЗ ExternalStorage
//
        if (externalState == Environment.MEDIA_MOUNTED) {
            //Находим файл
            val externalFile = File(this.getExternalFilesDir(null), externalFileName)
            //Читаем из файла все строки при помощи метода useLines, а также он помогает потом
            //закрыть ресурсы
            BufferedReader(FileReader(externalFile)).useLines { lines ->
                //В параметре лямбды у нас Sequence, поэтому выводим все через цикл
                lines.forEach {
                    println("External file:  $it")
                }
            }
        }

//        //СОЗДАНИЕ КЕШ ФАЙЛА В ExternalStorage

        val file = File.createTempFile(externalFileName, null, this.externalCacheDir)

        //ЗАПРАШИВАТЬ И РЕЗЕРВИРОВАТЬ ПАМЯТЬ
        val neededBytes = 1024 * 1024 * 100L
        val neededBytes2 = 1024 * 1024 * 10000L
        val storageManger = applicationContext.getSystemService<StorageManager>()!!
        val uuid = storageManger.getUuidForPath(filesDir)
        val availableStorage = storageManger.getAllocatableBytes(uuid)
        println("Bytes " + availableStorage / 1024 / 1024)
        if (availableStorage >= neededBytes) {
            storageManger.allocateBytes(uuid, neededBytes)
            println("Bytes allocated")
        } else {
            val intent = Intent(StorageManager.ACTION_MANAGE_STORAGE)
            startActivity(intent)
        }


    }

}

