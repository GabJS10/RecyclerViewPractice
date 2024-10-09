package com.example.recyclerview.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.model.SuperHero
import com.example.recyclerview.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)

    fun render(item: SuperHero, onClickListener: (SuperHero) -> Unit) {
        binding.tvSuperHeroName.text = item.superheroName
        binding.tvRealName.text = item.realName
        binding.tvPublisher.text = item.publisher
        Glide.with(binding.ivSuperHero.context).load(item.superheroImage).into(binding.ivSuperHero)

        itemView.setOnClickListener {onClickListener(item)}
    }
}