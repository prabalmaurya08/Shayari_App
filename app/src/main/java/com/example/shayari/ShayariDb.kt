package com.example.shayari

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


import androidx.room.TypeConverters

@Database(
    entities = [DataEntity::class],
version = 1,
exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ShayariDb:RoomDatabase() {
    //provide access to DAO classes
    abstract fun shayariDao(): ShayariDao

    //make a instance that will help to create the database


    companion object {
        private var INSTANCE: ShayariDb? = null
        public fun getShayari(context:Context):ShayariDb{
            if(INSTANCE!=null){

                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,ShayariDb::class.java,"shayari_db").build()

                }

            }
            return INSTANCE!!
        }
    }
}