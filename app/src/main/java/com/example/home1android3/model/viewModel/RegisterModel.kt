package com.example.home1android3.model.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.kotlin41.ui.prefernce.SharedPreference

class RegisterModel: ViewModel() {

    fun saveUserData(context: Context, name: String, age: String, email: String, password: String, showReg: Boolean) {
        val preferenceHelper = SharedPreference(context)
        preferenceHelper.user_name = name
        preferenceHelper.age = age
        preferenceHelper.email = email
        preferenceHelper.password = password
        preferenceHelper.isShowRegister = showReg
    }
}