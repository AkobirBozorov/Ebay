package com.akobir.ebay.adapter

import android.content.Context
import android.graphics.ColorSpace.Model
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akobir.ebay.R
import com.akobir.ebay.model.Product

class ProductAdapter(var context: Context, var items: ArrayList<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is ProductViewHolder) {
            val tv_product = holder.tv_product
            val iv_product = holder.iv_product
            val tv_price = holder.tv_price
            val tv_sale = holder.tv_sale
            val tv_percent = holder.tv_percent

            iv_product.setImageResource(item.image)
            tv_product.text = item.title
            tv_price.text = item.price.toString()
            tv_sale.text = item.sale.toString()
            val spannableString = SpannableString(tv_sale.text)
            spannableString.setSpan(StrikethroughSpan(), 0, tv_sale.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv_sale.text = spannableString
            tv_percent.text = item.percent.toString()
        }
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_product: ImageView
        var tv_product: TextView
        val tv_price : TextView
        val tv_sale: TextView
        val tv_percent : TextView

        init {
            iv_product = view.findViewById(R.id.iv_product)
            tv_product = view.findViewById(R.id.tv_product)
            tv_price = view.findViewById(R.id.tv_price)
            tv_sale = view.findViewById(R.id.tv_sale)
            tv_percent = view.findViewById(R.id.tv_percent)
        }
    }
}