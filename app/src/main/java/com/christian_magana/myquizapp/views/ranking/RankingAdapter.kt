package com.christian_magana.myquizapp.views.ranking

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.myquizapp.PlayerRecord
import com.christian_magana.myquizapp.R
import com.christian_magana.myquizapp.views.ranking.RankingViewHolder

class RankingAdapter(
    private var ranking: ArrayList<PlayerRecord>
): RecyclerView.Adapter<RankingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RankingViewHolder(
            inflater.inflate(
                R.layout.item_ranking,
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
            val ranking = ranking[position]
        holder.render(position, ranking)
    }


    override fun getItemCount(): Int = ranking.size





}