package com.example.carrentalapp.di

import com.example.carrentalapp.data.repository.SpeedMonitorRepositoryImpl
import com.example.carrentalapp.domain.repository.SpeedMonitorRepository
import com.example.carrentalapp.domain.usecase.MonitorSpeedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSpeedMonitorRepository(): SpeedMonitorRepository = SpeedMonitorRepositoryImpl()

    @Provides
    @Singleton
    fun provideMonitorSpeedUseCase(
        repository: SpeedMonitorRepository
    ): MonitorSpeedUseCase = MonitorSpeedUseCase(repository)

}