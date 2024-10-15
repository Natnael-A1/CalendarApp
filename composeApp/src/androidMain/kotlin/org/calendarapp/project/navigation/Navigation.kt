package org.calendarapp.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.calendarapp.project.auth.LoginPageUi
import org.calendarapp.project.auth.SignUpPageUi
import org.calendarapp.project.auth.WelcomePageUi
import org.calendarapp.project.calendar.CalendarUi
import org.calendarapp.project.home.HomeUi
import org.calendarapp.project.settings.SettingUi


//Routes
@Serializable object Welcome
@Serializable object Login
@Serializable object Register
//Route for nesting nav graph
@Serializable object NavInsideApp
//Routes inside nested graph
@Serializable object Homepage
@Serializable object Calendar
@Serializable object Settings

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Welcome){
        composable<Welcome>{
            WelcomePageUi(
                navToLogin = { navController.navigate(Login) },
                navToRegister = { navController.navigate(Register) })
        }
        composable<Register> {
            SignUpPageUi(navToLogin = { navController.navigate(Login) })
        }
        composable<Login>{
            LoginPageUi(navToHome = { navController.navigate(NavInsideApp) }, navToRegister = { navController.navigate(Register) })
        }
        navigation<NavInsideApp>(startDestination = Homepage){
            composable<Homepage>{
                HomeUi()
            }
            composable<Calendar>{
                CalendarUi(navController)
            }
            composable<Settings>{
                SettingUi(navController)
            }
        }
    }
}


