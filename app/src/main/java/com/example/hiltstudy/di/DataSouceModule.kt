package com.example.hiltstudy.di

import com.example.hiltstudy.data.BookingLocalDataSouce
import com.example.hiltstudy.data.BookingRemoteDataSource
import com.example.hiltstudy.database.BookingDao
import com.example.hiltstudy.services.BookingService
import com.example.hiltstudy.services.BookingServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
// @InstallIn(ActivityComponent::class)
object DataSouceModule {

    @Singleton
    // @ActivityScoped
    @Provides
    fun provideLocalDataSource(
        bookingDao: BookingDao
    ): BookingLocalDataSouce{
        return BookingLocalDataSouce(bookingDao)
    }


    @Singleton
    // @ActivityScoped
    @Provides
    fun provideRemoteDataSource(
        bookingService: BookingServiceImpl
    ): BookingRemoteDataSource{
        return BookingRemoteDataSource(bookingService)
    }

}