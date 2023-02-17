package com.example.application1

import android.Manifest
import android.R
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.example.application1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment = FirstFragment().newInstance(3, "first fragment")

        binding.buttonFirst.setOnClickListener {
//один пермишен
//            showCallApp()

            //несколько пермишеном
            checkMultiplePermissions()

            //открытие звонилки без пермишенов
//            val callIntent = Intent(Intent.ACTION_DIAL)
//            callIntent.data = Uri.parse("tel:" + "123")
//            startActivity(callIntent)

        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_FOR_MULTIPLE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera and Call Permissions granted", Toast.LENGTH_SHORT)
                    .show()
                //openCamera()
            } else if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera Permission granted", Toast.LENGTH_SHORT).show()
            } else if (grantResults.isNotEmpty() && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "CALL Permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permissions denied", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun showCallApp() {
        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CODE
            )
        } else {
            call()
        }
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CODE)
//            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                if (applicationContext != null) {
//                    call()
//                }
//            } else {
//                binding.tv1.text = "Permission revoke"
//            }
////        if(requestCode == REQUEST_CODE)
////            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
////                binding.tv1.text = "Permission granted"
////            }else binding.tv1.text = "Permission revoke"
////        else binding.tv1.text = "Permission revoke"
//    }

    fun call() {
        val dialIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "123456789"))
        startActivity(dialIntent)
    }


    fun checkMultiplePermissions() {
        if (checkPermission(Manifest.permission.CAMERA) && checkPermission(Manifest.permission.CALL_PHONE)) {
            Toast.makeText(this, "Camera and Call Permissions granted", Toast.LENGTH_SHORT).show()
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                AlertDialog.Builder(this)
                    .setMessage("Need camera permission to capture image. Please provide permission to access your camera.")
                    .setPositiveButton("OK") { dialogInterface, i ->
                        dialogInterface.dismiss()
                        ActivityCompat.requestPermissions(
                            this, arrayOf(Manifest.permission.CAMERA), REQUEST_CODE_FOR_MULTIPLE
                        )
                    }.setNegativeButton("Cancel") { dialogInterface, i ->
                        dialogInterface.dismiss()
                    }.create().show();
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE),
                    REQUEST_CODE_FOR_MULTIPLE
                )
            }
        }
    }


    companion object {
        const val REQUEST_CODE = 1
        const val REQUEST_CODE_FOR_MULTIPLE = 201

    }
}

