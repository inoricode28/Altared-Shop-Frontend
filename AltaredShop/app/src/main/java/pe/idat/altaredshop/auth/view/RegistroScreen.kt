package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.idat.altaredshop.R


@Composable
fun registroScreen() {
    Scaffold { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            cabeceraRegistro()
            formularioRegistro()
        }
    }
}

@Composable
fun cabeceraRegistro(){
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logore), contentDescription = "logo",
            Modifier
                .width(100.dp)
                .height(100.dp))
//        Image(imageVector = Icons.Filled.Pets, contentDescription = "logo",
//            Modifier
//                .width(100.dp)
//                .height(100.dp))
        Text(text = "REGISTRATE", fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun formularioRegistro(){
    Column(modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .verticalScroll(rememberScrollState())) {
        txtnombre(nombre = "") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtapellido("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtemail("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtcelular("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtusuarioreg("") { it }
        Spacer(modifier = Modifier.size(5.dp))
        txtpasswordreg( "") { it }
        Spacer(modifier = Modifier.size(5.dp))
        buttonregistro()
    }
}
@Composable
fun buttonregistro(){
    Button(onClick = {
    }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Registrar")
    }
}

@Composable
fun txtnombre(nombre: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = nombre,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Nombre") },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona") },
        maxLines = 1,
        singleLine = true
    )
}
@Composable
fun txtapellido(apellido: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = apellido,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Apellido") },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona") },
        maxLines = 1,
        singleLine = true
    )
}
@Composable
fun txtemail(email: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = email,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Email") },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona") },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtcelular(celular: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = celular,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Celular") },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona") },
        maxLines = 1,
        singleLine = true
    )
}

@Composable
fun txtusuarioreg(usuario: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = usuario,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Usuario") },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona") },
        maxLines = 1,
        singleLine = true
    )
}
@Composable
fun txtpasswordreg(password: String, onTextChanged: (String) -> Unit){
    var visible by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(value = password,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Password") },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona") },
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