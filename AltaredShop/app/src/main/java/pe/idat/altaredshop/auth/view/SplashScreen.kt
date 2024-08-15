package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import pe.idat.altaredshop.R
import pe.idat.altaredshop.core.ruta.RutaAltared
import androidx.compose.runtime.*


@Composable
fun splashScreen(navController: NavHostController){
    // Estado para controlar si la navegación debe ocurrir.
    var shouldNavigate by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        // Espera durante 5 segundos antes de proceder a la siguiente pantalla.
        delay(2000)
        // Actualiza el estado para permitir la navegación.
        shouldNavigate = true

    }
    //Si el estado indica que debemos navegar, realiza la navegación.
    if (shouldNavigate) {
        // Elimina la pantalla actual del historial de navegación para que no se pueda volver a ella.
        navController.popBackStack()
        // Navega a la pantalla de inicio de sesión.
        navController.navigate(RutaAltared.loginScreen.path)
    }
    Splash()


}

    @Composable
    fun Splash() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.lifesure_png),
                contentDescription = "Splash Screen",
                Modifier.size(300.dp, 300.dp))
        }
    }

