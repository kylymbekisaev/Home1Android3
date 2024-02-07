package com.example.home1android3.model.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home1android3.model.UserModel
import com.example.kotlin41.ui.prefernce.SharedPreference

class MainModel: ViewModel() {
    private var _userData = MutableLiveData<UserModel>()
    val userData: LiveData<UserModel> = _userData

    fun updateUserModel(userModel: UserModel) {
        _userData.value = userModel
    }

    fun huynia(context: Context) {
        val preferenceHelper = SharedPreference(context)
        updateUserModel(
            UserModel(
                preferenceHelper.user_name!!,
                preferenceHelper.age!!,
                preferenceHelper.email!!,
                preferenceHelper.password!!
            )
        )
    }
}