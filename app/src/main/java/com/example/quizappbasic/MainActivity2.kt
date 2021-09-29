package com.example.quizappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = RecyclerViewAdapter(
            listOf(
                getString(R.string.sett_opt1),
                getString(R.string.sett_opt2),
                getString(R.string.sett_opt3),
                getString(R.string.sett_opt4),
                getString(R.string.sett_opt5),
                getString(R.string.sett_opt6),
                getString(R.string.sett_opt7)
            )
        )
    }
}