package com.example.quizappbasic

import android.content.Context

class GameModel(context: Context) {
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

    private val questions = Themes(
        listOf(), // Lista con preguntas de Matemáticas
        listOf(), // Lista con preguntas de Literatura
        listOf(), // Lista con preguntas de Historia
        listOf(), // Lista con preguntas de Ciencias Naturales
        listOf(), // Lista con preguntas de Deportes
        listOf() // Lista con preguntas de Cultura General
    )

    /*private val questions = listOf(
        Question(
            context.getString(R.string.pregunta1_pregunta),
            context.resources.getStringArray(R.array.pregunta1_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta2_pregunta),
            context.resources.getStringArray(R.array.pregunta2_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta3_pregunta),
            context.resources.getStringArray(R.array.pregunta3_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta4_pregunta),
            context.resources.getStringArray(R.array.pregunta4_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta5_pregunta),
            context.resources.getStringArray(R.array.pregunta5_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta6_pregunta),
            context.resources.getStringArray(R.array.pregunta6_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta7_pregunta),
            context.resources.getStringArray(R.array.pregunta7_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta8_pregunta),
            context.resources.getStringArray(R.array.pregunta8_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta9_pregunta),
            context.resources.getStringArray(R.array.pregunta9_respuestas)
        ),
        Question(
            context.getString(R.string.pregunta10_pregunta),
            context.resources.getStringArray(R.array.pregunta10_respuestas)
        )
    )*/
   /* private var currentQuestionIndex = 0

    fun getCurrentQuestion(): Question = questions[currentQuestionIndex]

    fun nextQuestion(): Question {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
        if (alreadyAnswerd(currentQuestionIndex)) {
            for (index in currentQuestionIndex until questions.size) {
                if (!questions[index].answered) {
                    currentQuestionIndex = index
                    break;
                }
            }
        }
        return questions[currentQuestionIndex]
    }

    fun alreadyAnswerd(index: Int): Boolean {
        var alreadyAnswerd = false
        if (questions[index].answered) {
            alreadyAnswerd = true
        }
        return alreadyAnswerd
    }

    *//*fun previousQuestion(): Question {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex -= 1
        } else {
            currentQuestionIndex = questions.size - 1
        }
        return questions[currentQuestionIndex]
    }*//*

    fun previousQuestion(): Question {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--
            if (alreadyAnswerd(currentQuestionIndex)) {
                for (index in currentQuestionIndex..0) {
                    println("Index en true: $index")
                    if (!questions[index].answered) {
                        currentQuestionIndex = index
                        break
                    }
                }
            }
        } else {
            currentQuestionIndex = questions.size - 1
            if (alreadyAnswerd(currentQuestionIndex)) {
                for (index in currentQuestionIndex..0) {
                    println("Index en false: $index")
                    if (!questions[index].answered) {
                        currentQuestionIndex = index
                        break
                    }
                }
            }
        }
        return questions[currentQuestionIndex]
    }

    fun positionQuestion(): Int = currentQuestionIndex + 1

    fun totalQuestion(): Int = questions.size

    fun getQuestions(): List<Question> = questions*/

}
