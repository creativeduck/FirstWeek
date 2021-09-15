package com.ssacproject.firstweek

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ssacproject.firstweek.databinding.ActivityMainBinding.inflate


class CustomPagerAdapter : RecyclerView.Adapter<Holder>() {
    var imageList = listOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setImage(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}

class Holder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_viewpager,
            parent, false
        )
    )

    fun setImage(Id: Int) {
        var imageview = itemView.findViewById<ImageView>(R.id.imageView)
        imageview.setImageResource(Id)
    }
}