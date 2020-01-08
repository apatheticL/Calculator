package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
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
        buttonDivision.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
        buttonMultiplication.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        button_subtraction.setOnClickListener(this)
        buttonPercent.setOnClickListener(this)
        buttonRemove.setOnClickListener(this)
        buttonNegative.setOnClickListener(this)
        buttonSqrt.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonMultiplication -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 1
                }
            }
            R.id.buttonPlus -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 2
                }
            }
            R.id.buttonNegative -> {
            }
            R.id.buttonDivision -> {
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
            R.id.buttonEqual -> {
                if (checkEmpty(result)) {
                    secondNumber = result.toDouble()
                    when (operater) {
                        1 -> {
                            textMath.text = ("$firstNumber * $secondNumber ")
                            textResult.text = (firstNumber * secondNumber).toString()
                        }
                        2 -> {
                            var t = firstNumber + secondNumber
                            textMath.text = ("$firstNumber + $secondNumber ")
                            textResult.text = t.toString()
                        }
                        3 -> {
                            if (!0.equals(secondNumber)) {
                                textMath.text = ("$firstNumber / $secondNumber ")
                                textResult.text = (firstNumber / secondNumber).toString()
                            }
                        }
                        4 -> {
                            textMath.text = ("$firstNumber - $secondNumber ")
                            textResult.text = (firstNumber - secondNumber).toString()
                        }
                    }
                }
                result = "0"
            }
            R.id.buttonRemove -> {
                textMath.text = "0"
                textResult.text = "0"
                result = "0"
                firstNumber = 0.0
                secondNumber = 0.0
                operater = 0
            }
            R.id.buttonSqrt -> {
                try {
                    textResult.text = (Math.sqrt(result.toDouble())).toString()
                } catch (e: Exception) {
                    makeText(context, e.toString(), LENGTH_LONG)
                }

            }
            R.id.buttonPercent -> {
                try {
                    var s: Double = textMath.text.toString().toDouble()
                    textResult.text = (s / 100).toString()
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
        textMath.text = result
    }

    fun addFirstNumber() {
        firstNumber = result.toDouble()
        result = "0"
    }
}