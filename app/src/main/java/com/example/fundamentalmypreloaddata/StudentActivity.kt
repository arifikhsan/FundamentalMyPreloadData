package com.example.fundamentalmypreloaddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fundamentalmypreloaddata.database.StudentHelper
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        recyclerview.layoutManager = LinearLayoutManager(this)
        val studentAdapter = StudentAdapter()
        recyclerview.adapter = studentAdapter

        val studentHelper = StudentHelper(this)
        studentHelper.open()
        val studentsModel = studentHelper.getAll()
        studentHelper.close()

        studentAdapter.setData(studentsModel)
    }
}