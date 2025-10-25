package com.example.myapplication.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.model.Carrito
import com.example.myapplication.ui.PantallaLogin
import com.example.myapplication.ui.PantallaPrincipal
import com.example.myapplication.ui.ShoppingCart
import com.example.myapplication.ui.theme.MyApplicationTheme

// esta es la actividad principal, el punto de entrada de la aplicacion
class MainActivity : ComponentActivity() {
    // el metodo oncreate se llama cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setcontent define el diseno de la actividad con composables
        setContent {
            MyApplicationTheme {
                // aqui usamos una variable para saber si el usuario ha iniciado sesion
                var sesionIniciada by remember { mutableStateOf(false) }
                // aqui definimos que pantalla se esta mostrando actualmente
                var pantallaActual by remember { mutableStateOf("login") }
                // creamos una instancia del carrito que se compartira en la aplicacion
                val carrito = remember { Carrito() }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // usamos un when para decidir que pantalla mostrar
                    when (pantallaActual) {
                        "login" -> {
                            PantallaLogin(
                                onLoginSuccess = { pantallaActual = "principal" },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        "principal" -> {
                            PantallaPrincipal(
                                carrito = carrito,
                                // le pasamos una funcion para navegar al carrito
                                onVerCarritoClick = { pantallaActual = "carrito" },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        "carrito" -> {
                            Column(modifier = Modifier.padding(innerPadding)) {
                                ShoppingCart(
                                    cartItems = carrito.items,
                                    onIncrement = { carrito.incrementarCantidad(it) },
                                    onDecrement = { carrito.disminuirCantidad(it) },
                                    modifier = Modifier.weight(1f) // para que ocupe todo el espacio disponible
                                )
                                Button(onClick = { pantallaActual = "principal" }) {
                                    Text("Volver a la Tienda")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
