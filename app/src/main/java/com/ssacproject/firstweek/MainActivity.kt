package com.ssacproject.firstweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ssacproject.firstweek.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private lateinit var bottomnavi: BottomNavigationView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tabTitles = listOf<String>("홍은동 추천", "스타일 추천")
        var fragmentList = listOf<Fragment>(Fragment1(), Fragment2())
        val adapter = ViewPagerAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

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
