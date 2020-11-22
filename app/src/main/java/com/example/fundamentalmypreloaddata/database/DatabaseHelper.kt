package com.example.fundamentalmypreloaddata.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import com.example.fundamentalmypreloaddata.database.DatabaseContract.StudentColumns.Companion.NAME
import com.example.fundamentalmypreloaddata.database.DatabaseContract.StudentColumns.Companion.STUDENT_ID


import com.example.fundamentalmypreloaddata.database.DatabaseContract.TABLE_NAME

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "students"
        private const val DATABASE_VERSION = 1
        private val CREATE_TABLE_STUDENTS =
            "CREATE TABLE $TABLE_NAME ($_ID integer primary key autoincrement, $NAME text not null, $STUDENT_ID text not null);"
        private val DROP_TABLE_STUDENTS = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_STUDENTS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_STUDENTS)
        onCreate(db)
    }
}