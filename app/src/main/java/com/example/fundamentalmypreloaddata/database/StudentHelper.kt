package com.example.fundamentalmypreloaddata.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import com.example.fundamentalmypreloaddata.database.DatabaseContract.StudentColumns.Companion.NAME
import com.example.fundamentalmypreloaddata.database.DatabaseContract.StudentColumns.Companion.STUDENT_ID
import com.example.fundamentalmypreloaddata.database.DatabaseContract.TABLE_NAME
import com.example.fundamentalmypreloaddata.model.StudentModel
import java.sql.SQLException

class StudentHelper(context: Context) {
    private val databaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private var INSTANCE: StudentHelper? = null
        fun getInstance(context: Context): StudentHelper {
            if (INSTANCE == null) {
                synchronized(SQLiteOpenHelper::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = StudentHelper(context)
                    }
                }
            }
            return INSTANCE as StudentHelper
        }
    }

    @Throws(SQLException::class)
    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun close() {
        databaseHelper.close()
        if (database.isOpen) database.close()
    }

    fun getAll(): ArrayList<StudentModel> {
        val cursor = database.query(TABLE_NAME, null, null, null, null, null, "$_ID ASC", null)
        cursor.moveToFirst()
        val arrayList = ArrayList<StudentModel>()
        var studentModel: StudentModel
        if (cursor.count > 0) {
            do {
                studentModel = StudentModel()
                studentModel.id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID))
                studentModel.name = cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                studentModel.studentId = cursor.getString(cursor.getColumnIndexOrThrow(STUDENT_ID))

                arrayList.add(studentModel)
                cursor.moveToNext()
            } while (!cursor.isAfterLast)
        }
        cursor.close()
        return arrayList
    }

    fun insert(studentModel: StudentModel): Long {
        val initialValues = ContentValues()
        initialValues.put(NAME, studentModel.name)
        initialValues.put(STUDENT_ID, studentModel.studentId)
        return database.insert(TABLE_NAME, null, initialValues)
    }

    fun searchByName(name: String): ArrayList<StudentModel> {
        val cursor = database.query(TABLE_NAME, null, "$NAME LIKE ?", arrayOf(name), null, null, "$_ID ASC", null)
        cursor.moveToFirst()

        val arrayList = ArrayList<StudentModel>()
        var studentModel: StudentModel
        if (cursor.count > 0) {
            do {
                studentModel = StudentModel()
                studentModel.id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID))
                studentModel.name = cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                studentModel.studentId = cursor.getString(cursor.getColumnIndexOrThrow(STUDENT_ID))
                arrayList.add(studentModel)
                cursor.moveToNext()
            } while (!cursor.isAfterLast)
        }
        cursor.close()
        return arrayList
    }
}