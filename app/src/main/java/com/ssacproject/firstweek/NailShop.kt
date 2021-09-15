package com.ssacproject.firstweek

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class NailShop : LinearLayout {
    lateinit var mainlinear : LinearLayout
    lateinit var trdLinear : LinearLayout
    lateinit var mainimage : ImageView
    lateinit var title : TextView
    lateinit var imgRating : ImageView
    lateinit var textRating : TextView
    lateinit var imgMessage : ImageView
    lateinit var textMessage : TextView

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, delStyleAttr: Int) : super(context, attrs, delStyleAttr) {
        init(context, attrs, delStyleAttr)
        getAttrs(attrs, delStyleAttr)
    }

    private fun init(context: Context, attrs : AttributeSet?, delStyleAttr : Int) {
        var infService : String = Context.LAYOUT_INFLATER_SERVICE
        var inflater: LayoutInflater? = null
        var tmp: Any? = getContext().getSystemService(infService)
        if (tmp is LayoutInflater) {
            inflater = tmp
        }
        var view : View = inflater!!.inflate(R.layout.nailshop, this, false)
        addView(view)

        mainlinear = findViewById(R.id.mainlinear)
        trdLinear = findViewById(R.id.trdLinear)
        mainimage = findViewById(R.id.mainimage)
        title = findViewById(R.id.title)
        imgRating = findViewById(R.id.imgRating)
        textRating = findViewById(R.id.textRating)
        imgMessage = findViewById(R.id.imgMessage)
        textMessage = findViewById(R.id.textMessage)

    }

    private fun getAttrs(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NailShop)
        setAttrs(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet?, delstyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NailShop)
        setAttrs(typedArray)
    }

    private fun setAttrs(typedArray: TypedArray) {
        mainimage.setImageResource(typedArray.getResourceId(R.styleable.NailShop_imgnail, R.drawable.shopimg))
        title.setText(typedArray.getText(R.styleable.NailShop_titlenail))
        textRating.setText(typedArray.getText(R.styleable.NailShop_textRatingnail))
        textMessage.setText(typedArray.getText(R.styleable.NailShop_textMessagenail))
        typedArray.recycle()
    }

}