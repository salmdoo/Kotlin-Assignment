package com.example.asignment5_shoppingcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
// kotlinx
import com.example.asignment5_shoppingcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var choseItems = ArrayList<String>()

    var productImages = intArrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5
    )
    var logoImages = intArrayOf(
        R.drawable.p1_logo,
        R.drawable.p2_logo,
        R.drawable.p3_logo,
        R.drawable.p4_logo,
        R.drawable.p5_logo,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val products = ArrayList<Product>()
//        products.add(Product(1, 1, "Speaker", "The speaker, with articulate expression and compelling delivery, captivates the audience with insightful perspectives and a commanding presence.", 30.5f))
//        products.add(Product(1, 2, "Laptop", "The laptop is a portable computer that combines sleek design with powerful functionality for on-the-go computing.", 1000.23f))
//        products.add(Product(1, 1, "Mobile", "A mobile is a handheld device that enables communication, internet access, and various applications in a compact and portable form.", 50.76f))
//        products.add(Product(1, 1, "Desktop", "A desktop is a stationary computer system with a separate monitor, keyboard, and processing unit designed for robust computing tasks.", 750.5f))
//        products.add(Product(1, 1, "Mouse", "A mouse is a small handheld device used to navigate and interact with a computer interface by moving the cursor on a screen.", 20.5f))
//        var myAdapter = ProductAdapter(products)


//        binding.rcv.layoutManager = GridLayoutManager(this, 1)
//        binding.rcv. adapter = myAdapter

        val names = resources.getStringArray(R.array.products)

        val desc = resources.getStringArray(R.array.desc)

        val resourcesArray = resources.obtainTypedArray(R.array.cost)

        val floatArray = FloatArray(resourcesArray.length())
        for (i in 0 until resourcesArray.length()) {
            floatArray[i] = resourcesArray.getFloat(i, 0.0f)
        }
        val costs = floatArray.toTypedArray()

        val rcv = binding.rcv;
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = MyAdapter(
            context = this,
            names = names,
            desc = desc,
            costs = costs,
            productImages = productImages,
            logoImages = logoImages,
            performAdd = { item ->
                choseItems.add(item)
            }
        )
    }

    fun viewCard(view: View) {
        val str = choseItems.joinToString(", ")
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}