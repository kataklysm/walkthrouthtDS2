package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.daveapps.walkthrouthds2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, Communicator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var browserFragment: BrowserFragment
    private lateinit var aboutFragment: AboutFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Walkthrouthds2)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dafault_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_about -> {
            Toast.makeText(this,"about",Toast.LENGTH_LONG).show()
            aboutFragment = AboutFragment()
            val transactionAbout = this.supportFragmentManager.beginTransaction()
            transactionAbout.replace(R.id.nav_host_fragment,aboutFragment).addToBackStack(null).commit()
            true
        }else -> {
            super.onOptionsItemSelected(item)
        }

    }
    private fun setup() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        title = getString(R.string.search)
        val headerView = navigationView.getHeaderView(0)
        val tvWelcome = headerView.findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.typeface = Typeface.createFromAsset(assets,"fonts/optimussemibold.ttf")
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this,drawerLayout,toolbar,(R.string.open),(R.string.close)){}
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
        browserFragment = BrowserFragment()
        supportFragmentManager.beginTransaction()
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,browserFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }
    override fun passDataCom(name: String, fragment: String) {

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        when(item.itemId){
            R.id.nav_browser ->{
                Toast.makeText(this,"no action",Toast.LENGTH_LONG).show()
            }else->{
            Toast.makeText(this,"no action",Toast.LENGTH_LONG).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }


}