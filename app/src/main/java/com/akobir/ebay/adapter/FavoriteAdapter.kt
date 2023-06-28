package com.akobir.ebay.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akobir.ebay.R
import com.akobir.ebay.model.Favorite

class FavoriteAdapter(var context: Context, var items: ArrayList<Favorite>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is FavoriteViewHolder){
            val tv_title = holder.tv_title
            val iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
            tv_title.text = item.title
        }
    }

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_image: ImageView
        var tv_title: TextView

        init {
            iv_image = view.findViewById(R.id.iv_image)
            tv_title = view.findViewById(R.id.tv_title)
        }
    }
}