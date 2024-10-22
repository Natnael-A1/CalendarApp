package org.calendarapp.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.calendarapp.project.auth.LoginPageUi
import org.calendarapp.project.auth.SignUpPageUi
import org.calendarapp.project.auth.WelcomePageUi

@Composable
fun navigation() {
    val navController = rememberNavController()
    val navBarController = rememberNavController()
    NavHost(navController, startDestination = NavigationObjects.Welcome){
        composable<NavigationObjects.Welcome>{
            WelcomePageUi(
                navToLogin = { navController.navigate(NavigationObjects.Login) },
                navToRegister = { navController.navigate(NavigationObjects.Register) })
        }
        composable<NavigationObjects.Register> {
            SignUpPageUi(navToLogin = { navController.navigate(NavigationObjects.Login) })
        }
        composable<NavigationObjects.Login>{
            LoginPageUi(
                navToHome = { navController.navigate(NavigationObjects.NavInsideApp) },
                navToRegister = { navController.navigate(NavigationObjects.Register) })
        }
        composable <NavigationObjects.NavInsideApp> {
            InAppScaffold(navController = navBarController)
        }
    }
}



