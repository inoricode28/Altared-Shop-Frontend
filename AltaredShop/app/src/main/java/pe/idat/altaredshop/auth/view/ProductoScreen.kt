package pe.idat.altaredshop.auth.view

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import pe.idat.altaredshop.R
import pe.idat.altaredshop.auth.data.network.response.ProductoResponse
import pe.idat.altaredshop.auth.viewmodel.ProductoViewModel


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import pe.idat.altaredshop.core.ruta.RutaAltared






@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )

    var currentIndex by remember { mutableStateOf(0) }
    val transition = rememberInfiniteTransition()

    val animatedIndex by transition.animateValue(
        initialValue = 0,
        targetValue = images.size - 1,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(9000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    LaunchedEffect(animatedIndex) {
        currentIndex = animatedIndex
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
        )
    }
}

@Composable
fun productoScreen(productoViewModel: ProductoViewModel,navController: NavController) {
    val productos by productoViewModel.ProductoResponse.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                ImageSlider()

                Spacer(modifier = Modifier.height(16.dp))

                // Sección de Categorías (Forma circular)
                Text(
                    text = "CATEGORÍA",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                LazyRow(modifier = Modifier.padding(16.dp)) {
                    items(productos.take(4)) { producto -> //Los 4 primero items son de categoria
                        CategoryItem(producto = producto)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sección de Recomendaciones
                Text(
                    text = "RECOMENDACIONES",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                // Mostrar los productos en un LazyRow para un desplazamiento horizontal
                LazyRow(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(productos.drop(4)) { producto -> //Empieza desde el item 5
                        productoItem(producto = producto,navController)
                    }
                }
            }
        }

        // Barra de navegación inferior
//        BottomNavigationBar()
    }
}

@Composable
fun CategoryItem(producto: ProductoResponse) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(end = 16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = producto.Imagen)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                        placeholder(R.drawable.logo)
                    }).build()
            ), contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(text = producto.Nombre, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun productoItem(producto: ProductoResponse,navController: NavController) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .width(220.dp) // Ajusta el ancho fijo
            .height(350.dp) // Ajusta el alto fijo
            .padding(8.dp), // Ajusta el padding si es necesario
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = producto.Imagen)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                            placeholder(R.drawable.logo)
                        }).build()
                ), contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = producto.Nombre,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Precio: S/.${producto.Precio}",
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            /*Text(
                text = producto.Cantidad,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = producto.Descripcion,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )*/
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate(RutaAltared.pagoScreen.path) }) {
                Text(text = "Agregar")
            }
        }
    }
}

//@Composable
//fun BottomNavigationBar() {
//    NavigationBar {
//        NavigationBarItem(
//            selected = true,
//            onClick = { /* Acción al hacer clic */ },
//            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//            label = { Text("Home") }
//        )
//
//        NavigationBarItem(
//            selected = false,
//            onClick = { /* Acción al hacer clic */ },
//            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
//            label = { Text("Perfil") }
//        )
//        NavigationBarItem(
//            selected = false,
//            onClick = { /* Acción al hacer clic */ },
//            icon = { Icon(Icons.Default.CreditCard, contentDescription = "Carrito") },
//            label = { Text("Pago") }
//        )
//    }
//}
