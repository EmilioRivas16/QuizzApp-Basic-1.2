package com.example.quizappbasic

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnjugar: Button = findViewById(R.id.boton_jugar)

        btnjugar.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val btnopciones: Button = findViewById(R.id.boton_opciones)

        btnopciones.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}