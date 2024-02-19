package com.example.tatli

import android.app.Application
import androidx.room.Room
import com.example.tatli.db.AppDatabase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
    companion object{
        lateinit var db :AppDatabase
    }
}