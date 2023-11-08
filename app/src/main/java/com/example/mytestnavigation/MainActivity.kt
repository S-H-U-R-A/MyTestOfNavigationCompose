package com.example.mytestnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytestnavigation.navigation.Routes
import com.example.mytestnavigation.ui.Pantalla1Screen
import com.example.mytestnavigation.ui.Pantalla2Screen
import com.example.mytestnavigation.ui.Pantalla3Screen
import com.example.mytestnavigation.ui.theme.MyTestNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestNavigationTheme {
                TestApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestAppBar(
    currentScreen: Routes,
    canNavigate: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = currentScreen.title
            )
        },
        navigationIcon = {
            if(canNavigate){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestApp(
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val backStackEntry: NavBackStackEntry? by navHostController.currentBackStackEntryAsState() //Obtenemos la pantalla actual

    val currentScreen: Routes = when (backStackEntry?.destination?.route) {
        Routes.Pantalla1.route -> {
            Routes.Pantalla1
        }

        Routes.Pantalla2.route -> {
            Routes.Pantalla2
        }

        Routes.Pantalla3.route -> {
            Routes.Pantalla3
        }

        else -> {
            Routes.Pantalla1
        }
    }

    Scaffold(
        topBar = {
            TestAppBar(
                currentScreen = currentScreen,
                canNavigate = navHostController.previousBackStackEntry != null,//Si hay una pantalla atrás quiere decir que podemos mostrar la flecha de retroceso
                navigateUp = {
                    navHostController.navigateUp()//Acción de navegar hacia atrás.
                }
            )
        },
    ) { innerPadding ->

        NavHost(
            navController = navHostController,
            startDestination = Routes.Pantalla1.route,
            modifier = modifier.padding(innerPadding)
        ) {
            this.composable(
                route = Routes.Pantalla1.route
            ) {
                Pantalla1Screen(
                    goToPage2 = { nameScreen ->
                        println(nameScreen)
                        navHostController.navigate(
                            Routes.Pantalla2.route
                                .replace("{mensaje}", "Saludo desde la pantalla 1")
                        )
                    }
                )
            }
            this.composable(
                route = Routes.Pantalla2.route,
                arguments = listOf(
                    navArgument("mensaje") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val mensaje: String? = backStackEntry.arguments?.getString("mensaje")
                requireNotNull(mensaje)
                Pantalla2Screen(
                    mensaje = mensaje,
                    goToScreen3 = { nameScreen ->
                        println(nameScreen)
                        navHostController.navigate(
                            Routes.Pantalla3.route
                        )
                    }
                )
            }
            this.composable(
                route = Routes.Pantalla3.route
            ) { backStackEntry ->
                Pantalla3Screen(
                    goToPage1 = { nameScreen ->
                        println(nameScreen)
                        navHostController.popBackStack(
                            route = Routes.Pantalla1.route,
                            inclusive = false
                        )
                    }
                )
            }
        }
    }
}