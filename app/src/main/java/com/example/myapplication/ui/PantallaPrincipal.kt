package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.model.Carrito
import com.example.myapplication.model.Producto
import com.example.myapplication.ui.theme.MyApplicationTheme

// esta es la pantalla principal que se muestra despues de iniciar sesion
@Composable
fun PantallaPrincipal(
    carrito: Carrito,
    onVerCarritoClick: () -> Unit, // funcion para navegar al carrito
    modifier: Modifier = Modifier
) {
    // aqui creamos una lista de productos de ejemplo
    val productos = listOf(
        Producto("Producto 1", 10.0, R.drawable.ic_launcher_foreground),
        Producto("Producto 2", 15.5, R.drawable.ic_launcher_foreground),
        Producto("Producto 3", 20.0, R.drawable.ic_launcher_foreground),
        Producto("Producto 4", 5.0, R.drawable.ic_launcher_foreground)
    )

    // usamos una columna para organizar los elementos verticalmente
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // centramos horizontalmente
    ) {
        // un texto de bienvenida para el administrador
        Text("Bienvenido, Administrador")
        // un espacio grande antes de las cajas
        Spacer(modifier = Modifier.height(16.dp))
        // boton para ver el carrito
        Button(onClick = onVerCarritoClick) {
            Text("Ver Carrito (${carrito.items.size})")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // usamos una fila para organizar las dos primeras cajas horizontalmente
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // distribuimos el espacio equitativamente
        ) {
            Caja(producto = productos[0], onProductoSeleccionado = { carrito.agregarProducto(it) })
            Caja(producto = productos[1], onProductoSeleccionado = { carrito.agregarProducto(it) })
        }
        // un espacio entre las filas de cajas
        Spacer(modifier = Modifier.height(16.dp))
        // usamos otra fila para las dos ultimas cajas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // distribuimos el espacio equitativamente
        ) {
            Caja(producto = productos[2], onProductoSeleccionado = { carrito.agregarProducto(it) })
            Caja(producto = productos[3], onProductoSeleccionado = { carrito.agregarProducto(it) })
        }
    }
}

// este es un composable para representar una caja con un producto
@Composable
fun Caja(
    producto: Producto,
    onProductoSeleccionado: (Producto) -> Unit, // funcion para notificar que un producto fue seleccionado
    modifier: Modifier = Modifier
) {
    // usamos una tarjeta para darle un aspecto de caja
    Card(modifier = modifier.size(width = 150.dp, height = 220.dp)) {
        // usamos una columna para organizar los elementos del producto verticalmente
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            // imagen del producto
            Image(painter = painterResource(id = producto.imagen), contentDescription = producto.nombre, modifier = Modifier.size(80.dp))
            // nombre del producto
            Text(text = producto.nombre)
            // precio del producto
            Text(text = "$${producto.precio}")
            // boton para seleccionar el producto
            Button(onClick = { onProductoSeleccionado(producto) }) {
                Text("Seleccionar")
            }
        }
    }
}

// esta es una vista previa para ver como se ve la pantalla principal
@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    MyApplicationTheme {
        PantallaPrincipal(carrito = Carrito(), onVerCarritoClick = {})
    }
}
