package com.example.quizappbasic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val GOOD_ANSWERS = "com.example.quizappbasic.GOOD_ANSWERS"
const val BAD_ANSWERS = "com.example.quizappbasic.BAD_ANSWERS"

class MainActivity3 : AppCompatActivity() {
    private lateinit var txtQuestion: TextView
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button
    private lateinit var gameModel: GameModel
    private lateinit var txt1: TextView

    private lateinit var question: Question

    private var dificulty = 3
    private var randomOrder: Array<Int> = arrayOf(10, 10, 10, 10)
    private lateinit var buttonsArray: Array<Button>


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        gameModel = GameModel(applicationContext)
        txtQuestion = findViewById(R.id.question_text)

        btnPrev = findViewById(R.id.prev_button)
        btnNext = findViewById(R.id.next_button)

        txt1 = findViewById(R.id.textView1)
        txt1.text = "${gameModel.positionQuestion()}/${gameModel.totalQuestion()}"

        question = gameModel.getCurrentQuestion()
        txtQuestion.text = question.text
        buttonsArray = arrayOf(
            Button(applicationContext),
            Button(applicationContext),
            Button(applicationContext),
            Button(applicationContext)
        )

        sortAnswers()
        addButtonsToView()
        createButtonsAnswers()

        btnPrev.setOnClickListener { view: View -> btnPrevNext(view) }
        btnNext.setOnClickListener { view: View -> btnPrevNext(view) }

    }

    fun btn_action(view: View): Unit {
        Toast.makeText(applicationContext, "Texto", Toast.LENGTH_SHORT).show()
    }

    private fun btnPrevNext(view: View): Unit {
        val btn: Button = view as Button
        val layoutRespuestas: LinearLayout = findViewById(R.id.layout_respuestas)
        layoutRespuestas.removeAllViews()
        if (btn.id == R.id.prev_button) {
            question = gameModel.previousQuestion()
            sortAnswers()
            createButtonsAnswers()
            addButtonsToView()
            unlockButtons()
            // noMoreQuestions()
            txtQuestion.text = question.text
            txtQuestion.setTextColor(resources.getColor(R.color.black))
            txt1.text = "${gameModel.positionQuestion()}/${gameModel.totalQuestion()}"
        } else if (btn.id == R.id.next_button) {
            question = gameModel.nextQuestion()
            sortAnswers()
            createButtonsAnswers()
            addButtonsToView()
            unlockButtons()
            noMoreQuestions()
            txtQuestion.text = question.text
            txtQuestion.setTextColor(resources.getColor(R.color.black))
            txt1.text = "${gameModel.positionQuestion()}/${gameModel.totalQuestion()}"
        }
        // Sección donde la pregunta es correcta o no
        // txtQuestion.setTextColor(if (!question.answered) default else if (question.correct) correct else incorrect)
    }

    fun noMoreQuestions(): Boolean {
        counterNoMoreQuestion = 0
        var questions = gameModel.getQuestions()

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
            println("Indice: $index, Counter: $counterNoMoreQuestion")
        }
        println("Counter: $counterNoMoreQuestion, Buenas: $goodAnswers, Malas: $badAnswers")

        if (counterNoMoreQuestion == gameModel.totalQuestion()) {
            val intent: Intent = Intent(applicationContext, MainActivity4::class.java).apply {
                putExtra(GOOD_ANSWERS, goodAnswers.toString())
                putExtra(BAD_ANSWERS, badAnswers.toString())
            }
            println("Counter: $counterNoMoreQuestion, Buenas: $goodAnswers, Malas: $badAnswers")
            startActivity(intent)
            finish()
        }
        return false
    }

    fun isCorrect() {
        val default = resources.getColor(R.color.black)
        val correct = resources.getColor(R.color.correct)
        val incorrect = resources.getColor(R.color.incorrect)
        txtQuestion.setTextColor(correct)
    }

    fun createButtonsAnswers() {
        for (index in 0..dificulty) {
            buttonsArray[index].setBackgroundColor(resources.getColor(R.color.white))
            buttonsArray[index].text = getString(R.string.btn, question.answers[randomOrder[index]])
            buttonsArray[index].setOnClickListener { view: View ->
                isAnswerCorrect(view as Button)
                //Toast.makeText(applicationContext, view.text, Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun addButtonsToView() {
        val layoutRespuestas: LinearLayout = findViewById(R.id.layout_respuestas)
        for (index in 0..dificulty) {
            buttonsArray[index]
            layoutRespuestas.addView(buttonsArray[index])
        }
    }

    fun sortAnswers() {
        randomOrder = arrayOf(10, 10, 10, 10)
        var index: Int = 0
        var loopController: Boolean = true
        while (loopController) {
            var number = (0..3).random()
            if (index == dificulty) {
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

    fun isAnswer(number: Int): Boolean {
        if (question.answers[number] == question.answers[4]) {
            return true
        }
        return false
    }

    fun answerInside(): Boolean {
        var inside = false
        for (index in 0..dificulty) {
            if (question.answers[randomOrder[index]] == question.answers[4]) {
                inside = true
            }
        }

        return inside
    }

    fun insertAnswer() {
        val number: Int = (0..dificulty).random()
        randomOrder[number] = 3
    }

    fun alreadyInside(array: Array<Int>, number: Int): Boolean {
        var inside = false
        for (index in 0..dificulty) {
            if (array[index] == number) {
                inside = true
            }
        }
        return inside
    }

    fun isAnswerCorrect(button: Button) {
        val correct = resources.getColor(R.color.correct)
        val incorrect = resources.getColor(R.color.incorrect)
        val answer = question.answers[4]
        if (answer == button.text) {
            button.setBackgroundColor(correct)
            question.answered = true
            question.correct = true
            lockButtons()
            txtQuestion.setTextColor(correct)
        } else {
            button.setBackgroundColor(incorrect)
            question.answered = true
            question.correct = false
            lockButtons()
            txtQuestion.setTextColor(incorrect)
        }
    }

    fun lockButtons() {
        for (element in buttonsArray) {
            element.isEnabled = false
        }
    }

    fun unlockButtons() {
        for (element in buttonsArray) {
            element.isEnabled = true
        }
    }

    companion object {
        var counterNoMoreQuestion: Int = 0
    }
}