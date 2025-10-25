package com.example.myapplication.model

// esta es una clase de datos que representa un articulo en el carrito de compras
data class CartItem(
    // el nombre del articulo
    val name: String,
    // el precio del articulo
    val price: Double,
    // la cantidad del articulo, la hacemos variable para poder cambiarla
    var quantity: Int
)
