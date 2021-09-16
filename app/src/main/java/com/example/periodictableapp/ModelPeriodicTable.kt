package com.example.periodictableapp

data class ModelPeriodicTable (
    val elementNumber: Int,
    val elementShortName: String,
    val elementLongName :String,
    val elementAtomicWeight: Double,
    val elementElectronConfig: String,
    val elementBackgroundColor: Int,
    val isVisible: Boolean
)