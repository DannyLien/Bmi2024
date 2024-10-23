package com.hank.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.hank.bmi.databinding.ActivityNickBinding

class NickActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNickBinding
    private val TAG: String? = NickActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val level = intent.getIntExtra("EXTRA_LEVEL", 0)
        val name = intent.getStringExtra("NAME")
        Log.d(TAG, "onCreate: $level , $name")

    }


    fun save(view: View) {
        if (!binding.edNickname.text.toString().equals("")) {
            val nickname = binding.edNickname.text.toString()
            //SharedPreferences()
            getSharedPreferences("guess", MODE_PRIVATE)
                .edit()
                .putString("nickname", nickname)
                .apply()

            //Intent
            setResult(RESULT_OK, intent.putExtra("NICK", nickname))
            finish()

        }

    }

}