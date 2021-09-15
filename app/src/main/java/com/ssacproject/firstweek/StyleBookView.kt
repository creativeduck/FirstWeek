package com.ssacproject.firstweek

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class StyleBookView : CardView {
    lateinit var relative: RelativeLayout
    lateinit var bookimage: ImageView
    lateinit var booktext1: TextView
    lateinit var booktext2: TextView
    lateinit var booktext3: TextView

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

    fun init(context: Context, attrs: AttributeSet?, delStyleAttr: Int) {
        var infService : String = Context.LAYOUT_INFLATER_SERVICE
        var inflater: LayoutInflater? = null
        var tmp: Any? = getContext().getSystemService(infService)
        if (tmp is LayoutInflater) {
            inflater = tmp
        }
        var view : View = inflater!!.inflate(R.layout.custom_stylebook, this, false)
        addView(view)

        relative = view.findViewById(R.id.relative)
        bookimage = view.findViewById(R.id.bookimage)
        booktext1 = view.findViewById(R.id.booktext1)
        booktext2 = view.findViewById(R.id.booktext2)
        booktext3 = view.findViewById(R.id.booktext3)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StyleBookView)
        setAttrs(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet?, delstyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StyleBookView)
        setAttrs(typedArray)
    }

    private fun setAttrs(typedArray: TypedArray) {
        bookimage.setImageResource(typedArray.getResourceId(R.styleable.StyleBookView_imgbook, R.drawable.three))
        booktext1.setText(typedArray.getText(R.styleable.StyleBookView_booktext1))
        booktext2.setText(typedArray.getText(R.styleable.StyleBookView_booktext2))
        booktext3.setText(typedArray.getText(R.styleable.StyleBookView_booktext3))
        typedArray.recycle()
    }



}