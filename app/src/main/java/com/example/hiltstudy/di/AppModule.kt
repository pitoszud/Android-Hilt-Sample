package com.example.hiltstudy.di

import android.content.Context
import com.example.hiltstudy.data.BookingDataSource
import com.example.hiltstudy.data.BookingLocalDataSouce
import com.example.hiltstudy.data.BookingRemoteDataSource
import com.example.hiltstudy.database.AppDatabase
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.repository.DefaultBookingRepository
import com.example.hiltstudy.services.BookingService
import com.example.hiltstudy.services.BookingServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton


// More efficient than @Provides
// @InstallIn(ActivityComponent::class)
@InstallIn(ApplicationComponent::class)
@Module
abstract class AppModule{

    @LocalDataImpl
    // @ActivityScoped
    @Singleton
    @Binds
    abstract fun bindLocalDataSource(
        bookingLocalDataSouce: BookingLocalDataSouce
    ): BookingDataSource

    @RemoteDataImpl
    // @ActivityScoped
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        bookingRemoteDataSouce: BookingRemoteDataSource
    ): BookingDataSource


    @DefRepoImpl
    // @ActivityScoped
    @Singleton
    @Binds
    abstract fun bindDefaulRepository(
        defaultBookingRepository: DefaultBookingRepository
    ): BookingRepository


    @BookingServ
    // @ActivityScoped
    @Singleton
    @Binds
    abstract fun bindBookingService(
        bookingService: BookingServiceImpl
    ): BookingService



}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataImpl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataImpl


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefRepoImpl


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BookingServ






//@InstallIn(ApplicationComponent::class)
//@Module
//class AppModule{
//
//    @Singleton
//    @Provides
//    fun provideVenueService(): VenueService{
//        return VenueServiceImpl()
//    }
//}
