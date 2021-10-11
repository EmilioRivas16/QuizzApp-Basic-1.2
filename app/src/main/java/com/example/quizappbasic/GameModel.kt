package com.example.quizappbasic

import android.content.Context

class GameModel(context: Context) {
    val dataOptions: DataModel = DataModel(context)
    var gameOptions = Game(
        0,
        1,
        false // numQuestions se puede validar desde 0-5 o de 5-10 al igual que cheats desde 0-2 o de 1-3
    )

    fun randomNum(range: IntRange): Int {
        return (range).random()
    }

    fun randomListNum(rangeList: IntRange, rangeTake: IntRange): List<Int> {
        return (rangeList).take(randomNum(rangeTake))
    }

    private val questions = listOf(
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta1_pregunta),
            context.resources.getStringArray(R.array.pregunta1_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta1_l),
            context.resources.getStringArray(R.array.respuestas1_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta1_h),
            context.resources.getStringArray(R.array.respuestas1_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta1_cn),
            context.resources.getStringArray(R.array.respuestas1_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta1_d),
            context.resources.getStringArray(R.array.respuestas1_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta1_cg),
            context.resources.getStringArray(R.array.respuestas1_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta2_pregunta),
            context.resources.getStringArray(R.array.pregunta2_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta2_l),
            context.resources.getStringArray(R.array.respuestas2_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta2_h),
            context.resources.getStringArray(R.array.respuestas2_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta2_cn),
            context.resources.getStringArray(R.array.respuestas2_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta2_d),
            context.resources.getStringArray(R.array.respuestas2_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta2_cg),
            context.resources.getStringArray(R.array.respuestas2_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta3_pregunta),
            context.resources.getStringArray(R.array.pregunta3_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta3_l),
            context.resources.getStringArray(R.array.respuestas3_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta3_h),
            context.resources.getStringArray(R.array.respuestas3_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta3_cn),
            context.resources.getStringArray(R.array.respuestas3_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta3_d),
            context.resources.getStringArray(R.array.respuestas3_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta3_cg),
            context.resources.getStringArray(R.array.respuestas3_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta4_pregunta),
            context.resources.getStringArray(R.array.pregunta4_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta4_l),
            context.resources.getStringArray(R.array.respuestas4_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta4_h),
            context.resources.getStringArray(R.array.respuestas4_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta4_cn),
            context.resources.getStringArray(R.array.respuestas4_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta4_d),
            context.resources.getStringArray(R.array.respuestas4_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta4_cg),
            context.resources.getStringArray(R.array.respuestas4_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta5_pregunta),
            context.resources.getStringArray(R.array.pregunta5_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta5_l),
            context.resources.getStringArray(R.array.respuestas5_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta5_h),
            context.resources.getStringArray(R.array.respuestas5_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta5_cn),
            context.resources.getStringArray(R.array.respuestas5_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta5_d),
            context.resources.getStringArray(R.array.respuestas5_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta5_cg),
            context.resources.getStringArray(R.array.respuestas5_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta6_pregunta),
            context.resources.getStringArray(R.array.pregunta6_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta6_l),
            context.resources.getStringArray(R.array.respuestas6_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta6_h),
            context.resources.getStringArray(R.array.respuestas6_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta6_cn),
            context.resources.getStringArray(R.array.respuestas6_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta6_d),
            context.resources.getStringArray(R.array.respuestas6_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta6_cg),
            context.resources.getStringArray(R.array.respuestas6_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta7_pregunta),
            context.resources.getStringArray(R.array.pregunta7_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta7_l),
            context.resources.getStringArray(R.array.respuestas7_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta7_h),
            context.resources.getStringArray(R.array.respuestas7_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta7_cn),
            context.resources.getStringArray(R.array.respuestas7_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta7_d),
            context.resources.getStringArray(R.array.respuestas7_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta7_cg),
            context.resources.getStringArray(R.array.respuestas7_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta8_pregunta),
            context.resources.getStringArray(R.array.pregunta8_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta8_l),
            context.resources.getStringArray(R.array.respuestas8_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta8_h),
            context.resources.getStringArray(R.array.respuestas8_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta8_cn),
            context.resources.getStringArray(R.array.respuestas8_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta8_d),
            context.resources.getStringArray(R.array.respuestas8_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta8_cg),
            context.resources.getStringArray(R.array.respuestas8_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta9_pregunta),
            context.resources.getStringArray(R.array.pregunta9_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta9_l),
            context.resources.getStringArray(R.array.respuestas9_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta9_h),
            context.resources.getStringArray(R.array.respuestas9_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta9_cn),
            context.resources.getStringArray(R.array.respuestas9_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta9_d),
            context.resources.getStringArray(R.array.respuestas9_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta9_cg),
            context.resources.getStringArray(R.array.respuestas9_cg), false, false
        ),
        Question(
            context.getString(R.string.sett_opt2),
            context.getString(R.string.pregunta10_pregunta),
            context.resources.getStringArray(R.array.pregunta10_respuestas), false, false
        ),
        Question(
            context.getString(R.string.sett_opt3),
            context.getString(R.string.pregunta10_l),
            context.resources.getStringArray(R.array.respuestas10_l), false, false
        ),
        Question(
            context.getString(R.string.sett_opt4),
            context.getString(R.string.pregunta10_h),
            context.resources.getStringArray(R.array.respuestas10_h), false, false
        ),
        Question(
            context.getString(R.string.sett_opt5),
            context.getString(R.string.pregunta10_cn),
            context.resources.getStringArray(R.array.respuestas10_cn), false, false
        ),
        Question(
            context.getString(R.string.sett_opt6),
            context.getString(R.string.pregunta10_d),
            context.resources.getStringArray(R.array.respuestas10_d), false, false
        ),
        Question(
            context.getString(R.string.sett_opt7),
            context.getString(R.string.pregunta10_cg),
            context.resources.getStringArray(R.array.respuestas10_cg), false, false
        )
    )

    private var currentQuestionIndex = 0

    // Obtener los temas de la Configuración establecida por el usuario o configuración predeterminada
    private fun getCurrentThemes(): List<String> {
        val themes: MutableList<String> = mutableListOf()
        for (i in dataOptions.settOpts) {
            if (i.isSelected) {
                themes.add(i.checkSett)
            }
        }
        return themes
    }

    // Obtener las preguntas que hagan match con los Temas seleccionados
    fun getQuestions(): List<Question> {
        val newQuestions: MutableList<Question> = mutableListOf()
        for (i in getCurrentThemes()) {
            for (j in questions) {
                if (i == j.theme) {
                    newQuestions.add(j)
                }
            }
        }
        return newQuestions.shuffled().take(gameOptions.numQuestions)
    }

    // Obtiene la pregunta actual en la lista final de preguntas
    fun getCurrentQuestion(): Question = getQuestions()[currentQuestionIndex]

    fun totalQuestions(): Int {
        return getQuestions().size
    }

    fun initialPositionQuestion(): Int = currentQuestionIndex + 1

    fun nextQuestion(): Question {
        currentQuestionIndex = (currentQuestionIndex + 1) % totalQuestions()
        return getQuestions()[currentQuestionIndex]
    }

    fun previousQuestion(): Question {
        currentQuestionIndex = if (currentQuestionIndex <= 0) {
            totalQuestions() - 1
        } else {
            (currentQuestionIndex - 1) % totalQuestions()
        }
        return getQuestions()[currentQuestionIndex]
    }
}
