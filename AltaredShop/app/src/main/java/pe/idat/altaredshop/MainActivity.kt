package pe.idat.altaredshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.idat.altaredshop.auth.view.catalogoScreen
import pe.idat.altaredshop.auth.view.loginScreen
import pe.idat.altaredshop.auth.view.pagoScreen
import pe.idat.altaredshop.auth.view.productoScreen
import pe.idat.altaredshop.auth.view.registroScreen
import pe.idat.altaredshop.ui.theme.AltaredShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AltaredShopTheme {

               // loginScreen()
                //registroScreen()
                //pagoScreen()
    //            productoScreen()
                  catalogoScreen()

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