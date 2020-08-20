package com.example.hiltstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiltstudy.services.AuthService
import com.example.hiltstudy.services.BookingServiceImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bookingServiceImpl: BookingServiceImpl

    @Inject lateinit var authService: AuthService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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