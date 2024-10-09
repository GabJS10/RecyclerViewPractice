package com.example.recyclerview.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.model.SuperHero
import com.example.recyclerview.model.SuperHeroProvider
import com.example.recyclerview.view.adapter.SuperHeroAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.viewModel.SuperHeroViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val SuperHeroViewModel: SuperHeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        SuperHeroViewModel.superHeroList.observe(this) { superHeroList ->
            (binding.rcView.adapter as SuperHeroAdapter).updateList(superHeroList)
        }
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        binding.rcView.layoutManager = manager
        binding.rcView.adapter = SuperHeroAdapter(emptyList()){
            superHero -> onItemSelected(superHero)
        }
        binding.rcView.addItemDecoration(decoration)
    }

    private fun onItemSelected(superHero: SuperHero){
        Toast.makeText(this,superHero.superheroName, Toast.LENGTH_SHORT).show()
    }
}