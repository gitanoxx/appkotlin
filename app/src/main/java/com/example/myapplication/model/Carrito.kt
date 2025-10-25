package com.example.myapplication.model

import androidx.compose.runtime.toMutableStateList

// esta clase se encarga de gestionar el carrito de compras
class Carrito {
    // usamos una lista mutable para poder anadir y quitar productos
    private val _items = mutableListOf<CartItem>()
    val items: List<CartItem>
        get() = _items.toMutableStateList()

    // esta funcion anade un producto al carrito
    fun agregarProducto(producto: Producto) {
        // buscamos si el producto ya esta en el carrito
        val itemExistente = _items.find { it.name == producto.nombre }

        if (itemExistente != null) {
            // si ya existe, solo aumentamos la cantidad
            val index = _items.indexOf(itemExistente)
            _items[index] = itemExistente.copy(quantity = itemExistente.quantity + 1)
        } else {
            // si no existe, lo anadimos como un nuevo item
            _items.add(CartItem(producto.nombre, producto.precio, 1))
        }
    }

    // esta funcion aumenta la cantidad de un producto en el carrito
    fun incrementarCantidad(item: CartItem) {
        val index = _items.indexOf(item)
        if (index != -1) {
            _items[index] = item.copy(quantity = item.quantity + 1)
        }
    }

    // esta funcion disminuye la cantidad de un producto en el carrito
    fun disminuirCantidad(item: CartItem) {
        val index = _items.indexOf(item)
        if (index != -1) {
            if (item.quantity > 1) {
                _items[index] = item.copy(quantity = item.quantity - 1)
            } else {
                _items.removeAt(index)
            }
        }
    }
}
