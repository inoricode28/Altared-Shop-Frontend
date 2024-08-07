package pe.idat.altaredshop.auth.view

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.idat.altaredshop.R


@Composable
fun loginScreen() {
    Scaffold { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)){
            cabecera(modifier = Modifier.align(Alignment.TopEnd))
            formularioLogin(modifier = Modifier.align(Alignment.Center))
            pie(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}
@Composable
fun cabecera(modifier: Modifier){
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close
        , contentDescription = "Cerrar",
        modifier = modifier.clickable { activity.finish() })
}
@Composable
fun pie(modifier: Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0x0F7C7C7C))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        irRegistro()
        Spacer(modifier = Modifier.size(24.dp))
    }
}
@Composable
fun irRegistro(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "¿No tienes cuenta? ", fontSize = 12.sp, color = Color(0xFFB5B5B5))
        Text(text = " Registrate Aquí", fontSize = 12.sp, fontWeight = FontWeight.Bold,
            color = Color(0xFF141D5E),
            modifier = Modifier.clickable { Log.i("TextCLIC", "Hola Texto") }
        )
    }
}

@Composable
fun formularioLogin(modifier: Modifier){
    Column(modifier = modifier.padding(start = 5.dp, end = 5.dp)) {
        logoPatitas(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(4.dp))
        txtusuario("") { it }
        Spacer(modifier = Modifier.size(4.dp))
        txtpassword("") { it }
        Spacer(modifier = Modifier.size(8.dp))
        authButton()
    }
}
@Composable
fun logoPatitas(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.imgsplash), contentDescription = "logo",
        modifier = modifier)
}

@Composable
fun authButton(){
    Button(onClick = {
    }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ingresar")
    }
}
@Composable
fun txtusuario(usuario: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = usuario,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Usuario") },
        maxLines = 1,
        singleLine = true
    )
}
@Composable
fun txtpassword(password: String, onTextChanged: (String) -> Unit){
    var visible by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(value = password,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (visible){
                Icons.Filled.VisibilityOff
            }else{
                Icons.Filled.Visibility
            }
            IconButton(onClick = { visible = !visible }) {
                Icon(imageVector = imagen, contentDescription = "password")
            }
        },
        visualTransformation = if (visible){
            VisualTransformation.None
        } else PasswordVisualTransformation()
    )
}