package com.oussama_chatri.mentalcalculation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        findViewById<ImageView>(R.id.back_button).setOnClickListener{
            onBackPressed()
        }

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.About -> {
                    replaceFragment(about())
                }
                R.id.Rules -> {
                    replaceFragment(rules())
                }
                R.id.home -> {
                    replaceFragment(home())
             }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


    }

private fun replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .commit()
}

     override fun onNavigationItemSelected(item: MenuItem): Boolean {
         TODO("Not yet implemented")
         //I make some thing like that above
     }
    fun openFacebook(view: View) {
        val facebookUrl = "https://www.facebook.com/profile.php?id=100090744685971"
        openWebUrl(facebookUrl)
    }

    fun openInstagram(view: View) {
        val instagramUrl = "https://www.instagram.com/osama.chatri/"
        openWebUrl(instagramUrl)
    }

    private fun openWebUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
 }
