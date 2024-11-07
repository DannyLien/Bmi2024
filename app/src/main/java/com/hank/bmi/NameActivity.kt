package com.hank.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hank.bmi.databinding.ActivityNameBinding
import com.hank.bmi.vending.WordAdapter

val names = listOf<String>(
    "Aaren", "Abbe", "Adele", "Carlyn",
    "Carol", "Cassy", "Claudia", "Dale",
    "Debra", "Ellen", "Gilberta", "Hallie",
    "Harlene", "Isabelle", "Jacklyn", "Jaimie",
    "Jenifer", "Kaitlin", "Kaja"
)

class NameActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.readJSON()

        var recycler = binding.recycler
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.adapter = NameAdapter(names)
        myViewModel.words.observe(this) {
            recycler.adapter = WordAdapter(it)
        }

    }

    fun btNameFinish(view: View) {
        finish()
    }

}