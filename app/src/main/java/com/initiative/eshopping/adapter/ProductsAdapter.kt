package com.initiative.eshopping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.initiative.eshopping.ProductDetailsActivity
import com.initiative.eshopping.R
import com.initiative.eshopping.model.ProductModel
import java.text.NumberFormat
import java.util.*

class ProductsAdapter(private var productsList: ArrayList<ProductModel>?, private val context: Context): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
    return ProductsViewHolder(LayoutInflater.from(context).inflate(R.layout.product_card, parent, false))
  }

  override fun getItemCount(): Int = productsList?.size ?: 0

  override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
    val product = productsList?.get(position)
    holder.productImage.setImageResource(product?.imageId!!)
    holder.productTitle.text = product.title
    holder.productPrice.text = formatPrice(product.price)
    holder.bindProduct(product)
  }

  private fun formatPrice(price: Double): String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
    return format.format(price)
  }

  class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val productImage: ImageView = itemView.findViewById(R.id.img_productImage)
    val productTitle: TextView = itemView.findViewById(R.id.tv_productName)
    val productPrice: TextView = itemView.findViewById(R.id.tv_productPrice)
    private var product: ProductModel? = null

    companion object {
      const val productKey = "PRODUCT_KEY"
    }

    init {
      itemView.setOnClickListener {
        val context = itemView.context
        val productDetailsIntent = Intent(context, ProductDetailsActivity::class.java)
        productDetailsIntent.putExtra(productKey, product)
        context.startActivity(productDetailsIntent)
      }
    }

    fun bindProduct(product: ProductModel) {
      this.product = product
    }
  }
}
