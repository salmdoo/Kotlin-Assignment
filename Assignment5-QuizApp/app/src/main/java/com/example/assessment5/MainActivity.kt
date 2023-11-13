package com.example.assessment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.time.LocalTime
import java.util.Date

class MainActivity : AppCompatActivity() {
    private var answerQ1 = false
    private var answerQ2 = 0
    private var result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCheckClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.cb1, R.id.cb3 -> {
                    if (checked) {
                        answerQ2++
                    } else {
                        answerQ2 --
                    }
                }
                else -> {
                    if (checked) {
                        answerQ2 --
                    }else {
                        answerQ2 ++
                    }
                }
            }
        }
        if (view is RadioButton) {
            val checked: Boolean = view.isChecked

            answerQ1 = view.id == R.id.rb3 && checked
        }
    }

    private fun reset(){
        answerQ1 = false
        answerQ2 = 0
        result = 0

        val cb1: CheckBox = findViewById(R.id.cb1)
        cb1.isChecked = false
        val cb2: CheckBox = findViewById(R.id.cb2)
        cb2.isChecked = false
        val cb3: CheckBox = findViewById(R.id.cb3)
        cb3.isChecked = false
        val cb4: CheckBox = findViewById(R.id.cb4)
        cb4.isChecked = false

        val rb1: RadioButton = findViewById(R.id.rb1)
        rb1.isChecked = false
        val rb2: RadioButton = findViewById(R.id.rb2)
        rb2.isChecked = false
        val rb3: RadioButton = findViewById(R.id.rb3)
        rb3.isChecked = false
        val rb4: RadioButton = findViewById(R.id.rb4)
        rb4.isChecked = false

    }

    fun submit(view: View){
        if (answerQ1) {
            result += 50
        }
        if (answerQ2 == 2) {
            result += 50
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Quiz Result")
        builder.setMessage("“CongratulaCons! You submiKed on ${LocalTime.now()}, you achieved $result%")
//        builder.setIcon()
        builder.setPositiveButton("Reset"){ dialogIntefrace, which ->
            reset()
            dialogIntefrace.dismiss()
//            finish()
        }
        builder.setNegativeButton("Cancel"){ dialogInterface, which ->
            result = 0
            dialogInterface.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}