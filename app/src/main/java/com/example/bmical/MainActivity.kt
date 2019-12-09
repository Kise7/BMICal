package com.example.bmical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var BMIImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BMIImage = findViewById(R.id.imageViewProfile)

        buttonCal.setOnClickListener{
            calBMI()
        }

        buttonClear.setOnClickListener {
            reset()
        }
    }

    private fun calBMI() {
        val getHeight: EditText = findViewById(R.id.editTextHeight)
        val getWeight: EditText = findViewById(R.id.editTextWeight)

        val viewBMI : TextView = findViewById(R.id.textViewBMI)

        val height2 = getHeight.text.toString().toDouble()
        val weight = getWeight.text.toString().toDouble()

        val height: Double = height2/100
        val result: Double = weight/(height*height)

        val BMI = String.format("%.1f",result)

        viewBMI.setText("BMI :"+ String.format(BMI))

        if(result > 24.9){
            BMIImage.setImageResource(R.drawable.over)
        }else if(result >= 18.5 || result <= 24.9){
            BMIImage.setImageResource(R.drawable.normal)
        }else if(result < 18.5){
            BMIImage.setImageResource(R.drawable.under)
        }
    }

    fun reset() {
        val edit: EditText = findViewById(R.id.editTextHeight)
        val edit2: EditText = findViewById(R.id.editTextWeight)
        val text : TextView = findViewById(R.id.textViewBMI)
        edit.text.clear()
        edit2.text.clear()
        BMIImage.setImageResource(R.drawable.empty)
        text.setText("BMI :")
    }
}
