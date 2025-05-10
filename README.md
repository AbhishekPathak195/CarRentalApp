# Car Rental Speed Monitoring – Android App

This Android application is a solution to a code assignment for a car rental company. The purpose is to monitor a rented vehicle’s speed and notify the company if the driver exceeds a specified speed limit. The app is built with modern Android development practices using Kotlin and Jetpack libraries.

## Features

1. **Clean Architecture:** The App is structured using clean architecture principles, with a clear separation of layers: Presentation, Domain and Data. This promotes scalability, maintainability and testability of the code.
2. **MVVM Architecture:** The app follows the MVVM (Model-View-ViewModel) architecture, separating concerns between the UI(View), business logic (ViewModel) and data (Model).
3. **Coroutines:** A coroutine is a concurrency design pattern that we can use on Android to simplify code that executes asynchronously.
5. **Kotlin flows:** In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
6. **Jetpack Compose:** Jetpack Compose is Android's recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
7. **Hilt Dependency Injection:** Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in the project.
8. **MockK:** MockK works great with Android and allows you to mock objects in both your Android unit tests and instrumented tests.
9. **Compose Testing:** UI testing in Jetpack Compose focuses on verifying the behavior and appearance of UI components, ensuring they function as intended.
