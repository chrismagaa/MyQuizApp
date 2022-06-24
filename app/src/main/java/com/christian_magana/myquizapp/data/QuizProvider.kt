package com.christian_magana.myquizapp.data

import com.christian_magana.myquizapp.AnswerData
import com.christian_magana.myquizapp.QuestionData

class QuizProvider {

    companion object {

        fun getQuestions() = listOf<QuestionData>(
            QuestionData(
                title = "¿Que podemos hacer diariamente para evitar el cambio climático?",
                answers = listOf(
                    AnswerData(title = "Sembrar y cuidar plantas y arboles", isCorrect = true),
                    AnswerData(title = "Compararme ropa y zapatos nuevos", isCorrect = false),
                    AnswerData(title = "Instalar focos led", isCorrect = true),
                )
            ),
            QuestionData(
                title = "¿Cuales de las siguientes opciones corresponden a una conducta ecológica responsable?",
                answers = listOf(
                    AnswerData(title = "Usar platos y cubiertos desechables", isCorrect = false),
                    AnswerData(title = "Tirar la basura en la calle", isCorrect = false),
                    AnswerData(title = "Utilizar la bicicleta", isCorrect = true)
                )
            ),
            QuestionData(
                title = "Estoy colaborando a mejorar el mundo a mi alrededor si...",
                answers = listOf(
                    AnswerData(title = "Compro cosas nuevas", isCorrect = false),
                    AnswerData(title = "Instalar paneles solares", isCorrect = true),
                    AnswerData(
                        title = "Utilizo envases plásticos de un solo uso",
                        isCorrect = false
                    ),
                )
            ),
            QuestionData(
                title = "La ciencia que estudia la naturaleza  y el medio ambiente es",
                answers = listOf(
                    AnswerData(title = "ecoturismo", isCorrect = false),
                    AnswerData(title = "la medicina", isCorrect = false),
                    AnswerData(title = "la biologia", isCorrect = true),
                )
            ),
            QuestionData(
                title = "Cuando hay mucha tala de árboles se llama",
                answers = listOf(
                    AnswerData(title = "polución", isCorrect = false),
                    AnswerData(title = "deforestación", isCorrect = true),
                    AnswerData(title = "contaminación del aire", isCorrect = false),
                )
            ),
            QuestionData(
                title = "Defina que es ecologia",
                answers = listOf(
                    AnswerData(title = "estudia los animales", isCorrect = false),
                    AnswerData(title = "estudia los lindos paisajes", isCorrect = false),
                    AnswerData(title = "estudia el medio y los seres vivos", isCorrect = true)
                )
            ),
            QuestionData(
                title = "Los factores bióticos son:",
                answers = listOf(
                    AnswerData(title = "plantas y animales.", isCorrect = true),
                    AnswerData(title = "plantas, suelo, aire y animales.", isCorrect = false),
                    AnswerData(title = "plantas, agua, luz y animales.", isCorrect = false),
                )
            ),
            QuestionData(
                title = "Los factores abióticos son:",
                answers = listOf(
                    AnswerData(title = "luz, temperatura, plantas, agua y aire.", isCorrect = false),
                    AnswerData(title = "luz, temperatura, agua y animales.", isCorrect = false),
                    AnswerData(title ="luz, agua, temperatura, suelo, gases atmosféricos. ", isCorrect = true),
                )
            ),
            QuestionData(
                title = "Una población se define como",
                answers = listOf(
                    AnswerData(title = "mas de dos individuos", isCorrect = false),
                    AnswerData(title = "un individuo", isCorrect = false),
                    AnswerData(title = "mas de dos individuos iguales", isCorrect = true)
                )
            ),
            QuestionData(
                title = "Lugar donde se desenvuelve un individuo en el ecosistema, se denomina",
                answers = listOf(
                    AnswerData(title = "Nicho ecológico", isCorrect = false),
                    AnswerData(title = "Hábitat", isCorrect = true),
                    AnswerData(title = "Biotipo", isCorrect = false),
                )
            ),
        )
    }


}