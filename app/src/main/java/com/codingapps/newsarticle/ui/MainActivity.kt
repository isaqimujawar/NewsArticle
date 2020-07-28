package com.codingapps.newsarticle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.codingapps.newsarticle.R
import com.codingapps.newsarticle.ui.FactViewModel
import com.codingapps.newsarticle.viewmodel.FactViewModelFactory

class MainActivity : AppCompatActivity() {
    //vars
    private val TAG = "MainActivity"

    //ui
    lateinit var viewModel: FactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = FactViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(FactViewModel::class.java)
        showMainFragment()
    }

    private fun showMainFragment() {
        Log.d(TAG, "showMainFragment: called")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MainFragment(), "Main Fragment")
            .commit()
    }
    fun setActionBarTitle(title:String){
        actionBar.title = title
    }
}