package com.example.quizappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    private lateinit var dataModel: DataModel
    private lateinit var gameModel: GameModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        dataModel = DataModel(this)
        gameModel = GameModel(this)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val btnRandom: Button = findViewById(R.id.btn_random)
        val sliderQuestions: Slider = findViewById(R.id.slider_num_questions)
        val sliderDiff: Slider = findViewById(R.id.slider_difficulty)
        val switchCheats: SwitchCompat = findViewById(R.id.switch_cheats)

        //Inicializar configuración predeterminada
        recyclerView.adapter = RecyclerViewAdapter(dataModel.settOpts)
        sliderQuestions.value =
            sliderQuestions.valueFrom + gameModel.gameOptions[0].numQuestions * sliderQuestions.stepSize
        sliderDiff.value =
            sliderDiff.valueFrom + gameModel.gameOptions[0].difficulty * sliderDiff.stepSize
        switchCheats.isChecked = gameModel.gameOptions[0].cheats

        // Cambiar configuración de forma Aleatoria
        btnRandom.setOnClickListener { v: View ->
            var numsRand = gameModel.randomListNum(1..6, 1..6)
            var numRand = gameModel.randomNum(0..5)
            println(numRand)
            sliderQuestions.value = sliderQuestions.valueFrom + numRand * sliderQuestions.stepSize
            gameModel.gameOptions[0].numQuestions = numRand
        }

        // Cambia el número de preguntas con respecto al Slider correspondiente manipulado por el Usuario
        sliderQuestions.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                slider.value.toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                gameModel.gameOptions[0].numQuestions = slider.value.toInt()
            }
        })

        // Cambia la dificultad con respecto al Slider correspondiente manipulado por el Usuario
        sliderDiff.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                slider.value.toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                gameModel.gameOptions[0].difficulty = slider.value.toInt()
            }
        })

        // Cambiar permiso para el uso de Cheats
        switchCheats.setOnClickListener { v: View ->
            gameModel.gameOptions[0].cheats = switchCheats.isChecked
        }
    }

}