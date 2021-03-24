package com.example.hiltstudy.di

import com.example.hiltstudy.data.BookingDataSource
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.repository.DefaultBookingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{


    @Singleton
    // @ActivityScoped
    @Provides
    fun provideDefaultRepository(
        @RemoteDataImpl bookingRemoteDataSouce: BookingDataSource,
        @LocalDataImpl bookingLocalDataSouce: BookingDataSource
    ): BookingRepository {
        return DefaultBookingRepository(bookingRemoteDataSouce, bookingLocalDataSouce)
    }
}