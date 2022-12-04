package com.github.ameen.androidkotlintemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.ameen.androidkotlintemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}