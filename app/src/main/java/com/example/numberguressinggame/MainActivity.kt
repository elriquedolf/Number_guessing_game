package com.example.numberguressinggame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var targetNumber: Int = 0
    private var attempts: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate a random number between 1 and 100
        targetNumber = Random.nextInt(1, 101)

        // When the "Guess" button is clicked, call the handleGuess() function
        guessButton.setOnClickListener {
            handleGuess()
        }
    }

    private fun handleGuess() {
        // Get the number entered by the user
        val guessString = guessInput.text.toString()

        // Check if the input is not empty
        if (guessString.isNotEmpty()) {
            val guess = guessString.toInt()

            // Compare the user's guess with the target number
            if (guess == targetNumber) {
                resultTextView.text = "Congratulations! You guessed the correct number in $attempts attempts."
                guessButton.isEnabled = false // Disable the "Guess" button
            } else if (guess < targetNumber) {
                resultTextView.text = "Your guess is too low. Try again."
            } else {
                resultTextView.text = "Your guess is too high. Try again."
            }
            attempts++ // Increment the number of attempts
        } else {
            resultTextView.text = "Please enter a number." // Show a message if the input is empty
        }
    }
}