package com.example.shayari

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.Date
@Entity(tableName = "shayari_table")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    @ColumnInfo(name = "shayari_text")
    val shayari: String
)
