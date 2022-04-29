package com.example.allinonelearning.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.allinonelearning.room.entityPojo.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(NoteConverters::class)
abstract class NoteDatabase  : RoomDatabase() {

    abstract fun noteDao(): NotesDao

    companion object {

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "notes_database"
            ).allowMainThreadQueries()
                .build()
        }
    }
}