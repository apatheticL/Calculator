package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var string: String = "0"
    private var soA: Double = 0.0
    private var soB: Double = 0.0
    private var checkDot: Boolean = false
    private var operator: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        innit()
    }

    private fun innit() {

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

    fun buttonNumberClick(view: View) {
        check((view as Button).text.toString())
        edt_math.text = string
    }
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_multiplication -> {
                if (checkEmpty(string)) {
                    soA = string.toDouble()
                    string = "0"
                    operator = 1
                }

            }
            R.id.btn_plus -> {
                if (checkEmpty(string)) {
                    soA = string.toDouble()
                    string = "0"
                    operator = 2
                }

            }
            R.id.btn_negative -> {
                //so am

            }
            R.id.btn_division -> {
                if (checkEmpty(string)) {
                    soA = string.toDouble()
                    string = "0"
                    operator = 3
                }

            }
            R.id.btn_subtraction -> {
                if (checkEmpty(string)) {
                    soA = string.toDouble()
                    string = "0"
                    operator = 4
                }

            }
            // 1: nhan, 2 cong, 3 chia 4 tru
            R.id.btn_equal -> {
                if (checkEmpty(string)) {
                    soB = string.toDouble()

                    if (operator == 1) {
                        edt_math.text = ("$soA * $soB ")
                        edt_reb.text = (soA * soB).toString()
                    }
                    if (operator == 2) {
                        var t = soA + soB
                        edt_math.text = ("$soA + $soB ")
                        edt_reb.text = t.toString()
                    }
                    if (operator == 3) {
                        if (!0.equals(soB)) {
                            edt_math.text = ("$soA / $soB ")
                            edt_reb.text = (soA / soB).toString()
                        }
                    }
                    if (operator == 4) {
                        edt_math.text = ("$soA - $soB ")
                        edt_reb.text = (soA - soB).toString()

                    }
                }
                string = "0"
            }
            R.id.btn_remove -> {
                edt_reb.text = ""
                edt_math.text = ""
                string = "0"
                soA = 0.0
                soB = 0.0
                operator = 0
            }
            R.id.btn_sqrt -> {

                edt_reb.text = (Math.sqrt(string.toDouble())).toString()
            }
            R.id.btn_n -> {
                var s: Double = edt_math.text.toString().toDouble()
                edt_reb.text = (s / 100).toString()
            }

        }
    }

    // check th nhap nhieu so khong o dau thi nó mac dinh 1 so  va dau cham
    private fun check(str: String) {
        if (!string.contains(".")) {
            if ((str.equals("0") && !str.equals(".")) || string.equals("0")) {
                string = str
            } else {
                string += str
            }
        } else if (!str.equals(".")) {
            string += str
        }
    }

    private fun checkEmpty(str: String?): Boolean {
        if (str!=null)  {
            return true
        }
        return false
    }
}
