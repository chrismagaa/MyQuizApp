package com.christian_magana.myquizapp

import java.io.Serializable


class QuestionData(
    val title: String,
    val answers: List<AnswerData>
)

data class AnswerData(val title:String, val isCorrect:Boolean)


class PlayerRecord(
    val name: String,
    val score: Long
)

class RankingQuiz(
   var listRanking: ArrayList<PlayerRecord>
)