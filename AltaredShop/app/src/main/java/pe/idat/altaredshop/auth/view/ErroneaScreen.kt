package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import pe.idat.altaredshop.R
import pe.idat.altaredshop.core.ruta.RutaAltared
import androidx.compose.ui.platform.LocalContext
import android.app.Activity

@Composable
fun ErroneaScreen(navController: NavHostController){
    val activity = LocalContext.current as? Activity
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
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.error_compra), // Reemplaza con tu recurso de logo
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(220.dp)
                    .height(220.dp)
            )
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Error de Compra!!!",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Se ha producido un error\n" +
                        "inesperado. Porfavor, intente\n" +
                        "realizar la compra nuevamente",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Botón de reintentar
            Button(
                onClick = { navController.navigate(RutaAltared.pagoScreen.path) },
                modifier = Modifier
                    .width(250.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Reintentar", color = Color.Black, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))

            // Botón de salir e ir a menu principal
            Button(
                onClick = { activity?.finish() },
                modifier = Modifier
                    .width(250.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Salir", color = Color.Black, fontSize = 16.sp)
            }
        }
    }
}
