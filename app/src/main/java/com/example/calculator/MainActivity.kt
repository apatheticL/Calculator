package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }
    fun addFragment(){
        var fragment  = CalculatorFragment()
        supportFragmentManager.beginTransaction().add(R.id.frag,fragment,CalculatorFragment::class.java.name).commit()
    }
}