package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var fragment: CalculatorFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    fun addFragment() {
        fragment = CalculatorFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentCalculator, fragment, CalculatorFragment::class.java.name).commit()
    }

    fun buttonNumberClick(view: View) {
        fragment.buttonNumberClick(view)
    }
}