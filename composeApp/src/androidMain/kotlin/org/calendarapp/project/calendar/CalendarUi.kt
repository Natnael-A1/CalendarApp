package org.calendarapp.project.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Preview
@Composable
fun CalendarUi(navController: NavHostController) {
    Column {
        Text(text = "Calendar")
    }
}