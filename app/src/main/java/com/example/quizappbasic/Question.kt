package com.example.quizappbasic

data class Question(
    val theme: String,
    val question: String,
    val answers: Array<String>,
    var answered: Boolean,
    var correct: Boolean
)