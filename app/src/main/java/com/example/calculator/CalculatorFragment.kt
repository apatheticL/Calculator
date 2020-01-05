package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator.*

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
        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_division.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_multiplication.setOnClickListener(this)
        btn_plus.setOnClickListener(this)
        btn_subtraction.setOnClickListener(this)
        btn_n.setOnClickListener(this)
        btn_remove.setOnClickListener(this)
        btn_negative.setOnClickListener(this)
        btn_sqrt.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_0 -> text_math.text = buttonNumberClick(view)
            R.id.btn_1 -> text_math.text = buttonNumberClick(view)
            R.id.btn_2 -> text_math.text = buttonNumberClick(view)
            R.id.btn_3 -> text_math.text = buttonNumberClick(view)
            R.id.btn_4 -> text_math.text = buttonNumberClick(view)
            R.id.btn_5 -> text_math.text = buttonNumberClick(view)
            R.id.btn_6 -> text_math.text = buttonNumberClick(view)
            R.id.btn_7 -> text_math.text = buttonNumberClick(view)
            R.id.btn_8 -> text_math.text = buttonNumberClick(view)
            R.id.btn_9 -> text_math.text = buttonNumberClick(view)
            R.id.btn_multiplication -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 1
                }
            }
            R.id.btn_plus -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 2
                }
            }
            R.id.btn_negative -> {
            }
            R.id.btn_division -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 3
                }
            }
            R.id.btn_subtraction -> {
                if (checkEmpty(result)) {
                    addFirstNumber()
                    operater = 4
                }
            }
            // 1: nhan, 2 cong, 3 chia 4 tru
            R.id.btn_equal -> {
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
            R.id.btn_remove -> {
                text_math.text = ""
                text_result.text = ""
                result = "0"
                firstNumber = 0.0
                secondNumber = 0.0
                operater = 0
            }
            R.id.btn_sqrt -> {

                text_result.text = (Math.sqrt(result.toDouble())).toString()
            }
            R.id.btn_n -> {
                var s: Double = text_math.text.toString().toDouble()
                text_result.text = (s / 100).toString()
            }

        }
    }

    private fun check(str: String) {
        if (!result.contains(".")) {
            if ((str.equals("0") && !str.equals(".")) || result.equals("0")) {
                result = str
            } else {
                result += str
            }
        } else if (!str.equals(".")) {
            result += str
        }
    }

    private fun checkEmpty(str: String?): Boolean {
        if (str != null) {
            return true
        }
        return false
    }

    fun buttonNumberClick(view: View): String {
        check((view as Button).text.toString())
        return result
    }

    fun addFirstNumber() {
        firstNumber = result.toDouble()
        result = "0"
    }
}