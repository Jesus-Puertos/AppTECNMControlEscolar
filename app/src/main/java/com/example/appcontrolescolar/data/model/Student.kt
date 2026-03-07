package com.example.appcontrolescolar.data.model

data class Student(
    val id: Int,
    val controlNumber: String,
    val name: String,
    val career: String,
    val semester: Int,
    val average: Double
)