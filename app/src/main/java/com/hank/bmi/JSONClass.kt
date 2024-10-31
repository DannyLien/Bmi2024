package com.hank.bmi

data class Words(
    val words: List<Word>
)

data class Word(
    val difficulty: Int,
    val means: String,
    val name: String,
    val star: Int
)