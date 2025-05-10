package com.example.carrentalapp.data.repository

import com.example.carrentalapp.data.model.RentalDataModel
import com.example.carrentalapp.data.remote.FirebaseService
import com.example.carrentalapp.domain.model.Rental
import com.example.carrentalapp.domain.repository.SpeedMonitorRepository
import javax.inject.Inject

class SpeedMonitorRepositoryImpl @Inject constructor() : SpeedMonitorRepository {
    private val rentals = listOf(
        RentalDataModel("rental1", "customer1", 80),
        RentalDataModel("rental2", "customer2", 100)
    )

    override suspend fun getRentalById(rentalId: String): Rental? {
        return rentals.find { it.rentalId ==  rentalId }?.toDomain()
    }

    override suspend fun reportSpeedViolation(rentalId: String, currentSpeed: Int) {
        FirebaseService.notifyCompany(rentalId, currentSpeed)
    }

    override suspend fun warnUser(currentSpeed: Int) {
        println("Warning: Speed $currentSpeed km/h exceeded the limit!")
    }


}