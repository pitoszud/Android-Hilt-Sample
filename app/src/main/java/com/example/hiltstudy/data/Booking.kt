package com.example.hiltstudy.data

import java.util.*

data class Booking(
    val bookingId: String = UUID.randomUUID().toString(),
    val venueName: String = ""
)
