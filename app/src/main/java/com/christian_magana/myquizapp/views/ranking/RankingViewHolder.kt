package com.christian_magana.myquizapp.views.ranking

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.myquizapp.PlayerRecord
import com.christian_magana.myquizapp.R
import com.christian_magana.myquizapp.databinding.ItemRankingBinding

class RankingViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemRankingBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(position: Int, record: PlayerRecord){
        if(position == 0){
            binding.cvItem.backgroundTintList = ContextCompat.getColorStateList(view.context, R.color.primary_color)
        }else if(position == 1 || position == 2){
            binding.cvItem.backgroundTintList = ContextCompat.getColorStateList(view.context, R.color.primary_dark)
        }else{
            binding.cvItem.backgroundTintList = ContextCompat.getColorStateList(view.context, R.color.secondary_color)
        }

        binding.tvPosition.text = (position+1).toString()
        binding.tvName.text = record.name
        binding.tvPoints.text = record.score.toString()


}
}