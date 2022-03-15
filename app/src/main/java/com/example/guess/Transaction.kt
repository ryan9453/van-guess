package com.example.guess

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Transaction (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val account: String,
    @ColumnInfo(name = "createAt")
    val date: String,
    val amount: Int,
    val type: Int) {

}