package com.christian_magana.myquizapp.views.ranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.christian_magana.myquizapp.PlayerRecord
import com.christian_magana.myquizapp.RankingQuiz
import com.christian_magana.myquizapp.databinding.FragmentRankingBinding
import com.christian_magana.myquizapp.provider.PreferencesKey
import com.christian_magana.myquizapp.provider.PreferencesProvider
import com.google.gson.Gson


class RankingFragment : Fragment() {

    private var _binding: FragmentRankingBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RankingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRankingBinding.inflate(inflater, container, false)

        setupAdapter()

        binding.ivBack.setOnClickListener { findNavController().popBackStack()  }

        return binding.root
    }

    private fun setupAdapter() {
        val strRankingQuiz = PreferencesProvider.string(requireContext(), PreferencesKey.RANKING_QUIZ)
        var ranking = RankingQuiz(arrayListOf())
        if(strRankingQuiz!=null){
            val rankingQuiz = Gson().fromJson(strRankingQuiz, RankingQuiz::class.java)
            ranking.listRanking = (rankingQuiz.listRanking)
            sortList(ranking.listRanking)
        }
        adapter= RankingAdapter(ranking.listRanking)
        binding.rvRanking.adapter = adapter
        binding.rvRanking.layoutManager = LinearLayoutManager(requireContext())
    }

    //sort list by score
    private fun sortList(list: ArrayList<PlayerRecord>){
        list.sortByDescending { it.score }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}