package com.example.quizappbasic

import android.content.Context
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.slider.Slider

class GameModel(context: Context) {
    val dataModel: DataModel = DataModel(context)
    var gameOptions = listOf<Game>(
        Game(
            listOf(
                dataModel.settOpts[1].isSelected,
                dataModel.settOpts[3].isSelected
            ), 5, 1, false
        )
    )

    // Cambia el número de preguntas con respecto al Slider correspondiente
    fun changeStatusNumQuestions(sliderView: Slider) {
        sliderView.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                slider.value.toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                gameOptions[0].numQuestions = slider.value.toInt()
            }
        })
    }

    // Cambia la dificultad del juego con respecto al Slider correspondiente
    fun changeStatusDifficulty(sliderView: Slider) {
        sliderView.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                slider.value.toString()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                gameOptions[0].difficulty = slider.value.toInt()
            }
        })
    }

    // Cambia el estado del uso de Ayudas con respecto al Switch
    fun changeSwitchState(switchView: SwitchCompat) {
        gameOptions[0].cheats = switchView.isChecked
    }
}