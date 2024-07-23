
package com.example.calculator_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)

        findViewById<Button>(R.id.buttonAdd).setOnClickListener { calculate("+") }
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener { calculate("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { calculate("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { calculate("/") }
    }

    private fun calculate(operation: String) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            val resultValue = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else "Cannot divide by zero"
                else -> "Unknown operation"
            }
            result.text = resultValue.toString()
        } else {
            result.text = "Please enter valid numbers"
        }
    }
}