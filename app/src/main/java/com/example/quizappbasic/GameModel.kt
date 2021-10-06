package com.example.quizappbasic

import android.content.Context

class GameModel(context: Context) {
    private val dataModel: DataModel = DataModel(context)
    var gameOptions = Game(
        listOf(
            dataModel.settOpts[1],
            dataModel.settOpts[3]
        ),
        0,
        0,
        false // numQuestions se puede validar desde 0-5 o de 5-10 al igual que cheats desde 0-2 o de 1-3
    )

    fun randomNum(range: IntRange): Int {
        return (range).random()
    }

    fun randomListNum(rangeList: IntRange, rangeTake: IntRange): List<Int> {
        return (rangeList).shuffled().take(randomNum(rangeTake))
    }
}