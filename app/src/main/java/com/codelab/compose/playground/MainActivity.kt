package com.codelab.compose.playground

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.codelab.compose.R
import com.codelab.compose.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHostFragment.navController
//            navController.addOnDestinationChangedListener { _, _, _ -> refreshOptionMenu(toolbar.menu) }
            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.androidViewDemo,
                    R.id.composeViewDemo,
                    R.id.ViewSystemDemo
                ),
                drawerLayout
            )
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            toolbar.setupWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }

}