package com.hank.bmi

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Range
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.loader.content.AsyncTaskLoader
import androidx.room.Room
import com.google.gson.Gson
import com.hank.bmi.data.GameDatabase
import com.hank.bmi.data.Record
import com.hank.bmi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import org.json.JSONObject
import java.net.URL
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MainActivity2 : AppCompatActivity(), CoroutineScope {
    private lateinit var myViewModel: MyViewModel
    private val job = Job() + Dispatchers.IO
    private val NICKNAME_REQ: Int = 11
    private lateinit var viewModel: GuessViewModel
    private val TAG: String? = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    //    val secret = (1..10).random()
    //    val game = GuessGame()
    val requestNickname = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        //SharedPreferrences
        val nickname = getSharedPreferences("guess", MODE_PRIVATE).getString("nickname", null)
        Log.d(TAG, "MainActivity2: SharedPreferences: $nickname")
        //Intent
        if (it.resultCode == RESULT_OK) {
            val nickname = it.data?.getStringExtra("NICK")
            Log.d(TAG, "MainActivity2: Result: $nickname")
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Act86")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Act86")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ACT86")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Act86")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Act86")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Act86")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: Act86")

//        Toast.makeText(this, "secret:${game.secret}", Toast.LENGTH_LONG).show()

        viewModel = ViewModelProvider(this).get(GuessViewModel::class.java)

        viewModel.secretData.observe(this, Observer { secret ->
//            Toast.makeText(this, secret.toString(), Toast.LENGTH_SHORT).show()
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
                AlertDialog.Builder(this).setTitle("Info").setMessage(message)
                    .setPositiveButton("OK") { dialog, which ->
                        binding.number.text.clear()
                    }.setNegativeButton("Replay", { dialog, which ->
                        viewModel.reset()
                        binding.number.text.clear()
                    }).show()
            }
        })

        // Room
        val record1 = Record("Hank", 3)
        val record2 = Record("Eric", 4)
        val record3 = Record("Moon", 5)
        val record4 = Record("Tom ", 6)
        val record5 = Record("Jack", 7)
        Thread {
//            GameDatabase.getInstance(this)?.recordDao()?.insert(record1)
//            GameDatabase.getInstance(this)?.recordDao()?.insert(record2)
//            GameDatabase.getInstance(this)?.recordDao()?.insert(record3)
//            GameDatabase.getInstance(this)?.recordDao()?.insert(record4)
//            GameDatabase.getInstance(this)?.recordDao()?.insert(record5)
            GameDatabase.getInstance(this)?.recordDao()?.getAll()
                ?.forEach {
                    Log.d(
                        TAG, "MainActivity2: Room: " +
                                "${it.id} , ${it.nickname} , ${it.counter}"
                    )
                }
        }.start()

        // Json
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.readJSON()

    }

    fun btName(view: View) {
        val intent = Intent(this, NameActivity::class.java)
        startActivity(intent)
    }

    private fun parseJSON(json: String) {
        val jsonObject = JSONObject(json)
        val array = jsonObject.getJSONArray("words")
        for (i in 0..array.length() - 1) {
            val w = array.getJSONObject(i)
            val name = w.getString("name")
            val means = w.getString("means")
            Log.d(TAG, "MainActivity2: json: $name , $means")
        }
    }

    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            viewModel.guess(binding.number.text.toString().toInt())

        } else {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_LONG).show()
        }/*
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

    fun setNickname(view: View) {
//        val intent = Intent(this, NickActivity::class.java)
//        intent.putExtra("EXTRA_LEVEL", 777)
//        intent.putExtra("NAME", "Danny")
////        startActivity(intent)
////        startActivityForResult(intent, NICKNAME_REQ)
//        requestNickname.launch(intent)
        Intent(this, NickActivity::class.java).apply {
            putExtra("LEVEL", 555)
            putExtra("NAME", "Hank")
        }.also {
            requestNickname.launch(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NICKNAME_REQ) {
            Log.d(TAG, "MainActivity2, resultCode: $resultCode")
            val nickname = data?.getStringExtra("NICK")
            Log.d(TAG, "MainActivity2, data: $nickname")
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job

}