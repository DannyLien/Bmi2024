package com.hank.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Range
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hank.bmi.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    private val TAG: String? = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    val secret = (1..10).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "secret:$secret", Toast.LENGTH_LONG).show()

    }

    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            val num = binding.number.text.toString().toInt()
            Log.d(TAG, "guess: $num")
            val message = if (num > secret) {
                "Smaller"
            } else if (num < secret) {
                "Bigger"
            } else {
                "You got it!"
            }
            AlertDialog.Builder(this)
                .setTitle("Info")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        } else {
            Toast.makeText(this, "Please enter a number ", Toast.LENGTH_LONG).show()

        }

    }

}