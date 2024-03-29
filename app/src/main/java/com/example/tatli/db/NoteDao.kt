package com.example.tatli.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
  fun insert(note: Note)

    @Update
     fun update(note: Note)

    @Delete
     fun delete(note: Note)
}
