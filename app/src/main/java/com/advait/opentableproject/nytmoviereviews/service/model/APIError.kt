package com.advait.opentableproject.nytmoviereviews.service.model

class APIError {
    private val statusCode = 0
    private val message: String? = null
    fun status(): Int {
        return statusCode
    }

    fun message(): String? {
        return message
    }
}