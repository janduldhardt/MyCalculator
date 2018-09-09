package com.example.jan.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.udojava.evalex.Expression
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //******************************Declaring and assigning variables********************************

        val btnClear: Button = findViewById(R.id.btnDeleteAll)
        val btnDelete: Button = findViewById(R.id.btnDelete)
        val btnDivide: Button = findViewById(R.id.btnDivision)
        val btnMultiply: Button = findViewById(R.id.btnMultiplication)
        val btnMinus: Button = findViewById(R.id.btnMinus)
        val btnPlus: Button = findViewById(R.id.btnPlus)
        val btnResult: Button = findViewById(R.id.btnEqual)
        val btnPercent: Button = findViewById(R.id.btnPercentage)
        val btnPoint: Button = findViewById(R.id.btnPoint)

        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btn0: Button = findViewById(R.id.btn0)

        var tvProcess: TextView = findViewById(R.id.textViewOperation)
        var tvResult: TextView = findViewById(R.id.textViewResult)

        tvProcess.setText("0")
        tvResult.setText("0")


        //*************Number Buttons on-click funciton********************

        btn1.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("1")
            } else {
                tvProcess.setText(tvProcess.text.toString() + "1")
            }
        }

        btn2.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("2")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "2")
            }
        }

        btn3.setOnClickListener {
            if (tvProcess.text.equals("0")) {
            tvProcess.setText("3")

        } else {
            tvProcess.setText(tvProcess.text.toString() + "3")
        }
        }

        btn4.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("4")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "4")
            }
        }
        btn5.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("5")
            } else {
                tvProcess.setText(tvProcess.text.toString() + "5")
            }
        }
        btn6.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("6")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "6")
            }
        }
        btn7.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("7")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "7")
            }
        }
        btn8.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("8")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "8")
            }
        }
        btn9.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("9")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "9")
            }
        }
        btn0.setOnClickListener {
            if (tvProcess.text.equals("0")) {
                tvProcess.setText("0")

            } else {
                tvProcess.setText(tvProcess.text.toString() + "0")
            }
        }


        //*************Functional Buttons on-click function********************

        btnDivide.setOnClickListener { tvProcess.setText(tvProcess.text.toString() + "/") }
        btnMultiply.setOnClickListener { tvProcess.setText(tvProcess.text.toString() + "*") }
        btnMinus.setOnClickListener { tvProcess.setText(tvProcess.text.toString() + "-") }
        btnPlus.setOnClickListener { tvProcess.setText(tvProcess.text.toString() + "+") }
        btnPoint.setOnClickListener { tvProcess.setText(tvProcess.text.toString() + ".") }
        btnPercent.setOnClickListener { tvProcess.setText(tvProcess.text.toString() + "/100") }

        btnClear.setOnClickListener {
            tvProcess.setText("0")
            tvResult.setText("0")
        }

        btnDelete.setOnClickListener {
            var buffer = tvProcess.text
            if (buffer.length > 0) {
                buffer = buffer.substring(0, buffer.length - 1)
                tvProcess.setText(buffer)
            }
        }


        //****************Result / Equal Button onclick function*******************
        //***************Uses EvalEx Library: https://github.com/uklimaschewski/EvalEx ********************
        //************Converts String into arithmetic operation and displays the result in tvResult**************
        btnResult.setOnClickListener {
            var tvProcessString = tvProcess.text.toString()

            if (tvProcessString.endsWith('*') || tvProcessString.endsWith('/') || tvProcessString.endsWith('+') || tvProcessString.endsWith('-')) {
                //if the arithmetic operation ends with an Operator
                var buffer = tvProcessString
                buffer = buffer.substring(0, buffer.length - 1)
                var expression: Expression = Expression(buffer)
                var result: BigDecimal = expression.eval()
                tvResult.setText(result.toString())

            } else {
                var expression: Expression = Expression(tvProcess.text.toString())
                var result: BigDecimal = expression.eval()
                tvResult.setText(result.toString())
            }
        }
    }
}

