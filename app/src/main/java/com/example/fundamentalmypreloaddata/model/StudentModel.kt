package com.example.fundamentalmypreloaddata.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StudentModel(
    var id: Int = 0,
    var name: String? = null,
    var studentId: String? = null
) : Parcelable