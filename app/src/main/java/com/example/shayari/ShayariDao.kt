package com.example.shayari

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShayariDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(shayari: DataEntity){

    }
    @Delete
    suspend fun delete(shayari: DataEntity){

    }
    @Update
   suspend fun update(shayari: DataEntity){

    }
    @Query("SELECT * FROM shayari_table ")
    fun getAllShayari():LiveData<List<DataEntity>>

    //we can use Flow that changes on runtime

   // fun getAllShayari():Flow<List<DataEntity>>

}
