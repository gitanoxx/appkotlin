package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

// esta es la pantalla de inicio de sesion
@Composable
fun PantallaLogin(
    // esta es una funcion que llamamos cuando el inicio de sesion es exitoso
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier
) {
    // aqui guardamos el nombre de usuario y la contrasena que el usuario escribe
    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    // usamos una columna para organizar los elementos verticalmente
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // centramos verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // centramos horizontalmente
    ) {
        // este es el campo para que el usuario escriba su nombre
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        // un pequeno espacio entre los campos
        Spacer(modifier = Modifier.height(8.dp))
        // este es el campo para que el usuario escriba su contrasena
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )
        // un espacio mas grande antes del boton
        Spacer(modifier = Modifier.height(16.dp))
        // este es el boton para iniciar sesion
        Button(onClick = {
            // verificamos si el usuario y la contrasena son correctos
            if (usuario == "1" && contrasena == "1") {
                // si son correctos, llamamos a la funcion onloginsuccess
                onLoginSuccess()
            }
        }) {
            Text("Iniciar Sesión")
        }
        // un pequeno espacio
        Spacer(modifier = Modifier.height(8.dp))
        // este es el boton para iniciar sesion como invitado
        TextButton(onClick = { /* por ahora no hace nada */ }) {
            Text("Iniciar Sesión como invitado")
        }
        // un pequeno espacio
        Spacer(modifier = Modifier.height(8.dp))
        // este es el boton para registrarse
        TextButton(onClick = { /* por ahora no hace nada */ }) {
            Text("No tienes usuario, Regístrate")
        }
    }
}

// esta es una vista previa para ver como se ve la pantalla de inicio de sesion
@Preview(showBackground = true)
@Composable
fun PantallaLoginPreview() {
    MyApplicationTheme {
        PantallaLogin(onLoginSuccess = {})
    }
}
