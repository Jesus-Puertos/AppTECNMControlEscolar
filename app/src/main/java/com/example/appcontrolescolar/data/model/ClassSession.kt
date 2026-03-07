package com.example.appcontrolescolar.data.model

data class ClassSession(
    val id: Int,
    val subject: String,
    val teacher: String,
    val classroom: String,
    val day: String,
    val startHour: String,
    val endHour: String,
    val isCurrent: Boolean = false
)