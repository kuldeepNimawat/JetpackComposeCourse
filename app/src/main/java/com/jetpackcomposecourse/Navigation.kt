package com.jetpackcomposecourse

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.delay

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.SplashScreen.route){
        composable(route = Screen.SplashScreen.route){
            SpashScreen(navController)
        }

        composable(route = Screen.MainScreen.route){
            MainScreen(navController)
        }

    //-------navigation between mainscreen to detailscreen----
    /*NavHost(navController, startDestination = Screen.MainScreen.route){
       composable(route = Screen.MainScreen.route){
          MainScreen(navController)
       }*/

        //----pass argument when it will necessary like that---------
        composable(route = Screen.DetailScreen.route + "/{name}",//"/{name}/{age}--pass multiple arguments like that
       //---pass argument when it will option like that
        //composable(route = Screen.DetailScreen.route + "?name=/{name}",
        arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
                defaultValue = "Kuldeep"
                nullable = true
            }
        )
        ){ entry ->
              DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}

@Composable
fun SpashScreen(navController: NavController){
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(Screen.MainScreen.route)
    }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Image(painter = painterResource(R.drawable.kuldeep_pic),
            contentDescription = "logo",
            modifier = Modifier.scale(scale.value)
                .height(520.dp)
                .width(520.dp))
        }
}

@Composable
fun MainScreen(navController: NavController){
    var textValue by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        TextField(value = textValue, onValueChange = {
           textValue = it
        },
        modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
          navController.navigate(Screen.DetailScreen.withArg(textValue))
        },
        modifier = Modifier.align(Alignment.End)){
            Text("Move DetailScreen")
        }
    }
}

@Composable
fun DetailScreen(name : String?){
    Box(contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()) {
      Text("Welcome $name")
    }
}