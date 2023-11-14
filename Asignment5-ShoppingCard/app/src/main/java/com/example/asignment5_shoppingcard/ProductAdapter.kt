package com.example.asignment5_shoppingcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var bList: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {
//        holder.product_image.setImageResource() =  bList[position].productImage
//        holder.logo_image.setImageResource(bList[position].logoImage)
        holder.product_cost.text = bList[position].productCost.toString()
        holder.product_description.text = bList[position].productDescription
        holder.product_name.text = bList[position].productName
    }

    override fun getItemCount(): Int {
        return bList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val product_name: TextView
        val product_cost: TextView
        val product_description: TextView
        val product_image: ImageView
        val logo_image: ImageView

        init {
            product_name = itemView.findViewById(R.id.productName)
            product_cost = itemView.findViewById(R.id.productCost)
            product_description = itemView.findViewById(R.id.productDescription)
            product_image = itemView.findViewById(R.id.productImage)
            logo_image = itemView.findViewById(R.id.logoImage)
        }
    }
}