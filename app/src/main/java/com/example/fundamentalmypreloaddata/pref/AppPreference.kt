package com.example.fundamentalmypreloaddata.pref

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit

class AppPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "student_preference"
        private const val APP_FIRST_RUN = "app_first_run"
    }

    private val preference: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)

    var firstRun: Boolean?
        get() = preference.getBoolean(APP_FIRST_RUN, true)
        set(input) {
            preference.edit {
                putBoolean(APP_FIRST_RUN, input as Boolean)
            }
        }
}