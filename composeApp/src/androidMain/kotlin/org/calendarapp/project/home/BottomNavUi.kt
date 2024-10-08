package org.calendarapp.project.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.calendarapp.project.R
import org.calendarapp.project.navigation.Screens

sealed class BottomNavItem(
    var title: String,
    var clickedIcon: Int,
    var unClickedIcon: Int,
    var route: String
) {
    data object Home : BottomNavItem(
        "Home",
        R.drawable.clicked_home,
        R.drawable.unclicked_home,
        Screens.Home.route
    )

    data object Calendar : BottomNavItem(
        "Calendar",
        R.drawable.clicked_calendar,
        R.drawable.unclicked_calendar,
        Screens.Calendar.route
    )

    data object Setting : BottomNavItem(
        "Setting",
        R.drawable.clicked_setting,
        R.drawable.unclicked_setting,
        Screens.Setting.route
    )
}

@Composable
fun BottomMenu(
    navController: NavHostController,
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Calendar,
        BottomNavItem.Setting
    )

//    val initialSelectedItemIndex: Int = 0

//    var selectedItemIndex by remember {
//        mutableStateOf(initialSelectedItemIndex)
//    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Divider(Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.LightGray)

    Box {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items.forEach { item ->
                BottomMenuItem(
                    item = item,
                    isSelected = currentRoute == item.route,
                    onItemClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomNavItem,
    isSelected: Boolean = false,
    onItemClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Transparent)
                .padding(10.dp)
        ) {
            val iconSelected = if (isSelected) item.clickedIcon else item.unClickedIcon
            Icon(
                painter =(painterResource(id = iconSelected)),
                contentDescription = item.title,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
        )
    }
}