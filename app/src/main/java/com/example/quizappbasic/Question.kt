package com.example.quizappbasic

data class Question(
    val question: String,
    val answers: Array<String>,
    var answered: Boolean = false,
    var correct: Boolean = false
)