package com.example.msise.journeyplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.msise.journeyplanner.network.ApiClient
import com.example.msise.journeyplanner.network.ApiInterface
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.WindowManager
import com.example.msise.journeyplanner.collections.CollectionsFragment
import com.example.msise.journeyplanner.search.SearchFragment
import com.example.msise.journeyplanner.settings.SettingsFragment


class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.menu_bottom_search -> {
                val fragment: Fragment = SearchFragment.newInstance()
                openFragment(fragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_bottom_collections -> {
                val fragment: Fragment = CollectionsFragment.newInstance()
                openFragment(fragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_bottom_settings -> {
                val fragment: Fragment = SettingsFragment.newInstance()
                openFragment(fragment)

                return@OnNavigationItemSelectedListener true
            }
        }
        val fragment: Fragment = SearchFragment.newInstance()
        openFragment(fragment)
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val endPoint = ApiClient().getClient().create(ApiInterface::class.java)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.activity_main_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val fragment: Fragment = SearchFragment.newInstance()
        openFragment(fragment)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity_main_frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
