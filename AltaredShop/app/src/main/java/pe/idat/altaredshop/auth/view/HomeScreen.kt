package pe.idat.altaredshop.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.idat.altaredshop.R
import pe.idat.altaredshop.auth.viewmodel.ProductoViewModel
import pe.idat.altaredshop.core.ruta.RutaAltared
import pe.idat.altaredshop.core.util.MenuItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(productoViewModel: ProductoViewModel){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            DrawerContent(items = opcionesMenu(), onItemClick = {
                item ->
                coroutineScope.launch {
                    drawerState.close()
                }
                when(item.titulo){
                    "HOME" -> navController.navigate(RutaAltared.productoScreen.path)
                    "PERFIL" -> navController.navigate(RutaAltared.perfilScreen.path)
                }
            })
            
        },
        content = {
            Column {
                TopAppBar(title = { Text(text = "ALTARED APP") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                          Icon(Icons.Default.Menu, contentDescription = "Menu")

                        }
                    })
                NavHost(navController = navController,
                    startDestination = RutaAltared.productoScreen.path) {
                    composable(RutaAltared.productoScreen.path){ productoScreen(productoViewModel)}
                    composable(RutaAltared.perfilScreen.path){ perfilScreen()}
                    //36:08
                }
            }

        }) 
}

@Composable
fun DrawerContent(items: List<MenuItem>,
                  onItemClick: (MenuItem) -> Unit){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()) {
        DrawerHeader()
        Spacer(modifier = Modifier.height(8.dp))
        items.forEach {item ->
            DrawerMenuItem(item = item, onItemClick = onItemClick)

        }
    }
}

@Composable
fun DrawerHeader(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Miguel Alfonzo Chavez Ramos", fontWeight = FontWeight.Bold)
            Text(text = "inori237@gmail.com", color = Color.Gray)
        }
        
    }
}

@Composable
fun DrawerMenuItem(
    item: MenuItem,
    onItemClick: (MenuItem) -> Unit
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(item) }
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = item.icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.titulo)

    }
}

fun opcionesMenu(): List<MenuItem>{
    return listOf(
        MenuItem(Icons.Default.Pets, "HOME"),
        MenuItem(Icons.Default.People, "PERFIL")
    )

}