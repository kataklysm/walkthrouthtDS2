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
    private lateinit var locationsFragment: LocationsFragment
    private lateinit var spellsFragment: SpellsFragment
    private lateinit var otherWeaponsFragment: OtherWeaponsFragment
    private lateinit var charactersFragment: CharactersFragment
    private lateinit var bossesFragment: BossesFragment
    private lateinit var weaponsFragment: WeaponsFragment
    private lateinit var shieldsFragment: ShieldsFragment
    private lateinit var armorFragment: ArmorFragment
    private lateinit var ringsFragment: RingsFragment
    private lateinit var objectsFragment: ObjectsFragment
    private lateinit var aboutFragment: AboutFragment
    private lateinit var covenantsFragment: CovenantsFragment
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
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("fragment",fragment)
        //bundle.putString("provider",provider)
        val transaction = this.supportFragmentManager.beginTransaction()
        val bossesDetailsFragment = BossesDetailsFragment()
        val locationsDetailsFragment = LocationsDetailsFragment()
        val charactersDetailsFragment = CharactersDetailsFragment()
        val covenantsDetailsFragment = CovenentsDetailsFragment()

        when(fragment){
            "covenantsFragment" ->{
                covenantsDetailsFragment.arguments = bundle
                transaction.replace(R.id.nav_host_fragment,covenantsDetailsFragment).addToBackStack(null).commit()
            }
            "locationFragment" ->{
                locationsDetailsFragment.arguments = bundle
                transaction.replace(R.id.nav_host_fragment,locationsDetailsFragment).addToBackStack(null).commit()
            }
            "bossesFragment" ->{
                bossesDetailsFragment.arguments = bundle
                transaction.replace(R.id.nav_host_fragment,bossesDetailsFragment).addToBackStack(null).commit()
            }
            "charactersFragment"->{
                charactersDetailsFragment.arguments = bundle
                transaction.replace(R.id.nav_host_fragment,charactersDetailsFragment).addToBackStack(null).commit()
            }
            else ->{
                Toast.makeText(this,"NO ACTION",Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        when(item.itemId){
            R.id.nav_covenants ->{
                covenantsFragment = CovenantsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, covenantsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_shields -> {
                shieldsFragment = ShieldsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, shieldsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_armor -> {
                armorFragment = ArmorFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, armorFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_rings -> {
                ringsFragment = RingsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, ringsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_objects -> {
                objectsFragment = ObjectsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, objectsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_weapons -> {
                weaponsFragment = WeaponsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, weaponsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_others -> {
                otherWeaponsFragment = OtherWeaponsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, otherWeaponsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_spells -> {
                spellsFragment = SpellsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, spellsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_bosses -> {
                bossesFragment = BossesFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, bossesFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }
            R.id.nav_characters -> {
                charactersFragment = CharactersFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, charactersFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }

            R.id.nav_browser -> {
                browserFragment = BrowserFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, browserFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
            }

            R.id.nav_locations -> {
                locationsFragment = LocationsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, locationsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null).commit()
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