package com.akobir.ebay.activity

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akobir.ebay.R
import com.akobir.ebay.adapter.CategoryAdapter
import com.akobir.ebay.adapter.FavoriteAdapter
import com.akobir.ebay.adapter.ProductAdapter
import com.akobir.ebay.model.Category
import com.akobir.ebay.model.Favorite
import com.akobir.ebay.model.Product

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerView2: RecyclerView
    lateinit var recyclerView3: RecyclerView
    lateinit var all: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView3 = findViewById(R.id.recyclerView3)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val manager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val manager3 = GridLayoutManager(this, 3)
        recyclerView.layoutManager = manager
        recyclerView2.layoutManager = manager2
        recyclerView3.layoutManager = manager3
        refreshAdapter(getFavorites())
        refreshAdapter2(getProduct())
        val categoryList = listOf(
            Category("Blankets", R.drawable.blanket),
            Category("Heaters", R.drawable.heater),
            Category("Thermostats", R.drawable.thermostat),
            Category("Generators", R.drawable.generator),
            Category("Snowblowers", R.drawable.snowblower),
            Category("Snow shovels", R.drawable.snowshovel)
        )
        val adapter = CategoryAdapter(categoryList)
        recyclerView3.adapter = adapter
        all = findViewById(R.id.all)
        all.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    fun refreshAdapter(items: ArrayList<Favorite>) {
        val adapter = FavoriteAdapter(this, items)
        recyclerView.adapter = adapter
    }

    fun refreshAdapter2(items: ArrayList<Product>) {
        val adapter2 = ProductAdapter(this, items)
        recyclerView2.adapter = adapter2
    }

    fun getFavorites(): ArrayList<Favorite> {
        val items = ArrayList<Favorite>()
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        items.add(Favorite("Apple Watch", R.drawable.im_product_1))
        return items
    }
    fun getProduct(): ArrayList<Product> {
        val items = ArrayList<Product>()
        items.add(Product("Apple Vision Pro", R.drawable.visionpro, "$3500.00", "$3600.00", "29% OFF"))
        items.add(Product("Apple Vision Pro", R.drawable.visionpro, "$3500.00", "$3600.00", "29% OFF"))
        items.add(Product("Apple Vision Pro", R.drawable.visionpro, "$3500.00", "$3600.00", "29% OFF"))
        items.add(Product("Apple Vision Pro", R.drawable.visionpro, "$3500.00", "$3600.00", "29% OFF"))
        items.add(Product("Apple Vision Pro", R.drawable.visionpro, "$3500.00", "$3600.00", "29% OFF"))
        items.add(Product("Apple Vision Pro", R.drawable.visionpro, "$3500.00", "$3600.00", "29% OFF"))
        return items
    }
}