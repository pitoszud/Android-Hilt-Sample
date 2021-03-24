package com.example.hiltstudy.di

import com.example.hiltstudy.data.BookingLocalDataSouce
import com.example.hiltstudy.data.BookingRemoteDataSource
import com.example.hiltstudy.database.BookingDao
import com.example.hiltstudy.services.BookingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
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
        bookingService: BookingService
    ): BookingRemoteDataSource{
        return BookingRemoteDataSource(bookingService)
    }

}