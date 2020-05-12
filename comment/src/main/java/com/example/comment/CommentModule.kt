package com.example.comment

import dagger.Module
import dagger.Provides

@Module
class CommentModule {

    @Provides
    fun provideSomeManager(): SomeManager {
        return SomeManager()
    }
}