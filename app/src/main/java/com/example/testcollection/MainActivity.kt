package com.example.testcollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testcollection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}