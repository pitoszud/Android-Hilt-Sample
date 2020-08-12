package com.example.hiltstudy.data

import java.util.*

data class Venue(
    val venueId: String = UUID.randomUUID().toString(),
    val venueName: String = ""

)