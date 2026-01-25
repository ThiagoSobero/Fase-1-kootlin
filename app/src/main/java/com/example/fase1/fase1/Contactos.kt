package com.example.fase1.fase1

data class Contactos  (
    val name: String,
    val info: String
)

val Contacts = listOf(
    Contactos("Ana López", "Amiga"),
    Contactos("Carlos Pérez", "Trabajo"),
    Contactos("Lucía Gómez", "Familia"),
    Contactos("Mario Ruiz", "Gym")
)