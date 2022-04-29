package com.example.allinonelearning.room

import androidx.room.*
import com.example.allinonelearning.room.entityPojo.Note

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addNote(note: Note)

    @Query("SELECT * FROM notes ")
    fun getNotes(): List<Note>

    @Update
     fun updateNote(note: Note)

    @Delete
     fun deleteNote(note: Note)
}