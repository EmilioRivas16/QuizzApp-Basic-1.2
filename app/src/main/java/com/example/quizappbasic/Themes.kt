package com.example.quizappbasic

data class Themes (
    val math: List<Question>,
    val lit: List<Question>,
    val history: List<Question>,
    val natSciences: List<Question>,
    val sports: List<Question>,
    val culture: List<Question>
)