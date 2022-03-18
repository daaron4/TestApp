package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var digitOnScreen = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result_id.text = "0"

        initializeButtons()
    }

    private fun initializeButtons() {
        functionalButtons()
        operationalButtons()
        numericalButtons()
    }

    /**
     * This function initializes all of our numerical buttons from
     *  [0 - 9]
     */
    private fun numericalButtons() {

        one_btn.setOnClickListener {
            appendToDigitOnScreen("1")
        }

        two_btn.setOnClickListener {
            appendToDigitOnScreen("2")
        }

        three_btn.setOnClickListener {
            appendToDigitOnScreen("3")
        }

        four_btn.setOnClickListener {
            appendToDigitOnScreen("4")
        }

        five_btn.setOnClickListener {
            appendToDigitOnScreen("5")
        }

        six_btn.setOnClickListener {
            appendToDigitOnScreen("6")
        }

        seven_btn.setOnClickListener {
            appendToDigitOnScreen("7")
        }

        eight_btn.setOnClickListener {
            appendToDigitOnScreen("8")
        }

        nine_btn.setOnClickListener {
            appendToDigitOnScreen("9")
        }

        zero_btn.setOnClickListener {
            appendToDigitOnScreen("0")
        }

        dot_btn.setOnClickListener {
            appendToDigitOnScreen(".")
        }


    }

    /**
     *  Insert the button been clicked onto the screen so user can see
     *  inputs for the button clicked
     */
    private fun appendToDigitOnScreen(digit: String) {

        // Add each digit to our string builder
        digitOnScreen.append(digit)

        // display it on the screen of our mobile app
        result_id.text = digitOnScreen.toString()
    }

    /**
     *  Initialize the operation keys in our calculator like the
     *  addition key, subtraction key and the likes
     */
    private fun operationalButtons() {

        addition_btn.setOnClickListener {
            selectOperation('A')
        }

        subtract_btn.setOnClickListener {
            selectOperation('S')
        }

        divide_btn.setOnClickListener {
            selectOperation('D')
        }

        multipy_btn.setOnClickListener {
            selectOperation('M')
        }

    }

    /**
     * Function to assign operational sign to our math calculations
     */
    private fun selectOperation(c: Char) {

        operation = c
        leftHandSide = digitOnScreen.toString().toDouble()
        digitOnScreen.clear()
        result_id.text = ""

    }

    /**
     * Handles functional operations in out application like
     * clear button, backspace button and the clear everything button
     */
    private fun functionalButtons() {

        clear_everything_btn.setOnClickListener {
            digitOnScreen.clear()
            result_id.text = ""
        }

        clear_btn.setOnClickListener {
            clearDigit()
        }

        backspace_btn.setOnClickListener {
            clearDigit()
        }

        equal_btn.setOnClickListener {
            performMathOperation()
        }

    }


    /**
     *  This function performs our Math Operation which is then showed on the screen.
     */
    private fun performMathOperation() {

        rightHandSide = digitOnScreen.toString().toDouble()
        digitOnScreen.clear()

        when (operation) {

            'A' -> {
                val sum = OperationsHelper.add(leftHandSide, rightHandSide)
                result_id.text = sum.toString()
                digitOnScreen.append(sum)
            }
            'S' -> {
                val subtract = OperationsHelper.subtract(leftHandSide, rightHandSide)
                result_id.text = subtract.toString()
                digitOnScreen.append(subtract)
            }
            'M' -> {
                val multiply = OperationsHelper.multiply(leftHandSide, rightHandSide)
                result_id.text = multiply.toString()
                digitOnScreen.append(multiply)
            }
            'D' -> {
                val divide = OperationsHelper.divide(leftHandSide, rightHandSide)
                result_id.text = divide.toString()
                digitOnScreen.append(divide)
            }

        }

    }

    /**
     *  This function remove the last digit on the screen.
     */
    private fun clearDigit() {

        val length = digitOnScreen.length

        digitOnScreen.deleteCharAt(length - 1)
        result_id.text = digitOnScreen.toString()

    }


}