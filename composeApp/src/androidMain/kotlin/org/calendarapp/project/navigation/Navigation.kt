package org.calendarapp.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.calendarapp.project.auth.LoginPageUi
import org.calendarapp.project.auth.SignUpPageUi
import org.calendarapp.project.auth.WelcomePageUi
import org.calendarapp.project.home.HomeUi

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination = Screens.Home.route){
        composable(route = Screens.Welcome.route) {
            WelcomePageUi()
        }

        composable(route = Screens.SignUp.route) {
            SignUpPageUi()
        }

        composable(route = Screens.Login.route) {
            LoginPageUi()
        }

        composable(route = Screens.Home.route){
            HomeUi()
        }
//
//        composable(route = Screens.Calendar.route){
////            CalendarUi()
//        }
//
//        composable(route = Screens.Setting.route){
////            SettingPageUi()
//        }
    }
}