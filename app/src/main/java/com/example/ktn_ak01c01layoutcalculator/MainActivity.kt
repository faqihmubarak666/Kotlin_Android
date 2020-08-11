package com.example.ktn_ak01c01layoutcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        oneCalc.setOnClickListener { appendOnExpression("1", true) }
        twoCalc.setOnClickListener { appendOnExpression("2", true) }
        threeCalc.setOnClickListener { appendOnExpression("3", true) }
        fourCalc.setOnClickListener { appendOnExpression("4", true) }
        fiveCalc.setOnClickListener { appendOnExpression("5", true) }
        sixCalc.setOnClickListener { appendOnExpression("6", true) }
        sevenCalc.setOnClickListener { appendOnExpression("7", true) }
        eightCalc.setOnClickListener { appendOnExpression("8", true) }
        nineCalc.setOnClickListener { appendOnExpression("9", true) }
        zeroCalc.setOnClickListener { appendOnExpression("0", true) }

        //Operators
        additionCalc.setOnClickListener { appendOnExpression("+", true) }
        subtractionCalc.setOnClickListener { appendOnExpression("-", true) }
        multiplyCalc.setOnClickListener { appendOnExpression("*", true) }
        divisionCalc.setOnClickListener { appendOnExpression("/", true) }
        percentCalc.setOnClickListener { appendOnExpression("%", true) }

        clearCalc.setOnClickListener {
            inputExpression.text = ""
            resultExpression.text = ""
        }

        percentCalc.setOnClickListener {
            val inputNumber = inputExpression.text.toString()
            val result = inputNumber.toDouble() / 100
            resultExpression.text = result.toString()
        }

        delCalc.setOnClickListener {
            val pressButton = inputExpression.text.toString()
            if (pressButton.isNotEmpty()) {
                inputExpression.text = pressButton.substring(0, pressButton.length - 1)
            }
            resultExpression.text = ""
        }

        equalCacl.setOnClickListener {
            try {
                val inputNumber = ExpressionBuilder(inputExpression.text.toString()).build()
                val result = inputNumber.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    resultExpression.text = longResult.toString()
                } else {
                    resultExpression.text = result.toString()
                }
            } catch (e: Exception) {
                Log.d("Exception", "message" + e.message)
            }
        }
    }

    fun appendOnExpression(inputCalc: String, canClear: Boolean) {

        if (resultExpression.text.isNotEmpty()) {
            inputExpression.text = ""
        }
        if (canClear) {
            resultExpression.text = ""
            inputExpression.append(inputCalc)
        } else {
            inputExpression.append(resultExpression.text)
            inputExpression.append(inputCalc)
            resultExpression.text = ""
        }
    }
}