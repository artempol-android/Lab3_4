package com.example.lab3_activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3_activity1.databinding.ActivityMainBinding
import com.example.lab3_activity1.databinding.ActivitySecondBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMain.setOnClickListener { toSecondActivity() }

        val bottom: BottomNavigationView = binding.bottomNav
        bottom.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.item_about_activity)
                startActivity(Intent(this, ActivityAbout::class.java))
            return@setOnItemSelectedListener true
        }
    }

    private fun toSecondActivity() {
        val intent = Intent(this, ActivitySecond::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }
}