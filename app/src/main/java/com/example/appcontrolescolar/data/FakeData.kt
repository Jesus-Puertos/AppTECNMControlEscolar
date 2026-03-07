package com.example.appcontrolescolar.data

import com.example.appcontrolescolar.data.model.Building
import com.example.appcontrolescolar.data.model.ClassSession
import com.example.appcontrolescolar.data.model.Student

object FakeData {

    val student = Student(
        id = 1,
        controlNumber = "226W0487",
        name = "Arlyn Alfaro",
        career = "Ingeniería en Sistemas Computacionales",
        semester = 8,
        average = 92.5
    )

    val todayClasses = listOf(
        ClassSession(
            id = 1,
            subject = "Física I",
            teacher = "Prof. A. Einstein",
            classroom = "Aula A2",
            day = "Martes",
            startHour = "08:00",
            endHour = "09:00",
            isCurrent = false
        ),
        ClassSession(
            id = 2,
            subject = "Programación Orientada a Objetos",
            teacher = "Prof. G. Hopper",
            classroom = "Lab 3",
            day = "Martes",
            startHour = "10:00",
            endHour = "12:00",
            isCurrent = true
        ),
        ClassSession(
            id = 3,
            subject = "Inglés IV",
            teacher = "Prof. W. Shakespeare",
            classroom = "LC",
            day = "Martes",
            startHour = "13:00",
            endHour = "14:00",
            isCurrent = false
        ),
        ClassSession(
            id = 4,
            subject = "Cálculo Integral",
            teacher = "Prof. I. Newton",
            classroom = "B12",
            day = "Martes",
            startHour = "15:00",
            endHour = "16:00",
            isCurrent = false
        )
    )

    val buildings = listOf(
        Building(
            id = 1,
            name = "Edificio A",
            description = "Aulas generales",
            category = "Aulas",
            distance = "120 m"
        ),
        Building(
            id = 2,
            name = "Laboratorio 3",
            description = "Prácticas de computación",
            category = "Labs",
            distance = "180 m"
        ),
        Building(
            id = 3,
            name = "Cafetería Central",
            description = "Zona de alimentos",
            category = "Cafetería",
            distance = "220 m"
        )
    )
}