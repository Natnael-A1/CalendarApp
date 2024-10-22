package org.calendarapp.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.calendarapp.project.calendar.CalendarUi
import org.calendarapp.project.home.HomeUi
import org.calendarapp.project.settings.SettingUi

@Composable
fun InAppNavigation(
    navController: NavController
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = InAppNavigationObjects.Homepage.route
    ) {
        composable(InAppNavigationObjects.Homepage.route) { HomeUi(navController) }
        composable(InAppNavigationObjects.Calendar.route) { CalendarUi(navController) }
        composable(InAppNavigationObjects.Settings.route) { SettingUi(navController)
//            SettingsScreen() {
//                logout()
//            }
        }
    }
}