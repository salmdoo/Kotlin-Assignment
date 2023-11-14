package com.example.asignment5_shoppingcard

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(
    var context: Context,
    var names: Array<String>,
    var desc: Array<String>,
    var costs: Array<Float>,
    var productImages: IntArray,
    var logoImages: IntArray,
    private val performAdd: (String) -> Unit
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var productLayout: RelativeLayout
        val product_name: TextView
        val product_cost: TextView
        val product_description: TextView
        val product_image: ImageView
        val logo_image: ImageView
        lateinit var addBtn: Button

        init {
            productLayout = itemView.findViewById(R.id.productLayout)
            product_name = itemView.findViewById(R.id.productName)
            product_cost = itemView.findViewById(R.id.productCost)
            product_description = itemView.findViewById(R.id.productDescription)
            product_image = itemView.findViewById(R.id.productImage)
            logo_image = itemView.findViewById(R.id.logoImage)
            addBtn = itemView.findViewById(R.id.addBtn)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.product_image.setImageResource(productImages[position])
        holder.logo_image.setImageResource(logoImages[position])
        holder.product_name.text = names[position]
        holder.product_cost.text = "$${costs[position]}"
        holder.product_description.text = desc[position]
        holder.addBtn.setOnClickListener { performAdd.invoke(names[position]) }


        holder.productLayout.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)

            val res = names[position]


            intent.putExtra(
                "product", Product(
                    productImages[position],
                    logoImages[position],
                    names[position],
                    desc[position],
                    costs[position]
                )
            )
            context.startActivity(intent)
        }
    }

}