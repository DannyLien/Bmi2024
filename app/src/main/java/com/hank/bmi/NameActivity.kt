package com.hank.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hank.bmi.databinding.ActivityNameBinding

val names = listOf<String>(
    "Aaren", "Abbe", "Adele", "Carlyn",
    "Carol", "Cassy", "Claudia", "Dale",
    "Debra", "Ellen", "Gilberta", "Hallie",
    "Harlene", "Isabelle", "Jacklyn", "Jaimie",
    "Jenifer", "Kaitlin", "Kaja"
)

class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = NameAdapter(names)

    }

    fun btName(view: View) {
        finish()
    }

}