package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast

// AppCompatActivity：是 Activity 类的子类，提供向后兼容（兼容旧版本）
class MainActivity : AppCompatActivity() {

    // bad way: you should detect whether it is null every time you use it
    // val diceImageView : ImageView? = null
    // better way
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView

    // onCreate() 方法，是 life-cycle 方法，经常会使用并重载
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView() 方法，用来把 layout 绑定给当前的 Activity
        setContentView(R.layout.activity_main) // R 类，用于访问所有的资源文件，资源文件不带扩展名
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton : Button = findViewById(R.id.roll_button)
        // assign rollDice() as a click handler to the rollButton object
        rollButton.setOnClickListener { rollDice() }

//        val countUpButton : Button = findViewById(R.id.count_up_button)
//        countUpButton.setOnClickListener { countUp() }

//        val resetButton : Button = findViewById(R.id.reset_button)
//        resetButton.setOnClickListener { resetText() }
        val clearButton : Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener{ clearImage() }
    }

    private fun getRandomDiceImage() : Int {
        return (1..6).random()
    }
    // click-handler method to the Button
    // A click handler is a method that is invoked each time
    // the user clicks or taps on a clickable UI element, such as a button.
    private fun rollDice() {
        // A toast is a message that pops up the screen for a short time.
        //Toast.makeText(this, "button clicked",
        //    Toast.LENGTH_SHORT).show()

//        val resultText : TextView = findViewById(R.id.result_text)
        //resultText.text = "Dice Rolled!"
//        resultText.text = randomInt.toString()
//        val diceImage : ImageView = findViewById(R.id.dice_image)
        val randomInt1 = getRandomDiceImage()
        val randomInt2 = getRandomDiceImage()
        val drawableResource1 = when (randomInt1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
    }

    private fun countUp() {
//        val resultText : TextView = findViewById(R.id.result_text)
//        if (resultText.text.toString() == "Hello World!") {
//            var numberOne = 1
//            resultText.text = numberOne.toString()
//        }
//        if (resultText.text.toString().toInt() < 6) {
//            var currentNumber = resultText.text.toString().toInt()
//            currentNumber ++
//            resultText.text = currentNumber.toString()
//        }
    }

//    private fun resetText() {
////        val resultText : TextView = findViewById(R.id.result_text)
////        resultText.text = "0"
//        val diceImage : ImageView = findViewById(R.id.dice_image)
//        diceImage.setImageResource(R.drawable.dice_1)
//    }

    private fun clearImage() {
        diceImage.setImageResource(R.drawable.empty_dice)
    }
}
