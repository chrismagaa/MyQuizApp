package com.christian_magana.myquizapp.views.quiz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.myquizapp.QuestionData
import com.christian_magana.myquizapp.R

class QuestionStackAdapter(
    private var questions: List<QuestionData>,
    private val onClickOption: (isCorrectAnswer: Boolean) -> Unit
) : RecyclerView.Adapter<QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return QuestionViewHolder(inflater.inflate(R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.render(questions[position], onClickOption)
    }

    override fun getItemCount(): Int = questions.size

}