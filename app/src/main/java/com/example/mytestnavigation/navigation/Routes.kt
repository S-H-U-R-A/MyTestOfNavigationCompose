package com.example.mytestnavigation.navigation

sealed class Routes(val route: String, val title: String) {
    object Pantalla1: Routes(route = "Pantalla1", title = "Pantalla 1")
    object Pantalla2: Routes(route = "Pantalla2/{mensaje}", title = "Pantalla 2")
    object Pantalla3: Routes(route = "Pantalla3", title = "Pantalla 3")
}



