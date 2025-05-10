package com.example.carrentalapp.viewmodeltest

import com.example.carrentalapp.domain.model.Rental
import com.example.carrentalapp.domain.repository.SpeedMonitorRepository
import com.example.carrentalapp.domain.usecase.MonitorSpeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.anyString
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.never


@OptIn(ExperimentalCoroutinesApi::class)
class SpeedMonitorViewModelHiltTest {

    @Mock
    private lateinit var repository: SpeedMonitorRepository

    private lateinit var useCase: MonitorSpeedUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = MonitorSpeedUseCase(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should report and warn if current speed exceeds maxAllowedSpeed`() = runTest {

        val rentalId = "rental1"
        val currentSpeed = 90
        val customerID = "customer1"
        val rentalInfo = Rental(rentalId, customerID, maxAllowedSpeed = 80)

        `when`(repository.getRentalById(rentalId)).thenReturn(rentalInfo)

        useCase.execute(rentalId, currentSpeed)

        verify(repository).reportSpeedViolation(rentalId, currentSpeed)
        verify(repository).warnUser(currentSpeed)

    }

    @Test
    fun `should not report or warn if current speed is within limit`() = runTest {
        val rentalId = "rental1"
        val customerID = "customer1"
        val currentSpeed = 70
        val rentalInfo = Rental(rentalId, customerID, maxAllowedSpeed = 80)

        `when`(repository.getRentalById(rentalId)).thenReturn(rentalInfo)

        useCase.execute(rentalId, currentSpeed)

        verify(repository, never()).reportSpeedViolation(anyString(), anyInt())
        verify(repository, never()).warnUser(anyInt())

    }

    @Test
    fun `should do nothing if rental is null`() = runTest {
        val rentalId = "unknown"
        val currentSpeed = 100

        `when`(repository.getRentalById(rentalId)).thenReturn(null)

        useCase.execute(rentalId, currentSpeed)

        verify(repository, never()).reportSpeedViolation(anyString(), anyInt())
        verify(repository, never()).warnUser(anyInt())
    }


}