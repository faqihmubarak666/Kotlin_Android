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
            tvExpression.text = ""
            tvResult.text = ""
        }

        delCalc.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }
        equalCacl.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvResult.text = longResult.toString()
                } else {
                    tvResult.text = result.toString()
                }
            } catch (e: Exception) {
                Log.d("Exception", "message" + e.message)
            }
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean) {

        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}