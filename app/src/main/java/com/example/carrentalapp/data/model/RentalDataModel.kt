package com.example.carrentalapp.data.model

import com.example.carrentalapp.domain.model.Rental

data class RentalDataModel(
    val rentalId: String,
    val customerId: String,
    val maxAllowedSpeed: Int
) {
    fun toDomain(): Rental = Rental(rentalId, customerId, maxAllowedSpeed)
}