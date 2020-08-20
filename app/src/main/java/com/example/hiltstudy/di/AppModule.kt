package com.example.hiltstudy.di

import com.example.hiltstudy.services.VenueService
import com.example.hiltstudy.services.LocalVenueService
import com.example.hiltstudy.services.RemoteVenueService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier


// More efficient than @Provides
@InstallIn(ActivityComponent::class)
@Module
abstract class AppModule{

    @LocalImpl
    @ActivityScoped
    @Binds
    abstract fun bindLocalVenueService(
        localVenueService: LocalVenueService
    ): VenueService

    @RemoteImpl
    @ActivityScoped
    @Binds
    abstract fun bindRemoteVenueService(
        remoteVenueService: RemoteVenueService
    ): VenueService
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalImpl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteImpl






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
