package com.example.shayari

import android.app.Application

class MyApp:Application() {
    private val db by lazy { ShayariDb.getShayari(this) }
   // val repository by lazy { ShayariRepository(database.shayariDao()) }

}