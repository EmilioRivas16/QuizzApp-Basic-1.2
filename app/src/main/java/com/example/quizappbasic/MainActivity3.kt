package com.example.quizappbasic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

const val GOOD_ANSWERS = "com.example.quizappbasic.GOOD_ANSWERS"
const val BAD_ANSWERS = "com.example.quizappbasic.BAD_ANSWERS"

class MainActivity3 : AppCompatActivity() {
    private lateinit var txtQuestion: TextView
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button
    private lateinit var gameModel: GameModel
    private lateinit var txt1: TextView

    private lateinit var question: Question
    private var randomOrder: Array<Int> = arrayOf(10, 10, 10, 10)
    private lateinit var buttonsArray: Array<Button>

    private lateinit var btnHint: Button

    private var cheatsAvailable: Int = 2

    var answerdWithOutCheat: Int = 1
    var answerCounter: Int = 1
    private var previousCheat: Boolean = false
    private var actualCheat: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        gameModel = GameModel(this)

        txtQuestion = findViewById(R.id.question_text)
        btnPrev = findViewById(R.id.prev_button)
        btnNext = findViewById(R.id.next_button)
        txt1 = findViewById(R.id.textView1)

        txt1.text = "${gameModel.initialPositionQuestion()}/${gameModel.totalQuestions()}"
        question = gameModel.getCurrentQuestion()
        txtQuestion.text = question.question
        buttonsArray = arrayOf(
            Button(this),
            Button(this),
            Button(this),
            Button(this)
        )

        sortAnswers()
        addButtonsToView()
        createButtonsAnswers()

        btnPrev.setOnClickListener { v: View ->
            btnPrevNext(v)
        }
        btnNext.setOnClickListener { v: View ->
            btnPrevNext(v)
        }

        btnHint = findViewById(R.id.hint)
        btnHint.setOnClickListener { view: View ->
            if (cheatsAvailable >= 1) {
                if (giveAHint()) {
                    cheatsAvailable--
                }
                Toast.makeText(
                    applicationContext,
                    "Tienes $cheatsAvailable pista/pistas",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(applicationContext, "Ya no tienes pistas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun btnPrevNext(view: View) {
        val btn: Button = view as Button
        val layoutRespuestas: LinearLayout = findViewById(R.id.layout_respuestas)
        layoutRespuestas.removeAllViews()
        if (btn.id == R.id.prev_button) {
            question = gameModel.previousQuestion()
            sortAnswers()
            createButtonsAnswers()
            addButtonsToView()
            valState()
            // noMoreQuestions()
            txtQuestion.text = question.question
            txt1.text = "${gameModel.initialPositionQuestion()}/${gameModel.totalQuestions()}"
        } else if (btn.id == R.id.next_button) {
            question = gameModel.nextQuestion()
            sortAnswers()
            createButtonsAnswers()
            addButtonsToView()
            valState()
            noMoreQuestions()
            txtQuestion.text = question.question
            txt1.text = "${gameModel.initialPositionQuestion()}/${gameModel.totalQuestions()}"
        }
    }

    private fun noMoreQuestions(): Boolean {
        counterNoMoreQuestion = 0
        val questions = gameModel.getQuestions()
        var goodAnswers = 0
        var badAnswers = 0

        for (index in questions.indices) {
            if (questions[index].correct) {
                goodAnswers++
            } else {
                badAnswers++
            }

            if (questions[index].answered) {
                counterNoMoreQuestion++
            }
        }

        if (counterNoMoreQuestion == gameModel.totalQuestions()) {
            val intent: Intent = Intent(applicationContext, MainActivity4::class.java).apply {
                putExtra(GOOD_ANSWERS, goodAnswers.toString())
                putExtra(BAD_ANSWERS, badAnswers.toString())
            }
            startActivity(intent)
            finish()
        }
        return false
    }

    private var difficulty = 3

    private fun createButtonsAnswers() {
        for (index in 0..difficulty) {
            buttonsArray[index].setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            buttonsArray[index].text = getString(R.string.btn, question.answers[randomOrder[index]])
            buttonsArray[index].setOnClickListener { view: View ->
                isAnswerCorrect(view as Button)
            }
        }
    }

    private fun addButtonsToView() {
        val layoutRespuestas: LinearLayout = findViewById(R.id.layout_respuestas)
        for (index in 0..difficulty) {
            buttonsArray[index]
            layoutRespuestas.addView(buttonsArray[index])
        }
    }

    private fun sortAnswers() {
        randomOrder = arrayOf(10, 10, 10, 10)
        var index = 0
        var loopController = true
        while (loopController) {
            val number = (0..3).random()
            if (index == difficulty) {
                loopController = false
            } else if (randomOrder[index] == 10) {
                randomOrder[index] = number
            } else if (!alreadyInside(randomOrder, number)) {
                index++
                randomOrder[index] = number
            }

        }
        if (!answerInside()) {
            insertAnswer()
        }
    }

    private fun answerInside(): Boolean {
        var inside = false
        for (index in 0..difficulty) {
            if (question.answers[randomOrder[index]] == question.answers[4]) {
                inside = true
            }
        }

        return inside
    }

    private fun insertAnswer() {
        val number: Int = (0..difficulty).random()
        randomOrder[number] = 3
    }

    private fun alreadyInside(array: Array<Int>, number: Int): Boolean {
        var inside = false
        for (index in 0..difficulty) {
            if (array[index] == number) {
                inside = true
            }
        }
        return inside
    }

    private fun isAnswerCorrect(button: Button) {
        val correct = ContextCompat.getColor(this, R.color.correct)
        val incorrect = ContextCompat.getColor(this, R.color.incorrect)
        val answer = question.answers[4]
        if (answer == button.text) {
            question.answered = true
            question.correct = true
            //button.setBackgroundColor(correct)
            txtQuestion.setTextColor(correct)
            Toast.makeText(this, R.string.correct_text, Toast.LENGTH_SHORT).show()
            //lockButtons()
            for (button in buttonsArray) {
                println("Texto del botón: ${button.text}")
                if (button.isEnabled == false) {
                    previousCheat = true
                    actualCheat = true
                    println("Se usó un cheat")
                    break
                }
            }

            if (answerCounter > 1) {
                println("Luego de la primera pregunta")
                println("Valor de previousCheat: $previousCheat y actualCheat: $actualCheat")
                if (previousCheat == false && actualCheat == false) {
                    println("Valor de answerdWithOutCheat: $answerdWithOutCheat, con modulo aplicado es: ${answerdWithOutCheat % 2}")
                    if (answerdWithOutCheat % 2 == 0) {
                        cheatsAvailable += 1
                        println("Se incrementó el número de cheats a $cheatsAvailable")
                    }
                    answerdWithOutCheat += 1
                    println("Valor de answerdWithOutCheat luego de incrementar: $answerdWithOutCheat")
                    println("No se hubo trampa en la respuesta del anterior")
                } else {
                    println("Hubo trampa en la respuesta del anterior")
                    previousCheat = actualCheat
                    actualCheat = false
                }
            } else {
                actualCheat = false
            }
        } else {
            question.answered = true
            question.correct = false
            //button.setBackgroundColor(incorrect)
            txtQuestion.setTextColor(incorrect)
            Toast.makeText(this, R.string.incorrect_text, Toast.LENGTH_SHORT).show()
            // lockButtons()
        }
        lockButtons()
        answerCounter++
    }

    private fun valState() {
        val default = ContextCompat.getColor(this, R.color.black)
        val correct = ContextCompat.getColor(this, R.color.correct)
        val incorrect = ContextCompat.getColor(this, R.color.incorrect)
        if (gameModel.getCurrentQuestion().answered) {
            if (gameModel.getCurrentQuestion().correct) {
                txtQuestion.setTextColor(correct)
                lockButtons()
            } else {
                txtQuestion.setTextColor(incorrect)
                lockButtons()
            }
        } else {
            txtQuestion.setTextColor(default)
            unlockButtons()
        }
    }

    private fun lockButtons() {
        for (element in buttonsArray) {
            element.isEnabled = false
        }
    }

    private fun unlockButtons() {
        for (element in buttonsArray) {
            element.isEnabled = true
        }
    }

    fun giveAHint(): Boolean {
        // var loopController = true
        // var index = 0
        while (true) {
            if (answerCounter == 5 && cheatsAvailable == 2) {
                println("Quinta pregunta")
            }
            val randomNumber = (0..50).random()
            val randomIndex = randomNumber % (difficulty + 1)

            // En dado caso de que no es tuvieran mas botones activos, se saldrá del while infinito
            var superControll = 0
            for (button in buttonsArray) {
                if (!button.isEnabled) superControll += 1
            }
            println("Valor de superControll: $superControll, valor de dificulty: ${difficulty + 1}")
            // Salida del while infinito
            if (superControll == difficulty || superControll == (difficulty + 1)) {
                println("Sale del ciclo de hints")
                return false
            }
            println("Valor de randomNumber: $randomNumber")
            println("Valor de randomIndex: $randomIndex")

            // Pinta y deshabilita un botón al azar, mientras no sea el botón de la respuestas
            if (buttonsArray[randomIndex].isEnabled) {
                if (buttonsArray[randomIndex].text != question.answers[4]) {
                    buttonsArray[randomIndex].background = getDrawable(R.drawable.drawable_button)
                    // buttonsArray[randomIndex].isClickable = false
                    buttonsArray[randomIndex].isEnabled = false
                    //buttonsArray[randomIndex].setBackgroundColor(resources.getColor(R.color.purple))
                    return true

                }
            }
        }
    }

    companion object {
        var counterNoMoreQuestion: Int = 0
    }
}