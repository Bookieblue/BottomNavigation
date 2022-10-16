package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentMe = meFragment()
        val fragmentFamily = myFamilyFragment()
        val fragmentFriends = myFriendsFragment()
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_Navigation)

        makeCurrentFragment(fragmentMe)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.Me -> makeCurrentFragment(fragmentMe)
                R.id.myFamily -> makeCurrentFragment(fragmentFamily)
                R.id.myfriends -> makeCurrentFragment(fragmentFriends)
            }
            true
        }
    }

        private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                 replace(R.id.ft_wrapper, fragment)
                 commit()

            }







    
}