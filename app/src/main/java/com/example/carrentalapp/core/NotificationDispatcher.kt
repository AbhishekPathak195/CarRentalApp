package com.example.carrentalapp.core

interface NotificationDispatcher {
    fun sendNotification(rentalId: String, speed: Int)
}