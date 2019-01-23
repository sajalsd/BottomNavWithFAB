package ch.sooon.navsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.NavOptions


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        setupBottomNavMenu(navController)
        setupActionBar(navController)

        fab.setOnClickListener{
            clearBackStackToHome()
        }

    }

    private fun clearBackStackToHome() {
        if(navController.currentDestination?.id != R.id.homeFragment)
        {
            val navBuilder = NavOptions.Builder()
            val navOptions = navBuilder.setPopUpTo(R.id.homeFragment, true).build()
            navController.navigate(R.id.homeFragment, null, navOptions)

            bottom_nav.selectedItemId = R.id.homeFragment
        }
    }

    private fun setupBottomNavMenu(navController: NavController) {
        bottom_nav?.let {
            NavigationUI.setupWithNavController(it, navController)
        }

        bottom_nav.setOnNavigationItemReselectedListener {
            Toast.makeText(this, "Reselected", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
        return navigated || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
