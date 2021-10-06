package com.example.quizappbasic

import android.content.Context
import com.google.android.material.slider.Slider

class OptionsView() {
    fun getSliderValue(sliderView : Slider): Float {
        return sliderView.value
    }
}