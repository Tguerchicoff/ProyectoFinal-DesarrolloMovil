package com.example.proyectofinal3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.animation.ValueAnimator
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        compareButton = findViewById(R.id.compareButton)
        resultText = findViewById(R.id.resultText)

        compareButton.setOnClickListener {
            compareStrings()
        }
    }

    private fun compareStrings() {
        val text1 = editText1.text.toString()
        val text2 = editText2.text.toString()

        val result: String
        val colorAnimation: ValueAnimator

        if (text1 == text2) {
            result = getString(R.string.same_text)
            colorAnimation = ValueAnimator.ofArgb(
                ContextCompat.getColor(this, R.color.color1),
                ContextCompat.getColor(this, R.color.color2),
                ContextCompat.getColor(this, R.color.color3),
                ContextCompat.getColor(this, R.color.color4)
            )
        } else {
            result = getString(R.string.different_text)
            colorAnimation = ValueAnimator.ofArgb(
                ContextCompat.getColor(this, R.color.color5),
                ContextCompat.getColor(this, R.color.color4)
            )
        }

        resultText.text = result
        colorAnimation.duration = 1000
        colorAnimation.addUpdateListener { animator ->
            resultText.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()
        if (text1 != text2) {
            resultText.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        }
    }

}