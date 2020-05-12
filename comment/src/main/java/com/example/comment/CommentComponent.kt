package com.example.comment

import dagger.Component

@Component(modules = [CommentModule::class], dependencies = [HostComponent::class])
interface CommentComponent {
    fun exposeSomeManager(): SomeManager
}