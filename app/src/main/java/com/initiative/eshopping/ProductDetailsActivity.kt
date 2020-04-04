package com.initiative.eshopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.initiative.eshopping.adapter.ProductsAdapter
import com.initiative.eshopping.model.ProductModel
import kotlinx.android.synthetic.main.activity_product_details.*
import java.text.NumberFormat
import java.util.*

class ProductDetailsActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_details)

    val intent = intent.getParcelableExtra<ProductModel>(ProductsAdapter.ProductsViewHolder.productKey)
    intent?.let {
      tv_detailsDesc.text = it.description
      tv_detailsTitle.text = it.title
      tv_detailsPrice.text = formatPrice(it.price)
      img_detailsImage.setImageResource(it.imageId)
    }
  }

  private fun formatPrice(price: Double): String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
    return format.format(price)
  }

}
