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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pe.idat.altaredshop.R
import pe.idat.altaredshop.auth.viewmodel.LoginViewModel
import pe.idat.altaredshop.core.ruta.RutaAltared


@Composable
fun loginScreen(loginViewModel: LoginViewModel,navController: NavController) {

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState)})
    { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)){
            cabecera(modifier = Modifier.align(Alignment.TopEnd))
            formularioLogin(modifier = Modifier.align(Alignment.Center),
                loginViewModel, snackbarHostState, navController)
            pie(modifier = Modifier.align(Alignment.BottomCenter),navController)
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
fun pie(modifier: Modifier, navController: NavController){
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0x0F7C7C7C))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        irRegistro(navController)
        Spacer(modifier = Modifier.size(24.dp))
    }
}
@Composable
fun irRegistro(navController: NavController){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "¿No tienes cuenta? ", fontSize = 12.sp, color = Color(0xFFB5B5B5))
        Text(text = " Registrate Aquí", fontSize = 12.sp, fontWeight = FontWeight.Bold,
            color = Color(0xFF141D5E),
            modifier = Modifier.clickable { navController.navigate(RutaAltared.registroScreen.path) }
        )
    }
}

@Composable
fun formularioLogin(modifier: Modifier, loginViewModel: LoginViewModel,
                    state: SnackbarHostState, navController: NavController){
    val usuario: String by loginViewModel.usuario.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val botonLoginHabilitado: Boolean by
                loginViewModel.botonLoginHabilitado.observeAsState(initial = false)
    Column(modifier = modifier.padding(start = 5.dp, end = 5.dp)) {
        logoAltared(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(4.dp))
        txtusuario(usuario) { loginViewModel.onValueChange(it,password) }
        Spacer(modifier = Modifier.size(4.dp))
        txtpassword(password) { loginViewModel.onValueChange(usuario,it) }
        Spacer(modifier = Modifier.size(8.dp))
        authButton(botonLoginHabilitado, loginViewModel, state, navController)
    }
}
@Composable
fun logoAltared(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.logo01), contentDescription = "logo",
        modifier = modifier)
}

@Composable
fun authButton(botonHabilitado: Boolean, loginViewModel: LoginViewModel,
               state: SnackbarHostState, navController: NavController){
    val scope = rememberCoroutineScope()
    val loginResponse by loginViewModel.loginResponse.observeAsState()
    Button(onClick = {
        loginViewModel.loginUsuarioPassword()

    }, modifier = Modifier.fillMaxWidth(),
    enabled = botonHabilitado
    ) {
        Text(text = "Ingresar")
    }
    loginResponse?.obtenerContenidoSinCambios()?.let {
        response ->
        if (response.rpta){
            navController.navigate(RutaAltared.homeScreen.path)
        }else{
            scope.launch {
                state.showSnackbar("Login Fallido: ${response.mensaje}",
                    actionLabel = "OK",
                    duration = SnackbarDuration.Long)
            }

        }
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