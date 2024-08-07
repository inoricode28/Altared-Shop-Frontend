package pe.idat.altaredshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pe.idat.altaredshop.auth.view.catalogoScreen
import pe.idat.altaredshop.auth.view.loginScreen
import pe.idat.altaredshop.auth.view.pagoScreen
import pe.idat.altaredshop.auth.view.productoScreen
import pe.idat.altaredshop.auth.view.registroScreen
import pe.idat.altaredshop.auth.viewmodel.LoginViewModel
import pe.idat.altaredshop.core.ruta.RutaAltared
import pe.idat.altaredshop.ui.theme.AltaredShopTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AltaredShopTheme {

                val navigation = rememberNavController()
                NavHost(navController = navigation, startDestination = RutaAltared.loginScreen.path,
                    builder = {
                        composable(RutaAltared.loginScreen.path){
                            loginScreen(loginViewModel, navigation)
                        }
                        composable(RutaAltared.registroScreen.path){
                            registroScreen()
                        }
                        composable(RutaAltared.catalogoScreen.path){
                            catalogoScreen()
                        }
                    })

                //loginScreen()
                //registroScreen()
                //pagoScreen()
               // productoScreen()
     //             catalogoScreen()

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AltaredShopTheme {

    }
}