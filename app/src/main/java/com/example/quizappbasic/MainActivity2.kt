package com.example.quizappbasic

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
const val SLIDER_NUM_QUESTIONS = "com.example.quizappbasic.SLIDER_NUM_QUESTIONS"
const val SLIDER_DIFFICULTY = "com.example.quizappbasic.SLIDER_DIFFICULTY"
const val CHEATS_ON = "com.example.quizappbasic.SLIDER_DIFFICULTY"
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
        val btnSave: Button = findViewById(R.id.save)

        //Inicializar configuración predeterminada
        recyclerView.adapter = RecyclerViewAdapter(dataModel.settOpts)
        sliderQuestions.value =
            sliderQuestions.valueFrom + gameModel.gameOptions.numQuestions * sliderQuestions.stepSize
        sliderDiff.value =
            sliderDiff.valueFrom + gameModel.gameOptions.difficulty * sliderDiff.stepSize
        switchCheats.isChecked = gameModel.gameOptions.cheats

        // Cambiar configuración de forma Aleatoria
        btnRandom.setOnClickListener {
            val randElements = gameModel.randomListNum(1..6, 1..6)
            for (i in randElements) {
                dataModel.settOpts[i].isSelected = true
            }
            recyclerView.adapter = RecyclerViewAdapter(dataModel.settOpts)
            val numRand = gameModel.randomNum(0..5)
            sliderQuestions.value = sliderQuestions.valueFrom + numRand * sliderQuestions.stepSize
            gameModel.gameOptions.numQuestions = numRand
        }

        // Cambia el número de preguntas con respecto al Slider correspondiente manipulado por el Usuario
        sliderQuestions.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                slider.value.toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                gameModel.gameOptions.numQuestions = slider.value.toInt()
            }
        })

        // Cambia la dificultad con respecto al Slider correspondiente manipulado por el Usuario
        sliderDiff.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                slider.value.toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                gameModel.gameOptions.difficulty = slider.value.toInt()
            }
        })

        // Cambiar permiso para el uso de Cheats
        switchCheats.setOnClickListener {
            gameModel.gameOptions.cheats = switchCheats.isChecked
        }

        btnSave.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity4::class.java).apply {
                putExtra(SLIDER_NUM_QUESTIONS, gameModel.gameOptions.numQuestions)
                putExtra(SLIDER_DIFFICULTY, gameModel.gameOptions.difficulty)
                //putExtra(CHEATS_ON, gameModel.gameOptions.cheats)
            }
            startActivity(intent)
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("numQuestions", gameModel.gameOptions.numQuestions)
        outState.putInt("difficulty", gameModel.gameOptions.difficulty)
        outState.putBoolean("cheats", gameModel.gameOptions.cheats)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val sliderQuestions: Slider = findViewById(R.id.slider_num_questions)
        val sliderDiff: Slider = findViewById(R.id.slider_difficulty)
        val switchCheats: SwitchCompat = findViewById(R.id.switch_cheats)

        sliderQuestions.value =
            sliderQuestions.valueFrom + savedInstanceState.getInt("numQuestions") * sliderQuestions.stepSize
        sliderDiff.value =
            sliderDiff.valueFrom + savedInstanceState.getInt("difficulty") * sliderDiff.stepSize
        switchCheats.isChecked = savedInstanceState.getBoolean("cheats")
    }
}