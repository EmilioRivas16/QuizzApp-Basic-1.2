package com.example.quizappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    var list = ArrayList<Int>()
    lateinit var adapter: RecyclerViewAdapter
    private var recyclerView: RecyclerView = findViewById(R.id.recycler_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setupData()

        adapter = RecyclerViewAdapter(list)
        recyclerView.adapter = adapter
    }

    private fun setupData() {
        for (i in 1..7) {
            list.add(i)
        }
    }
}