package com.example.carrentalapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrentalapp.domain.usecase.MonitorSpeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeedMonitorViewModel @Inject constructor(
  private val monitorSpeedUseCase: MonitorSpeedUseCase
): ViewModel() {

    private val _speedWarnings = MutableSharedFlow<String>()
    val speedWarnings: SharedFlow<String> = _speedWarnings

    fun onSpeedUpdate(rentalId: String, speed: Int) {
         viewModelScope.launch {
             monitorSpeedUseCase.execute(rentalId, speed)
             _speedWarnings.emit("Checked speed: $speed km/h for rental $rentalId")
         }
    }

}