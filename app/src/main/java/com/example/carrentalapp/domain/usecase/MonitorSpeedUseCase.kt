package com.example.carrentalapp.domain.usecase

import com.example.carrentalapp.domain.repository.SpeedMonitorRepository
import javax.inject.Inject

class MonitorSpeedUseCase @Inject constructor(
    private val repository: SpeedMonitorRepository
) {
    suspend fun execute(rentalId: String, currentSpeed: Int) {
        val rental = repository.getRentalById(rentalId)
        rental?.let {
            if (currentSpeed > it.maxAllowedSpeed) {
                repository.reportSpeedViolation(rentalId, currentSpeed)
                repository.warnUser(currentSpeed)
            }
        }
    }
}