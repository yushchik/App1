package com.example.application1.room.dao

import androidx.room.*
import com.example.application1.room.entity.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM student_table")
    fun getAll(): List<Student>

    @Query("SELECT * FROM student_table")
    fun getAll2(): List<Student>

    @Query("SELECT * FROM student_table WHERE student_age LIKE :age")
    fun getStudent(age: Int): List<Student>

    @Insert
    fun insertAll(students: List<Student>)

    //Поиск происходит по Primary Key, и если будет найдено соответствие, произойдёт замена старого объекта на новый,
    // который мы передали в параметры метода. Если такого Primary Key в БД нет, не произойдёт никаких изменений.
    @Update
    fun updateStudent(students: Student)

    //Работает так же, как и @Update, то есть использует для поиска Primary Key объекта, а также,
    // если такой записи нет в БД, то не произойдёт никаких изменений. В остальных случаях удалит запись.
    @Delete
    fun deleteStudent(students: Student)

    //Мы также можем запрашивать данные в диапазоне
    @Query("SELECT * FROM student_table WHERE student_age BETWEEN :minAge AND :maxAge")
    fun getStudentInAgeRange(minAge: Int, maxAge: Int): List<Student>

}


