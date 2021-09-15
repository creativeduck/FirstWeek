package com.ssacproject.firstweek

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ssacproject.firstweek.databinding.ActivityMainBinding
import com.ssacproject.firstweek.databinding.DfhdfhBinding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: DfhdfhBinding

    private lateinit var bottomnavi: BottomNavigationView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DfhdfhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tabTitles = listOf<String>("홍은동 추천", "스타일 추천")
        var fragmentList = listOf<Fragment>(Fragment1(), Fragment2())
        val adapter = ViewPagerAdapter(this)

        adapter.fragmentList = fragmentList
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.viewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (supportFragmentManager.fragments.size > position) {
                    val fragment = supportFragmentManager.fragments.get(position)
                    fragment.view?.let {
                        updatePagerHeightForChild(it, binding.viewpager)
                    }
                }
            }
        })

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

    fun updatePagerHeightForChild(view: View, pager: ViewPager2) {
        view.post {
            val wMeasureSpec =
                View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
            val hMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            view.measure(wMeasureSpec, hMeasureSpec)
            if(pager.layoutParams.height != view.measuredHeight) {
                pager.layoutParams = (pager.layoutParams)
                    .also {
                        lp -> lp.height = view.measuredHeight
                    }
            }
        }
    }
}
