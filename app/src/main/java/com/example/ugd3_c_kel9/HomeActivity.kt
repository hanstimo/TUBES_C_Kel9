package com.example.ugd3_c_kel9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    private val PembelianFragment = PembelianFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getSupportActionBar()?.hide()

        setThatFragments(homeFragment)
        val bottom: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.itemHome ->
                    setThatFragments(homeFragment)
                R.id.itemPembelian->
                    setThatFragments(PembelianFragment)
                R.id.itemProfile->
                    setThatFragments(profileFragment)
            }
            true
        }
    }

//    private fun replaceFragment(fragment: Fragment) {
//        if (fragment != null) {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.fragment_container, fragment)
//            transaction.commit()
//        }
//    }

    private fun setThatFragments(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }
    }

    private fun logout(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@HomeActivity)
        builder.setTitle("Log Out")
        builder.setMessage("Are you sure want to exit?")
            .setPositiveButton("Yes"){ dialog, which ->
                finishAndRemoveTask()
            }
            .show()
    }
}