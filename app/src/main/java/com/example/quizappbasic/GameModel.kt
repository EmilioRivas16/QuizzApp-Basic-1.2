package com.example.quizappbasic

import android.content.Context
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.slider.Slider
import java.util.concurrent.ThreadLocalRandom

class GameModel(context: Context) {
    val dataModel: DataModel = DataModel(context)
    var gameOptions = listOf<Game>(
        Game(
            listOf(
                dataModel.settOpts[1].checkSett,
                dataModel.settOpts[3].checkSett
            ), 0, 0, false
        )
    )

    fun randomNum(range: IntRange): Int {
        var num = (range).random()
        return num
    }

    fun randomListNum(rangeList: IntRange, rangeTake: IntRange): List<Int> {
        val randomNums = (rangeList).shuffled().take(randomNum(rangeTake))
        return randomNums
    }
}