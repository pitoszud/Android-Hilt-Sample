package com.example.hiltstudy.di

import com.example.hiltstudy.data.BookingDataSource
import com.example.hiltstudy.data.BookingLocalDataSouce
import com.example.hiltstudy.data.BookingRemoteDataSource
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.repository.DefaultBookingRepository
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