package com.example.home1android3.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.home1android3.R
import com.example.home1android3.model.viewModel.MainModel
import com.example.kotlin41.ui.prefernce.SharedPreference

class MainActivity : AppCompatActivity() {
    private val preferensHelper: SharedPreference by lazy {
        SharedPreference(this)
    }
    private lateinit var mainModel: MainModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation(savedInstanceState)

    }

    private fun setUpNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_actcivity) as NavHostFragment
        val navController = navHostFragment.navController
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (!preferensHelper.isShowRegister){
                navGraph.setStartDestination(R.id.registrationFragment)
                navController.graph = navGraph
            }
        }
    }
}