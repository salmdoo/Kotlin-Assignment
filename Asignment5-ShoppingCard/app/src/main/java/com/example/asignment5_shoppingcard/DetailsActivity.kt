package com.example.asignment5_shoppingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    lateinit var product_name: TextView
    lateinit var product_cost: TextView
    lateinit var product_description: TextView
    lateinit var product_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        product_name = findViewById(R.id.productName)
        product_cost = findViewById(R.id.productCost)
        product_description = findViewById(R.id.productDescription)
        product_image = findViewById(R.id.productImage)

        var product = intent.getSerializableExtra("product")
        if (product != null) {
            var productInfo = product as Product
            product_name.text = productInfo.productName
            product_cost.text = "$${productInfo.productCost}"
            product_description.text = productInfo.productDescription
            product_image.setImageResource(productInfo.productImage)
        }
    }

    fun comeHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}