package com.hank.bmi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Record(
    @ColumnInfo(name = "nick")
    var nickname: String,
    var counter: Int,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
) {


}