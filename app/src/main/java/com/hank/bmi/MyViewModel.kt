package com.hank.bmi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MyViewModel : ViewModel() {
    private val TAG: String? = MyViewModel::class.java.simpleName

    fun readJSON() {
        viewModelScope.launch(Dispatchers.IO) {
            val json = URL("https://api.jsonserve.com/pcLzBT").readText()
//            Log.d(TAG, "MyViewModel: json: $json")
//            parseJSON(json)
            val words = Gson().fromJson(json, Words::class.java)
            words.words.forEach {
                Log.d(
                    TAG,
                    "MyViewModel: gson: ${it.name}\n,${it.means},\n${it.difficulty},\n${it.star},\n"
                )
            }
        }
    }

}