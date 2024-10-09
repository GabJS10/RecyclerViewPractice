package com.example.recyclerview.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview.model.SuperHero
import com.example.recyclerview.model.SuperHeroProvider

class SuperHeroViewModel: ViewModel() {

     val superHeroList = MutableLiveData<List<SuperHero>>()

    init {
        loadSuperHeroes()
    }

    private fun loadSuperHeroes() {
        superHeroList.value = SuperHeroProvider.superHeroList
    }
}