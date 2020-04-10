package com.initiative.eshopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.initiative.eshopping.adapter.ProductsAdapter
import com.initiative.eshopping.callback.OnItemClickListener
import com.initiative.eshopping.model.ProductModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), OnItemClickListener {
  private val products: ArrayList<ProductModel> = ArrayList(3)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    productsRecycler.adapter = ProductsAdapter(createData(), this)
    productsRecycler.layoutManager = GridLayoutManager(this, 2)
  }

  companion object {
      const val productKey = "PRODUCT_KEY"
    }


  private fun createData(): ArrayList<ProductModel> {
    products.add(ProductModel(R.drawable.chair, "Arm Chair", 200.0, "Green arm chair for your living room, bedroom or patio"))
    products.add(ProductModel(R.drawable.dress, "Pink Kids Gown", 50.0, "Pink gown for kids between the age of 5 and 8"))
    products.add(ProductModel(R.drawable.living_room, "Interior Design", 2000.00, "We make interior designs"))
    return products
  }

  override fun onItemClicked(id: Int) {
    val intent = Intent(this, ProductDetailsActivity::class.java)
    intent.putExtra(productKey, products[id])
    startActivity(intent)
  }
}
