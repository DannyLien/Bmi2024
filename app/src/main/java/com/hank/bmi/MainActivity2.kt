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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hank.bmi.databinding.ActivityMainBinding
import okhttp3.internal.notify
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewModel: GuessViewModel
    private val TAG: String? = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
//    val secret = (1..10).random()
//    val game = GuessGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Toast.makeText(this, "secret:${game.secret}", Toast.LENGTH_LONG).show()

        viewModel = ViewModelProvider(this).get(GuessViewModel::class.java)

        viewModel.secretData.observe(this, Observer { secret ->
            Toast.makeText(this, secret.toString(), Toast.LENGTH_SHORT).show()
            Log.d(TAG, "secret:$secret ")
        })

        viewModel.counter.observe(this, Observer { counter ->
            binding.counter.text = counter.toString()
        })

        viewModel.status.observe(this, Observer { status ->
            val message = when (status) {
                GameStatus.SMALLER -> "Smaller"
                GameStatus.BIGGER -> "Bigger"
                GameStatus.INIT -> ""
                else -> "You got it!"
            }
            if (status != GameStatus.INIT) {
                AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, which ->
                        binding.number.text.clear()
                    }
                    .setNegativeButton("Replay", { dialog, which ->
                        viewModel.reset()
                        binding.number.text.clear()
                    }).show()
            }
        })
    }

    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            viewModel.guess(binding.number.text.toString().toInt())

        } else {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_LONG).show()
        }
        /*
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
        */
    }

}