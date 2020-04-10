package com.initiative.eshopping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.initiative.eshopping.R
import com.initiative.eshopping.callback.OnItemClickListener
import com.initiative.eshopping.model.ProductModel
import java.text.NumberFormat
import java.util.*

class ProductsAdapter(private var productsList: ArrayList<ProductModel>?, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
    return ProductsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false))
  }

  override fun getItemCount(): Int = productsList?.size ?: 0

  override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
    holder.bindProduct(productsList?.get(position), itemClickListener)
  }

  class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val productImage: ImageView = itemView.findViewById(R.id.img_productImage)
    private val productTitle: TextView = itemView.findViewById(R.id.tv_productName)
    private val productPrice: TextView = itemView.findViewById(R.id.tv_productPrice)
    private var product: ProductModel? = null


    fun bindProduct(product: ProductModel?, itemClickListener: OnItemClickListener) {
      this.product = product
      productImage.setImageResource(product?.imageId!!)
      productTitle.text = product.title
      productPrice.text = formatPrice(product.price)

      itemView.setOnClickListener {
        itemClickListener.onItemClicked(adapterPosition)
      }
    }

    private fun formatPrice(price: Double): String {
      val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
      return format.format(price)
    }
  }
}
