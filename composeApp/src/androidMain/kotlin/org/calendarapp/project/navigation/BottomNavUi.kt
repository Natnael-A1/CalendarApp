package org.calendarapp.project.navigation

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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.calendarapp.project.R

sealed class BottomNavItem(
    var title: String,
    var clickedIcon: Int,
    var unClickedIcon: Int,
    var route: String
) {
    data object HomeNavItem : BottomNavItem(
        "Home",
        R.drawable.clicked_home,
        R.drawable.unclicked_home,
        InAppNavigationObjects.Homepage.route
    )

    data object CalendarNavItem : BottomNavItem(
        "Calendar",
        R.drawable.clicked_calendar,
        R.drawable.unclicked_calendar,
        InAppNavigationObjects.Calendar.route
    )

    data object SettingNavItem : BottomNavItem(
        "Setting",
        R.drawable.clicked_setting,
        R.drawable.unclicked_setting,
        InAppNavigationObjects.Settings.route
    )
}

@Composable
fun BottomMenu(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.HomeNavItem,
        BottomNavItem.CalendarNavItem,
        BottomNavItem.SettingNavItem
    )

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
            items.map { item ->
                BottomMenuItem(
                    item = item,
                    isSelected = currentRoute == item.route,
                    onItemClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screenRoute ->
                                popUpTo(screenRoute) {
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