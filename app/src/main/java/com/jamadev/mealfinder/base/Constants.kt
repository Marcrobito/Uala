package com.jamadev.mealfinder.base


val environment = NetworkEnvironment.Production


enum class NetworkEnvironment{
    Staging(),
    QA(),
    Production()
}