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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import pe.idat.altaredshop.auth.viewmodel.ProductoViewModel

@Composable
fun perfilScreen(productoViewModel: ProductoViewModel) {
    // Observa los datos del usuario desde el ViewModel
    val usuario by productoViewModel.usuario.observeAsState()

    // Estados para los campos de texto, inicializados con los valores observados
    val nombre = remember { mutableStateOf(usuario?.nombre ?: "") }
    val apellido = remember { mutableStateOf(usuario?.apellido ?: "") }
    val correo = remember { mutableStateOf(usuario?.correo ?: "") }
    val telefono = remember { mutableStateOf(usuario?.celular ?: "") }
    val usuarioEstado = remember { mutableStateOf(usuario?.user ?: "") }
    val contraseña = remember { mutableStateOf(usuario?.pass ?: "") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.wallpaper_principal),
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
                painter = painterResource(id = R.drawable.ikuyo_kita),
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
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para apellido
            OutlinedTextField(
                value = apellido.value,
                onValueChange = { apellido.value = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para correo electrónico
            OutlinedTextField(
                value = correo.value,
                onValueChange = { correo.value = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para teléfono
            OutlinedTextField(
                value = telefono.value,
                onValueChange = { telefono.value = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto para usuario
            OutlinedTextField(
                value = usuarioEstado.value,
                onValueChange = { usuarioEstado.value = it },
                label = { Text("Usuario") },
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
        }
    }
}
