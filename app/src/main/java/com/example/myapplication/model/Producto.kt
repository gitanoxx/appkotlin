package com.example.myapplication.model

import androidx.annotation.DrawableRes

// esta es una clase de datos que representa un producto
data class Producto(
    val nombre: String,
    val precio: Double,
    // usamos drawableres para el id de la imagen
    @DrawableRes val imagen: Int
)
