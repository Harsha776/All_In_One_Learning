package com.example.allinonelearning.room.entityPojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.allinonelearning.room.NoteConverters
import java.util.*

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val dateAdded: Int?=null,
    @ColumnInfo(name = "noteText")
    val noteText: String,
    @ColumnInfo(name = "date")
    var date: Date) /*{

    fun dateToTimestamp(date:Date){
        this.date=date
    }

    fun fromTimestamp():Date?{
        return date
    }

}*/
