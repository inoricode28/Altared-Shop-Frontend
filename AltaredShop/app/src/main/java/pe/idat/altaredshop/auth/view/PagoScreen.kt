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
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import pe.idat.altaredshop.core.ruta.RutaAltared

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pagoScreen(navController: NavHostController) {
    var cardNumber by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var expirationYear by remember { mutableStateOf("") }
    var cardHolderName by remember { mutableStateOf("") }
    var securityCode by remember { mutableStateOf("") }
    var storedSecurityCode by remember { mutableStateOf("") }
    var isRegistered by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = cardHolderName,
                    onValueChange = { cardHolderName = it },
                    label = { Text("Nombre del titular") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isRegistered
                )
                OutlinedTextField(
                    value = cardNumber,
                    onValueChange = { cardNumber = it },
                    label = { Text("Número de la tarjeta") },
                    leadingIcon = { Icon(Icons.Default.CreditCard, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isRegistered
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = fecha,
                        onValueChange = { fecha = it },
                        label = { Text("Fecha") },
                        leadingIcon = { Icon(Icons.Default.Event, contentDescription = null) },
                        modifier = Modifier.weight(1f),
                        enabled = !isRegistered
                    )
                    OutlinedTextField(
                        value = expirationYear,
                        onValueChange = { expirationYear = it },
                        label = { Text("Año") },
                        leadingIcon = { Icon(Icons.Default.Event, contentDescription = null) },
                        modifier = Modifier.weight(1f),
                        enabled = !isRegistered
                    )
                }

                OutlinedTextField(
                    value = securityCode,
                    onValueChange = { securityCode = it },
                    label = { Text("CCV") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (cardHolderName.isNotBlank() && cardNumber.isNotBlank() && fecha.isNotBlank() && expirationYear.isNotBlank() && securityCode.isNotBlank()) {
                            // Almacenar el valor del CCV y deshabilitar campos
                            storedSecurityCode = securityCode
                            isRegistered = true

                            // Limpiar CCV
                            securityCode = ""

                            // Mostrar mensaje de registro exitoso
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(
                                    "Registro exitoso",
                                    actionLabel = "OK",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        } else {
                            // Mostrar mensaje de campos vacíos
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(
                                    "Todos los campos son obligatorios",
                                    actionLabel = "OK",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isRegistered
                ) {
                    Text("REGISTRAR")
                }
                Button(
                    onClick = {
                        if (securityCode == storedSecurityCode) {
                            navController.navigate(RutaAltared.ExitosaScreen.path)
                        } else {
                            navController.navigate(RutaAltared.ErroneaScreen.path)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isRegistered
                ) {
                    Text("PAGAR")
                }
            }
        }
    )
}




