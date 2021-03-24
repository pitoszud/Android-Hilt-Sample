package com.example.hiltstudy.di

import com.example.hiltstudy.data.BookingDataSource
import com.example.hiltstudy.data.BookingLocalDataSouce
import com.example.hiltstudy.data.BookingRemoteDataSource
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.repository.DefaultBookingRepository
import com.example.hiltstudy.services.AuthService
import com.example.hiltstudy.services.IBookingService
import com.example.hiltstudy.services.BookingService
import com.example.hiltstudy.services.IAuthService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


// @InstallIn is more efficient than @Provides

// @InstallIn(ApplicationComponent::class) replaced with @InstallIn(SingletonComponent::class) since 2.31.2-alpha
@InstallIn(SingletonComponent::class)
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
        bookingService: BookingService
    ): IBookingService


    @AuthServ
    @Singleton
    @Binds
    abstract fun bindAuthService(
        authService: AuthService
    ): IAuthService



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


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthServ






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
