package com.example.carrentalapp.domain.repository

import com.example.carrentalapp.domain.model.Rental

interface SpeedMonitorRepository {
    suspend fun getRentalById(rentalId: String): Rental?
    suspend fun reportSpeedViolation(rentalId: String, currentSpeed: Int)
    suspend fun warnUser(currentSpeed: Int)
}