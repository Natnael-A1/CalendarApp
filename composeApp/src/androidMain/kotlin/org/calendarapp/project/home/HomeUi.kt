package org.calendarapp.project.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import org.calendarapp.project.navigation.NavInsideApp
import org.calendarapp.project.navigation.navigation

@Composable
fun HomeUi() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Scaffold(topBar = { HeaderUI() },
            bottomBar = {
                val navController = rememberNavController()
                BottomMenu(navController = navController)
            }, content = { PaddingValues ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(PaddingValues)
                ) {
                    NavInsideApp
                }
            }
        )
        Divider(Modifier.fillMaxWidth())
    }
}


//@Preview
//@Composable
//fun HomeUiPreview(){
//    HomeUi()
//}