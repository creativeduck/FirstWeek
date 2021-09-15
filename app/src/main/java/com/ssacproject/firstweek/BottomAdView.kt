package com.ssacproject.firstweek

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class BottomAdView : RelativeLayout {
    lateinit var relativeAd : RelativeLayout
    lateinit var imgAd: ImageView
    lateinit var titleAd: TextView
    lateinit var contentAd: TextView
    lateinit var Ad: ImageView

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context) {
        init(context, attrs, 0)
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, delStyleAttr: Int) : super(context, attrs, delStyleAttr){
        init(context, attrs, delStyleAttr)
        getAttrs(attrs, delStyleAttr)
    }


    fun init(context: Context, attrs: AttributeSet?, delStyleAttr: Int) {
        var inflater : LayoutInflater? = null
        var tmp: Any? = getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        if(tmp is LayoutInflater) {
            inflater = tmp
        }
        var view = inflater!!.inflate(R.layout.bottom_ad, this, false)
        addView(view)
        relativeAd = view.findViewById(R.id.relativeAd)
        titleAd = view.findViewById(R.id.titleAd)
        imgAd = view.findViewById(R.id.imgAd)
        contentAd = view.findViewById(R.id.contentAd)
        Ad = view.findViewById(R.id.Ad)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomAdView)
        setAttrs(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet?, delStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomAdView)
        setAttrs(typedArray)
    }

    private fun setAttrs(typedArray: TypedArray) {
        imgAd.setImageResource(typedArray.getResourceId(R.styleable.BottomAdView_imgAd, R.drawable.adimg))
        titleAd.setText(typedArray.getText(R.styleable.BottomAdView_titleAd))
        contentAd.setText(typedArray.getText(R.styleable.BottomAdView_contentAd))
    }

}