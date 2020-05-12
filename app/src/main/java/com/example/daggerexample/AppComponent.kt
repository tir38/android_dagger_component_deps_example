package com.example.daggerexample

import com.example.comment.CommentComponent
import com.example.comment.HostAnalytics
import com.example.comment.HostComponent
import dagger.Component

@Component(
    modules = [KittnModule::class]
//    dependencies = [CommentComponent::class]
)
interface AppComponent : HostComponent {

    override fun provideAnalytics(): HostAnalytics

    fun inject(mainActivity: MainActivity)
}