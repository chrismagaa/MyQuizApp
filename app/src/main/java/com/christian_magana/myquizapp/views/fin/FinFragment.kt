package com.christian_magana.myquizapp.views.fin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.christian_magana.myquizapp.PlayerRecord
import com.christian_magana.myquizapp.R
import com.christian_magana.myquizapp.RankingQuiz
import com.christian_magana.myquizapp.databinding.FragmentFinBinding
import com.christian_magana.myquizapp.provider.PreferencesKey
import com.christian_magana.myquizapp.provider.PreferencesProvider
import com.google.gson.Gson


class FinFragment : Fragment() {

    companion object{
        const val ARG_PARAM_PUNTAJE = "param_puntaje"
    }

    private var puntaje: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            puntaje = it.getInt(ARG_PARAM_PUNTAJE)
        }
    }


    private var _binding: FragmentFinBinding? = null
    private val binding get() = _binding!!
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFinBinding.inflate(inflater, container, false)

        puntaje?.let {binding.tvPuntos.text = "$it puntos"}


        binding.btnGuardar.setOnClickListener {
            val nombre  = binding.editTextNombre.editText!!.text.toString()
            if(nombre.isNotEmpty()){
                var playerRecord = PlayerRecord(nombre, puntaje?.toLong()?: 0)

                saveRanking(playerRecord)
                findNavController().navigate(R.id.action_finFragment_to_rankingFragment)

            }else{
                Toast.makeText(requireContext(), "Escribe tu nombre", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }

    private fun saveRanking(playerRecord: PlayerRecord) {
        val strRankingQuiz = PreferencesProvider.string(requireContext(), PreferencesKey.RANKING_QUIZ)
        var listRanking = arrayListOf<PlayerRecord>()

        if(!strRankingQuiz.isNullOrEmpty()){
            val rankingQuiz = Gson().fromJson(strRankingQuiz, RankingQuiz::class.java)
            listRanking = rankingQuiz.listRanking
            listRanking.add(playerRecord)
            val strNewRankingQuiz = Gson().toJson(rankingQuiz)
            PreferencesProvider.set(requireContext(), PreferencesKey.RANKING_QUIZ, strNewRankingQuiz)
        }else{
            listRanking.add(playerRecord)
            val rankingQuiz = RankingQuiz(listRanking)
            val strNewRankingQuiz = Gson().toJson(rankingQuiz)
            PreferencesProvider.set(requireContext(), PreferencesKey.RANKING_QUIZ, strNewRankingQuiz)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}