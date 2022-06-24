package com.christian_magana.myquizapp.views.quiz

import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.myquizapp.AnswerData
import com.christian_magana.myquizapp.QuestionData
import com.christian_magana.myquizapp.R
import com.christian_magana.myquizapp.databinding.ItemQuestionBinding

class QuestionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemQuestionBinding.bind(view)

    fun render(
        question: QuestionData,
        onClickOption: (Boolean) -> Unit
    ) {

        binding.tvQuestion.text = question.title

        binding.btnAnswer1.apply {
            text = question.answers[0].title
            background = ContextCompat.getDrawable(view.context, R.drawable.bg_answer)
            setOnClickListener {
                onClickOption(
                    checkIsCorrect(
                        question.answers[0],
                        binding.btnAnswer1
                    )
                )
            }
        }
        binding.btnAnswer2.apply {
            text = question.answers[1].title
            background = ContextCompat.getDrawable(view.context, R.drawable.bg_answer)
            setOnClickListener {
                onClickOption(
                    checkIsCorrect(
                        question.answers[1],
                        binding.btnAnswer2
                    )
                )
            }
        }

        binding.btnAnswer3.apply {
            text = question.answers[2].title
            background = ContextCompat.getDrawable(view.context, R.drawable.bg_answer)
            setOnClickListener {
                onClickOption(
                    checkIsCorrect(
                        question.answers[2],
                        binding.btnAnswer3
                    )
                )
            }
        }

    }



    private fun checkIsCorrect(answer: AnswerData, button: Button): Boolean {
        return if (answer.isCorrect) {
            button.background = ContextCompat.getDrawable(view.context, R.drawable.bg_correct_answer)
            true
        } else {
            button.background =
                ContextCompat.getDrawable(view.context, R.drawable.bg_incorrect_answer)
            false
        }
    }


}