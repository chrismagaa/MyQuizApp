package com.christian_magana.myquizapp.views.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.christian_magana.myquizapp.R
import com.christian_magana.myquizapp.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.btnPlay.setOnClickListener { findNavController().navigate(R.id.action_menuFragment_to_quizFragment) }
        binding.btnRanking.setOnClickListener { findNavController().navigate(R.id.action_menuFragment_to_rankingFragment) }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}