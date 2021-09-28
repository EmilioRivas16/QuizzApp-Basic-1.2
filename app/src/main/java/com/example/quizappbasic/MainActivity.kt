package com.example.quizappbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay: Button = findViewById(R.id.btn_play)

        btnPlay.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val btnSettings: Button = findViewById(R.id.btn_settings)

        btnSettings.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}