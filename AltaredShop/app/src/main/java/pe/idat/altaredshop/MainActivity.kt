package pe.idat.altaredshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pe.idat.altaredshop.auth.view.ErroneaScreen
import pe.idat.altaredshop.auth.view.ExitosaScreen
import pe.idat.altaredshop.auth.view.bienvenidaScreen
import pe.idat.altaredshop.auth.view.getstartedScreen
import pe.idat.altaredshop.auth.view.homeScreen
import pe.idat.altaredshop.auth.view.loginScreen
import pe.idat.altaredshop.auth.view.pagoScreen
import pe.idat.altaredshop.auth.view.registroScreen
import pe.idat.altaredshop.auth.view.selectLogScreen
import pe.idat.altaredshop.auth.view.splashScreen
import pe.idat.altaredshop.auth.viewmodel.LoginViewModel
import pe.idat.altaredshop.auth.viewmodel.ProductoViewModel
import pe.idat.altaredshop.auth.viewmodel.RegistroViewModel
import pe.idat.altaredshop.core.ruta.RutaAltared
import pe.idat.altaredshop.ui.theme.AltaredShopTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val registroViewModel: RegistroViewModel by viewModels()
    private val productoViewModel: ProductoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AltaredShopTheme {

                val navigation = rememberNavController()
                NavHost(navController = navigation, startDestination = RutaAltared.splashScreen.path,
                    builder = {
                        composable(RutaAltared.splashScreen.path){
                            splashScreen(navigation)
                        }
                        composable(RutaAltared.getstartedScreen.path){
                            getstartedScreen(navigation)
                        }
                        composable(RutaAltared.loginScreen.path){
                            loginScreen(loginViewModel, navigation)
                        }
                        composable(RutaAltared.registroScreen.path){
                            registroScreen(registroViewModel,navigation)
                        }
                        composable(RutaAltared.homeScreen.path){
                            homeScreen(productoViewModel)
                        }
                        composable(RutaAltared.pagoScreen.path){
                            pagoScreen(navigation)
                        }
                        composable(RutaAltared.ExitosaScreen.path){
                            ExitosaScreen(navigation)
                        }
                        composable(RutaAltared.ErroneaScreen.path){
                            ErroneaScreen(navigation)
                        }
                        composable(RutaAltared.bienvenidaScreen.path){
                            bienvenidaScreen(navigation)
                        }
                        composable(RutaAltared.selectLogScreen.path){
                            selectLogScreen(navigation)
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