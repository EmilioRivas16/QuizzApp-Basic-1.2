package com.example.quizappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    private lateinit var dataModel: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        dataModel = DataModel(this)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val btnRandom: Button = findViewById(R.id.btn_random)

        recyclerView.adapter = RecyclerViewAdapter(dataModel.settOpts)

        btnRandom.setOnClickListener { v: View ->
            val randomNums = List((1..6).random()) { RandomUnrepeated(1, 7).nextInt() }
            println(randomNums)
        }
    }

    class RandomUnrepeated(from: Int, to: Int) {
        private val numbers = (from..to).toMutableList()
        fun nextInt(): Int {
            val index = kotlin.random.Random.nextInt(numbers.size)
            val number = numbers[index]
            while (index == number) {
                numbers.removeAt(index)
            }
            return number
        }
    }
}