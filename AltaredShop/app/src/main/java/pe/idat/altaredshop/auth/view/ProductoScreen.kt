package pe.idat.altaredshop.auth.view

import androidx.compose.runtime.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import pe.idat.altaredshop.R

@Composable
fun productoScreen() {
    var cantidad by remember { mutableStateOf(2) }
    val precioUnitario = 50.0

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.colagsureflex), // Reemplazar con el ID correcto de la imagen
                    contentDescription = "Imagen del producto",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text("COLLAGSURE FLEX X 500G", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("Descripción", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Reforzado con camu-camu", fontSize = 16.sp)
                Text("Precio", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("$precioUnitario", fontSize = 16.sp)
                Text("Tu orden", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Cantidad: $cantidad", fontSize = 16.sp)
                Text("Precio C/U: ${cantidad * precioUnitario}", fontSize = 16.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { if (cantidad > 0) cantidad-- },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A0A0A))
                    ) {
                        Text("-", color = Color.White)
                    }
                    Text("$cantidad", fontSize = 16.sp)
                    Button(
                        onClick = { cantidad++ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A0A0A))
                    ) {
                        Text("+", color = Color.White)
                    }
                    Button(
                        onClick = { /* Manejar clic del botón de agregar */ },
                        modifier = Modifier.padding(start = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4EA8E9))
                    ) {
                        Text("AGREGAR", color = Color.White)
                    }
                }
            }
        }
    )
}