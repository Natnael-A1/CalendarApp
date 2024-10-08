package org.calendarapp.project.navigation

sealed class Screens(val route: String) {
    data object Welcome: Screens("welcome")
    data object Login: Screens("welcome")
    data object SignUp: Screens("welcome")
    data object Home : Screens("homepage")
    data object Calendar : Screens("calendar")
    data object Setting : Screens("settings")

}