package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.CartItem
import com.example.myapplication.ui.theme.MyApplicationTheme

// este es el composable para el carrito de compras
@Composable
fun ShoppingCart(
    cartItems: List<CartItem>,
    onIncrement: (CartItem) -> Unit, // funcion para aumentar la cantidad
    onDecrement: (CartItem) -> Unit, // funcion para disminuir la cantidad
    modifier: Modifier = Modifier
) {
    // usamos una lazycolumn para mostrar una lista de elementos que pueden ser mas grandes que la pantalla
    LazyColumn(modifier = modifier) {
        // usamos items para recorrer la lista de elementos del carrito
        items(cartItems) { item ->
            // usamos una fila para organizar el nombre y el precio del producto horizontalmente
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween, // distribuimos el espacio
                verticalAlignment = Alignment.CenterVertically // centramos verticalmente
            ) {
                // este es el nombre del producto
                Text(text = item.name)
                // esta es la seccion para la cantidad y los botones
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { onDecrement(item) }) {
                        Text("-")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = item.quantity.toString())
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { onIncrement(item) }) {
                        Text("+")
                    }
                }
            }
        }
    }
}

// esta es una vista previa para ver como se ve el carrito de compras
@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    MyApplicationTheme {
        ShoppingCart(
            cartItems = listOf(
                CartItem("Apple", 1.50, 2),
                CartItem("Banana", 0.75, 1),
                CartItem("Orange", 1.25, 3)
            ),
            onIncrement = {},
            onDecrement = {}
        )
    }
}
