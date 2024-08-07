package pe.idat.altaredshop.auth.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pagoScreen() {
    var cardNumber by remember { mutableStateOf("") }
    var expirationYear by remember { mutableStateOf("") }
    var expirationMonth by remember { mutableStateOf("") }
    var cardHolderName by remember { mutableStateOf("") }
    var securityCode by remember { mutableStateOf("") }
    var idType by remember { mutableStateOf("CC") }
    var idNumber by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Formulario de pago") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = cardNumber,
                    onValueChange = { cardNumber = it },
                    label = { Text("Número de la tarjeta") },
                    leadingIcon = { Icon(Icons.Default.CreditCard, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = expirationYear,
                        onValueChange = { expirationYear = it },
                        label = { Text("Año de expiración YYYY") },
                        leadingIcon = { Icon(Icons.Default.Event, contentDescription = null) },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = expirationMonth,
                        onValueChange = { expirationMonth = it },
                        label = { Text("Mes de expiración MM") },
                        leadingIcon = { Icon(Icons.Default.Event, contentDescription = null) },
                        modifier = Modifier.weight(1f)
                    )
                }
                OutlinedTextField(
                    value = cardHolderName,
                    onValueChange = { cardHolderName = it },
                    label = { Text("Nombre del titular") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = securityCode,
                    onValueChange = { securityCode = it },
                    label = { Text("Código de seguridad") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = idType,
                    onValueChange = { idType = it },
                    label = { Text("Tipo de identificación") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = idNumber,
                    onValueChange = { idNumber = it },
                    label = { Text("Número de identificación") },
                    leadingIcon = { Icon(Icons.Default.AssignmentInd, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Manejar clic del botón */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Continuar")
                }
            }
        }
    )
}

