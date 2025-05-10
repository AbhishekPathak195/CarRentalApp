package com.example.carrentalapp.data.remote

object FirebaseService {
    fun notifyCompany(rentalId: String, speed: Int) {
        // API call here
        println("Firebase Notification: Rental [$rentalId] exceeded speed at [$speed km/h]")
    }
}