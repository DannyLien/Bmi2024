package com.hank.bmi

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
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

    //    val secret = (1..10).random()
    val game = GuessGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "secret:${game.secret}", Toast.LENGTH_LONG).show()

    }

    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            val num = binding.number.text.toString().toInt()
            val massage = when (game.guess(num)) {
                GuessGame.Status.SMALLER -> getString(R.string.smaller)
                GuessGame.Status.BIGGER -> getString(R.string.bigger)
                else -> getString(R.string.you_got_it)
            }
            binding.counter.text = game.counter.toString()
            val okLisener = object : OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Log.d(TAG, "okLisener: ")
                    TODO()
                }
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(massage)
                .setPositiveButton(getString(R.string.ok), null)
                .setNeutralButton("Replay", { dialog, which ->
                    Log.d(TAG, "Replay: ")
                    game.reset()
                    binding.counter.text = game.counter.toString()
                    binding.number.text.clear()
                })
                .show()
        } else {
            Toast.makeText(this, getString(R.string.please_enter_a_number), Toast.LENGTH_LONG)
                .show()

        }

    }

}