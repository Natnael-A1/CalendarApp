package org.calendarapp.project.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.calendarapp.project.navigation.NavGraph

@Composable
fun HomeUi() {
    val navController = rememberNavController()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Scaffold(topBar = { HeaderUI() },
            bottomBar = {
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
                    NavGraph(navController = navController)
                }
            }
        )
        Divider(Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun HomeUiPreview(){
    HomeUi()
}