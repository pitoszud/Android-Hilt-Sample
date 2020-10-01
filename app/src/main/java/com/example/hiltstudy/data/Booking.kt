package com.example.hiltstudy.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "bookings")
data class Booking(
    @field:PrimaryKey
    @field:NonNull
    @field:ColumnInfo(name = "id")
    val bookingId: String = UUID.randomUUID().toString(),
    val venueName: String = ""
)
