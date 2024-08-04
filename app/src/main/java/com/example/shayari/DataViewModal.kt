package com.example.shayari

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class DataViewModal: ViewModel() {

    fun insert(context:Context, shayari: DataEntity){
        DataRepository.insert(context,shayari)
    }
    fun getAllShayari(context: Context): LiveData<List<DataEntity>>? {
        return DataRepository.getAllShayari(context)


    }


}