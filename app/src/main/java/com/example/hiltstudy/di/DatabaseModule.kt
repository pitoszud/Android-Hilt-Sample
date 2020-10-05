package com.example.hiltstudy.di

import android.content.Context
import com.example.hiltstudy.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule{


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getInstance(appContext)

    @Singleton
    @Provides
    fun provideBookingDao(db: AppDatabase) = db.bookingDao()
}