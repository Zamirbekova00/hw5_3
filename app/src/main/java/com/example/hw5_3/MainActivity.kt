package com.example.hw5_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw5_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .add(R.id.container, OperationFragment()).commit()
    }
}