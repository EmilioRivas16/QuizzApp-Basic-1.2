package com.example.quizappbasic

data class Game(
    var themes: List<*>,
    var numQuestions: Int,
    var difficulty: Int,
    var cheats: Boolean
)