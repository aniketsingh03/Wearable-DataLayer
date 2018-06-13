package com.android.wear

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment("SampleFragment", R.id.fragment_container)
    }
    fun AppCompatActivity.addFragment(tag: String, layoutId: Int) {
        val fragmentToAdd = SampleFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(layoutId, fragmentToAdd).commit()
    }
}
