package com.example.hiltstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hiltstudy.services.AuthService
import com.example.hiltstudy.services.BookingServiceImpl
import com.example.hiltstudy.viewmodel.BookingsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bookingServiceImpl: BookingServiceImpl

    @Inject lateinit var authService: AuthService

    @ExperimentalCoroutinesApi
    private val bookingsViewModel: BookingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookingsViewModel._bookings.observe(this, Observer {
            if (it.isNotEmpty()){
                val bookingName = it[0].venueName

                textView.text = bookingName
            }
        })

        book_button.setOnClickListener {
            book_button.setOnClickListener {
                if (authService.isAuthenticated()){
                    val bk = bookingServiceImpl.bookVenue()
                    textView.text = bk.venueName
                    //Toast.makeText(this, bk.venueName, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}