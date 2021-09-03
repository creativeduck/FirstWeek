package com.ssacproject.firstweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

lateinit var bottomnavi: BottomNavigationView
lateinit var toolbar: androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomnavi = findViewById(R.id.bottomnavi)
        bottomnavi.setItemIconTintList(null)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("")
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.appbar_menu, menu)
        return true
    }
}