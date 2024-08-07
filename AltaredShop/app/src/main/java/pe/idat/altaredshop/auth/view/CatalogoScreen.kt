package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import pe.idat.altaredshop.R

data class Producto(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagenResId: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun catalogoScreen() {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    val productos = listOf(
        Producto("COLLAGSURE FLEX 500G", "Reforzado con Camu-Camu", 50.0, R.drawable.colagsureflex), // Reemplazar con el ID correcto
        Producto("COLLAGSURE PURO 500G", "Sabor neutro alto en proteinas", 50.0, R.drawable.colagsurepuro500g),
        Producto("COLLAGSURE Q10 500G", "Fortalecimiento de piel", 50.0, R.drawable.colagsureq10),
        Producto("GERIASURE 1K", "Formula en polvo a base de leche", 90.0, R.drawable.geriasure1k),
        Producto("MADRESURE 100CPS", "Capsula para el tratamiento contra la anemia del embarazo", 75.0, R.drawable.madresurecap),
        Producto("VISIONSURE 100CPS", "Libre de azucar sin gluten y lactosa", 40.0, R.drawable.visionsurecap)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    BasicTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier.fillMaxWidth(),
                        decorationBox = { innerTextField ->
                            Row(
                                Modifier
                                    .padding(8.dp)
                                    .background(Color.White, MaterialTheme.shapes.small)
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .fillMaxWidth()
                            ) {
                                if (searchText.text.isEmpty()) {
                                    Text("Buscar producto", color = Color.Gray)
                                }
                                innerTextField()
                            }
                        }
                    )
                },
                actions = {
                    IconButton(onClick = { /* Acción de búsqueda */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Buscar")
                    }
                    IconButton(onClick = { /* Acción de carrito */ }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Productos") },
                    selected = true,
                    onClick = { /* Navegar a productos */ },
                    label = { Text("Productos") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Category, contentDescription = "Categorías") },
                    selected = false,
                    onClick = { /* Navegar a categorías */ },
                    label = { Text("Categorías") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Pedidos") },
                    selected = false,
                    onClick = { /* Navegar a pedidos */ },
                    label = { Text("Pedidos") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    selected = false,
                    onClick = { /* Navegar a perfil */ },
                    label = { Text("Perfil") }
                )
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                items(productos.size) { index ->
                    ProductoItem(producto = productos[index])
                }
            }
        }
    )
}

@Composable
fun ProductoItem(producto: Producto) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = producto.imagenResId),
            contentDescription = producto.nombre,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(producto.nombre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(producto.descripcion, fontSize = 16.sp, color = Color.Gray)
            Text("${producto.precio}$", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}