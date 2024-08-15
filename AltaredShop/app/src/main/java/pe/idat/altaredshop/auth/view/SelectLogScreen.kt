package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pe.idat.altaredshop.R

@Composable
fun selectLogScreen(navController: NavHostController){
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
            Text(
                text = "Bienvenido de Nuevo!",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.lifesure_with), // Reemplaza con tu recurso de logo
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(220.dp)
                    .height(220.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* Acción de Iniciar Sesión */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Iniciar Sesion", color = Color.Black, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = { /* Acción de Registrarse */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                border = BorderStroke(2.dp, Color.White) // Borde blanco de 2 dp
            ) {
                Text(text = "Registrarse", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Inicia sesion con las redes sociales",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Botones de redes sociales
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = { /* Acción para Facebook */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook_white), // Reemplaza con tu recurso de imagen
                        contentDescription = "Facebook",
                        tint = Color.Unspecified, // Para que mantenga los colores originales
                        modifier = Modifier.size(48.dp)
                    )
                }
                IconButton(onClick = { /* Acción para Google */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.twitter_white), // Reemplaza con tu recurso de imagen
                        contentDescription = "Google",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(48.dp)
                    )
                }
                IconButton(onClick = { /* Acción para Instagram */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.instagram_white), // Reemplaza con tu recurso de imagen
                        contentDescription = "Instagram",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}