package com.example.fundamentalmypreloaddata.database

import android.provider.BaseColumns

internal object DatabaseContract {
    val TABLE_NAME = "students"

    internal class StudentColumns : BaseColumns {
        companion object {
            const val NAME = "name"
            const val STUDENT_ID = "student_id"
        }
    }
}