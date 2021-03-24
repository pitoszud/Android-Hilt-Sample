package com.example.hiltstudy

import com.example.hiltstudy.di.AppModule
import dagger.Binds
import dagger.Module
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.junit.Before
import org.junit.Rule
import javax.inject.Singleton

@HiltAndroidTest
class MainTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltRule.inject()
    }

}



@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
abstract class FakeAppModule {

}
