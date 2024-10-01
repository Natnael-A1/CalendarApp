package org.calendarapp.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.calendarapp.project.login.WelcomePageUi

@Composable
@Preview
fun App() {
    MaterialTheme {
        WelcomePageUi()
    }
}