package pe.edu.idat.mobile_altared

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.idat.mobile_altared.ui.theme.Mobile_AltaredTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobile_AltaredTheme {
               //Codigo de las Vistas AQUI
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobile_AltaredTheme {

    }
}