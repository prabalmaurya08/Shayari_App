package com.example.shayari

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class DataRepository {

    companion object{
        private  var shayaridb:ShayariDb?=null
        private fun initializeDb(context: Context): ShayariDb? {
            return ShayariDb.getInstance(context)
        }

        //for inserting into database

        fun insert(context: Context,shayari: DataEntity){
            shayaridb=initializeDb(context)
            CoroutineScope(IO).launch {
                shayaridb!!.shayariDao().insert(shayari)
            }

        }

        fun getAllShayari(context: Context): LiveData<List<DataEntity> >?{
            shayaridb=initializeDb(context)
            return shayaridb?.shayariDao()?.getAllShayari()
        }

    }


}