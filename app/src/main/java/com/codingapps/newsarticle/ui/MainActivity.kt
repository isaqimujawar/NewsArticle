package com.codingapps.newsarticle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codingapps.newsarticle.R

class MainActivity : AppCompatActivity() {
    //vars
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMainFragment()
    }

    fun showMainFragment(){
        Log.d(TAG, "showMainFragment: called")
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,MainFragment(),"Main Fragment")
                .commit()
    }
}