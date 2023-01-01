package com.jetpackcomposecourse

sealed class Screen(val route : String){
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArg(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
