package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pe.idat.altaredshop.R

@Composable
fun perfilScreen() {
    // Estado para los campos de texto
    val nombre = remember { mutableStateOf("") }
    val apellido = remember { mutableStateOf("") }
    val correo = remember { mutableStateOf("") }
    val telefono = remember { mutableStateOf("") }
    val usuario = remember { mutableStateOf("") }
    val contraseña = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.wallpaper_principal), // Reemplaza con tu recurso de imagen
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Contenido superpuesto
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ikuyo_kita), // Reemplaza con tu recurso de logo
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))
            // Campo de texto para nombre
            OutlinedTextField(
                value = nombre.value,
                onValueChange = { nombre.value = it },
                label = { Text("nombre") },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para apellido
            OutlinedTextField(
                value = apellido.value,
                onValueChange = { nombre.value = it },
                label = { Text("apellido") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para correo electrónico
            OutlinedTextField(
                value = correo.value,
                onValueChange = { nombre.value = it },
                label = { Text("e-mail") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para telefono
            OutlinedTextField(
                value = telefono.value,
                onValueChange = { nombre.value = it },
                label = { Text("telefono") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para usuario
            OutlinedTextField(
                value = usuario.value,
                onValueChange = { nombre.value = it },
                label = { Text("usuario") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para contraseña
            OutlinedTextField(
                value = contraseña.value,
                onValueChange = { contraseña.value = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Botón de Aceptar
            Button(
                onClick = { /* Acción de iniciar sesión */ },
                modifier = Modifier
                    .width(250.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Registrarse", color = Color.Black, fontSize = 16.sp)
            }
        }
    }
}