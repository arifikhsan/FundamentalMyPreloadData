package com.example.fundamentalmypreloaddata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fundamentalmypreloaddata.model.StudentModel
import kotlinx.android.synthetic.main.item_student_row.view.*

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
    private val students = ArrayList<StudentModel>()

    fun setData(students: ArrayList<StudentModel>) {
        if (students.size > 0) {
            this.students.clear()
        }

        this.students.addAll(students)
        notifyDataSetChanged()
    }

    class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: StudentModel) {
            with(itemView) {
                txt_nim.text = student.studentId
                txt_nim.text = student.name
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.StudentHolder {
        return StudentHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size
    override fun getItemViewType(position: Int): Int = position
    override fun getItemId(position: Int): Long = position.toLong()
}