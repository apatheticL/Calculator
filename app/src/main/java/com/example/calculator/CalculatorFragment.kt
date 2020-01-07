package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator.*
import java.lang.Exception

class CalculatorFragment : Fragment(), View.OnClickListener {
    private var result = "0"
    private var firstNumber = 0.0
    private var secondNumber = 0.0
    private var operater = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
    }

    private fun configView() {
        button_division.setOnClickListener(this)
        button_equal.setOnClickListener(this)
        button_multiplication.setOnClickListener(this)
        button_plus.setOnClickListener(this)
        button_subtraction.setOnClickListener(this)
        button_percent.setOnClickListener(this)
        button_remove.setOnClickListener(this)
        button_negative.setOnClickListener(this)
        button_sqrt.setOnClickListener(this)
    }

    @SuppressLint("ShowToast")
    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_multiplication -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 1
                }
            }
            R.id.button_plus -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 2
                }
            }
            R.id.button_negative -> {
            }
            R.id.button_division -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 3
                }
            }
            R.id.button_subtraction -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 4
                }
            }
            // 1: nhan, 2 cong, 3 chia 4 tru
            R.id.button_equal -> {
                if (checkEmpty(result)) {
                    secondNumber = result.toDouble()
                    when (operater) {
                        1 -> {
                            text_math.text = ("$firstNumber * $secondNumber ")
                            text_result.text = (firstNumber * secondNumber).toString()
                        }
                        2 -> {
                            var t = firstNumber + secondNumber
                            text_math.text = ("$firstNumber + $secondNumber ")
                            text_result.text = t.toString()
                        }
                        3 -> {
                            if (!0.equals(secondNumber)) {
                                text_math.text = ("$firstNumber / $secondNumber ")
                                text_result.text = (firstNumber / secondNumber).toString()
                            }
                        }
                        4 -> {
                            text_math.text = ("$firstNumber - $secondNumber ")
                            text_result.text = (firstNumber - secondNumber).toString()
                        }
                    }
                }
                result = "0"
            }
            R.id.button_remove -> {
                text_math.text = "0"
                text_result.text = "0"
                result = "0"
                firstNumber = 0.0
                secondNumber = 0.0
                operater = 0
            }
            R.id.button_sqrt -> {
                try {
                    text_result.text = (Math.sqrt(result.toDouble())).toString()
                } catch (e: Exception) {
                    makeText(context, e.toString(), LENGTH_LONG)
                }

            }
            R.id.button_percent -> {
                try {
                    var s: Double = text_math.text.toString().toDouble()
                    text_result.text = (s / 100).toString()
                } catch (e: Exception) {
                    makeText(context, e.toString(), LENGTH_LONG)
                }
            }
        }
    }

    private fun check(str: String) {
        if (result.trim() == "0") {
            result = str
        } else {
            if (!result.contains(".")) {
                result += str
            } else if (!str.equals(".")) {
                result += str
            }
        }
    }

    private fun checkEmpty(str: String?): Boolean {
        if (str != null) {
            return true
        }
        return false
    }

    fun buttonNumberClick(view: View) {
        check((view as Button).text.toString())
        text_math.text = result
    }

    fun addFirstNumber() {
        firstNumber = result.toDouble()
        result = "0"
    }
}