package com.example.comment

import javax.inject.Inject

class SomeManager @Inject constructor() {
    fun returnData(): String {
        return "some data"
    }
}

