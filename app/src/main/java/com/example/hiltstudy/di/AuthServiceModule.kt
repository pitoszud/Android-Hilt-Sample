package com.example.hiltstudy.di

import androidx.core.view.ViewCompat
import com.example.hiltstudy.services.AuthService
import com.example.hiltstudy.services.IAuthService
import com.example.hiltstudy.services.LocalVenueService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthServiceModule {


    @Singleton
    @Provides
    fun provideAuthService(
        localVenueService: LocalVenueService
    ) = AuthService(localVenueService) as IAuthService
}