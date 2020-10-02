package com.example.hiltstudy.factories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.hiltstudy.fragments.BookingFragment
import javax.inject.Inject

class BookingFragmentFactory


    @Inject constructor(
        private val params: String
    ): FragmentFactory(){


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        // return super.instantiate(classLoader, className)
        return when(className){
            BookingFragment::class.java.name ->{
                 BookingFragment(params)
            }
            else -> super.instantiate(classLoader, className)
        }

    }
}
