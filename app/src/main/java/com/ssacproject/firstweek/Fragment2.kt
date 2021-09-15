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
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment2_validation, container, false)
        var changelinear: LinearLayout = view.findViewById<LinearLayout>(R.id.changelinear)
        val totnum: TextView = view.findViewById(R.id.totnum)
        val curnum: TextView = view.findViewById(R.id.curnum)
        var cnt: Int = 1
        changelinear.setOnClickListener(View.OnClickListener {
            if (cnt <=3) {
                curnum.setText("${cnt++}")
            }
            else {
                cnt = 1
                curnum.setText("${cnt}")
            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var textView = view.findViewById<TextView>(R.id.textchange)
        var content: String = textView.text.toString()
        var spannableString: SpannableString = SpannableString(content)
        var word: String = "개인정보처리방침"
        var start: Int = content.indexOf(word)
        var end: Int = start + word.length

        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#6200EE")), start, end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.setText(spannableString)


    }

}