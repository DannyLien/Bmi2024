package com.hank.bmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {
    var secret = (1..10).random()
    var counter = MutableLiveData<Int>()
    var secretData = MutableLiveData<Int>()
    var status = MutableLiveData<GameStatus>()

    init {
        counter.value = 0
        status.value = GameStatus.INIT
        secretData.value = secret
    }

    fun guess(num: Int): GameStatus {
        var c = counter.value ?: 0
        c++
        counter.value = c

        return when (num - secret) {
            in 1..Int.MAX_VALUE -> GameStatus.SMALLER
            0 -> GameStatus.NUMBER_RIGHT
            else -> GameStatus.BIGGER
        }
    }

    fun reset() {
        counter.value = 0
        status.value = GameStatus.INIT
        secret = (1..10).random()
        secretData.value = secret
    }

}

enum class GameStatus {
    INIT, BIGGER, SMALLER, NUMBER_RIGHT
}