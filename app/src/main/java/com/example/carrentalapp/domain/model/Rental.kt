package com.example.carrentalapp.domain.model

data class Rental(
    val rentalId: String,
    val customerId: String,
    val maxAllowedSpeed: Int
)