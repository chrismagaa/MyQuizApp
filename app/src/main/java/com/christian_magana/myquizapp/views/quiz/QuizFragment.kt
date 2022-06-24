package com.christian_magana.myquizapp.views.quiz

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.christian_magana.myquizapp.R
import com.christian_magana.myquizapp.databinding.FragmentQuizBinding
import com.christian_magana.myquizapp.data.QuizProvider
import com.christian_magana.myquizapp.views.fin.FinFragment
import com.yuyakaido.android.cardstackview.*


class QuizFragment : Fragment() {

    private val TIME_PER_QUESTION: Long = 31000
    private val TIME_BETWEEN_QUESTIONS: Long = 400


    private lateinit var manager: CardStackLayoutManager
    private lateinit var adapter: QuestionStackAdapter
    private lateinit var timerQuestion: CountDownTimer
    private var questionPosition: Int = 0
    private var puntaje: Int = 0
    private var isCorrectAnswer: Boolean = false
    private val questions = QuizProvider.getQuestions()

    private var _binding: FragmentQuizBinding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)

        setupAdapterManager()
        setupTimer()

        showNewQuestion()
        binding.tvPts.text = "$puntaje pts"

        return binding.root
    }


    private fun setupAdapterManager() {

        manager = CardStackLayoutManager(requireContext())
        manager.setCanScrollHorizontal(false)
        manager.setCanScrollVertical(false)

        adapter = QuestionStackAdapter(questions) { isCorrect ->
            isCorrectAnswer = isCorrect
            answerClicked(isCorrect)
        }

        binding.cardStackView.layoutManager = manager
        binding.cardStackView.adapter = adapter
        binding.cardStackView.itemAnimator = DefaultItemAnimator()
    }

    private fun setupTimer() {

        timerQuestion = object : CountDownTimer(TIME_PER_QUESTION, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var segundo = millisUntilFinished / 1000
                binding.tvTime.text = segundo.toString()
            }

            override fun onFinish() {
                answerClicked(false)
            }
        }
    }


    private fun showNewQuestion() {
        if (questionPosition != 0) {
            if (isCorrectAnswer) showNewQuestionView(Direction.Right)
            else showNewQuestionView(Direction.Left)
        }

        updateSteps()
        timerQuestion.start()
    }

    private fun showNewQuestionView(direction: Direction) {
        val setting = SwipeAnimationSetting.Builder()
            .setDirection(direction)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(AccelerateInterpolator())
            .build()
        manager.setSwipeAnimationSetting(setting)
        binding.cardStackView.swipe()
    }

    private fun updateSteps() {
        binding.tvNumPregunta.text = "Pregunta ${questionPosition + 1} de 10"
    }

    private fun setPoints(time: Int) {
        puntaje += time
        binding.tvPts.text = "$puntaje pts"
    }

    private fun nextQuestion() {
        questionPosition++
        if (questions.size <= questionPosition) {
            goToResult()
        } else {
            showNewQuestion()
        }
    }


    private fun answerClicked(correct: Boolean) {
        timerQuestion.cancel()
        Handler().postDelayed(
            {
                    updateView(correct)
            },
            TIME_BETWEEN_QUESTIONS // value in milliseconds
        )
    }

    private fun updateView(correct: Boolean) {
        if (correct) setPoints(binding.tvTime.text.toString().toInt())
        nextQuestion()
    }


    private fun goToResult() {
        val bundle = bundleOf(FinFragment.ARG_PARAM_PUNTAJE to puntaje)
        findNavController().navigate(R.id.action_quizFragment_to_finFragment, bundle)
    }

    override fun onPause() {
        super.onPause()
        timerQuestion.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}