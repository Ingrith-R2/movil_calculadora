package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var pendingOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonEqual: Button = findViewById(R.id.buttonEqual)
        val buttonSin: Button = findViewById(R.id.buttonSin)
        val buttonCos: Button = findViewById(R.id.buttonCos)
        val buttonTan: Button = findViewById(R.id.buttonTan)

        val listener = View.OnClickListener { v: View ->
            val b = v as Button
            display.append(b.text)
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)

        buttonAdd.setOnClickListener { handleOperator("+") }
        buttonSubtract.setOnClickListener { handleOperator("-") }
        buttonMultiply.setOnClickListener { handleOperator("*") }
        buttonDivide.setOnClickListener { handleOperator("/") }
        buttonEqual.setOnClickListener { handleEqual() }
        buttonSin.setOnClickListener { performTrigOperation("sin") }
        buttonCos.setOnClickListener { performTrigOperation("cos") }
        buttonTan.setOnClickListener { performTrigOperation("tan") }
    }

    private fun handleOperator(operation: String) {
        if (display.text.isNotEmpty()) {
            operand1 = display.text.toString().toDouble()
        }
        pendingOperation = operation
        display.text = ""
    }

    private fun handleEqual() {
        if (display.text.isNotEmpty()) {
            operand2 = display.text.toString().toDouble()
            when (pendingOperation) {
                "+" -> operand1 += operand2
                "-" -> operand1 -= operand2
                "*" -> operand1 *= operand2
                "/" -> if (operand2 != 0.0) operand1 /= operand2
            }
            display.text = operand1.toString()
            operand1 = 0.0
            operand2 = 0.0
            pendingOperation = ""
        }
    }

    private fun performTrigOperation(operation: String) {
        if (display.text.isNotEmpty()) {
            val value = display.text.toString().toDouble()
            when (operation) {
                "sin" -> display.text = sin(value).toString()
                "cos" -> display.text = cos(value).toString()
                "tan" -> display.text = tan(value).toString()
            }
        }
    }
}
