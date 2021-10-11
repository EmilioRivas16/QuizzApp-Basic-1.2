package com.example.quizappbasic

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val myintent = intent
        val buenas = myintent.getStringExtra(GOOD_ANSWERS)
        val malas = myintent.getStringExtra(BAD_ANSWERS)

        findViewById<TextView>(R.id.totalDeBuenas).text = "El número de preguntas es: $buenas"
        findViewById<TextView>(R.id.totalDeMalas).text = "La dificultad es: $malas"
    }
}

