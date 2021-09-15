package com.ssacproject.firstweek

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Fragment1 : Fragment() {
    val imageList = listOf(R.drawable.event1,
                            R.drawable.event2,
        R.drawable.event3, R.drawable.event4)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment1, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var photo_viewpager = view.findViewById<ViewPager2>(R.id.photo_viewpager)

        var adapter = CustomPagerAdapter()
        adapter.imageList = imageList
        photo_viewpager.adapter = adapter

        val photo_tablayout = view.findViewById<TabLayout>(R.id.photo_tablayout)
        TabLayoutMediator(photo_tablayout, photo_viewpager) {tab, position -> }.attach()


        var textView = view.findViewById<TextView>(R.id.textchange)
        var content: String = textView.text.toString()
        var spannableString: SpannableString = SpannableString(content)
        var word: String = "개인정보처리방침"
        var start: Int = content.indexOf(word)
        var end: Int = start + word.length

        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#6200EE")), start, end,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.setText(spannableString)


    }

}