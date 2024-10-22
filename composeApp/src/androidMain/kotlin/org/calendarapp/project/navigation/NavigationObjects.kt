package org.calendarapp.project.navigation

import kotlinx.serialization.Serializable

object NavigationObjects {
    @Serializable
    object Welcome

    @Serializable
    object Login

    @Serializable
    object Register

    //Route for nesting nav graph
    @Serializable
    object NavInsideApp
}

sealed class InAppNavigationObjects(val route: String){
    data object Homepage: InAppNavigationObjects("home_screen")
    data object Calendar: InAppNavigationObjects("calendar_screen")
    data object Settings: InAppNavigationObjects("setting_screen")
}
//Routes inside nested graph
