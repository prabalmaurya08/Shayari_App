package com.example.shayari

import DataEntity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ShayariDao {

    @Insert
    suspend fun insert(shayari:DataEntity){

    }
    @Update
   suspend fun delete(shayari:DataEntity){

    }
    @Query("SELECT * FROM shayari_table ORDER BY date DESC")
    fun getAllShayari():List<DataEntity>{
        return emptyList()
    }
}
