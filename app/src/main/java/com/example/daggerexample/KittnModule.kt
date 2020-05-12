package com.example.daggerexample

import com.example.comment.HostAnalytics
import dagger.Module
import dagger.Provides

@Module
class KittnModule {

    @Provides
    fun provideAnalytics(): HostAnalytics {
        return FirebaseAnalytics()
    }
}