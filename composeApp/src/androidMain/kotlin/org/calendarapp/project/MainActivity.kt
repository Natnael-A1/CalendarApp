package org.calendarapp.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.calendarapp.project.home.HomeUi
import org.calendarapp.project.navigation.navigation
import org.calendarapp.project.ui.PersonalProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalProjectTheme {
                navigation()
            }
        }
    }
}