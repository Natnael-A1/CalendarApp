package org.calendarapp.project.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import org.calendarapp.project.ui.LoginButtonBlue
import org.jetbrains.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale

@Preview
@Composable
fun CalendarUi(navController: NavHostController) {
    var currentCalendar by remember { mutableStateOf(Calendar.getInstance()) }
    var selectedDate by remember { mutableStateOf<Date?>(null) }

    Column(modifier = Modifier
        .fillMaxSize()
        .offset(y = (-16).dp)
        .padding(horizontal = 12.dp)
        .background(Color.White)) {
        CalendarHeader(
            currentCalendar = currentCalendar,
            onMonthSelected = { selectedCalendar ->
                currentCalendar = selectedCalendar
            }
        )
        Spacer(modifier = Modifier.height(7.dp))
        CalendarGrid(currentCalendar,
            onDateSelected = { date ->
                selectedDate = date
                // Handle the date selection (e.g., show events for the selected date)
            })
        CurrentDate()

    }
}
@Composable
fun CalendarHeader(
    currentCalendar: Calendar,
    onMonthSelected: (Calendar) -> Unit
) {
    val monthFormat = remember { SimpleDateFormat("MMMM", Locale.getDefault()) }
    val yearFormat = remember { SimpleDateFormat("yyyy", Locale.getDefault()) }

    val previousCalendar = remember(currentCalendar) { currentCalendar.clone() as Calendar }.apply {
        add(
            Calendar.MONTH,
            -1
        )
    }
    val nextCalendar = remember(currentCalendar) { currentCalendar.clone() as Calendar }.apply {
        add(
            Calendar.MONTH,
            1
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Spacer(modifier = Modifier.width(14.dp))
        Column (modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
            .weight(1f)
            .background(Color.LightGray)
            .height(36.dp),
        ) {
            Tab(
                selected = false,
                onClick = { onMonthSelected(previousCalendar) },
                text = {
                    Text(
                        text = monthFormat.format(previousCalendar.time),
                        fontSize = 14.sp,
                        color = Color.White
                    )
                },
            )
        }
        Spacer(modifier = Modifier.width(7.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                .background(LoginButtonBlue)
                .weight(1.2f)
                .height(46.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = monthFormat.format(currentCalendar.time),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(7.dp))
        Column(modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
            .weight(1f)
            .background(Color.LightGray)
            .height(36.dp),
        ) {
            Tab(
                selected = false,
                onClick = { onMonthSelected(nextCalendar) },
                text = {
                    Text(
                        text = monthFormat.format(nextCalendar.time),
                        fontSize = 14.sp,
                        color = Color.White
                        )
                },
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
    }
}

@Composable
fun CalendarGrid(calendar: Calendar, onDateSelected: (Date) -> Unit) {
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val currentMonth = calendar.get(Calendar.MONTH)
    val currentYear = calendar.get(Calendar.YEAR)
    val today = Calendar.getInstance()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp)
            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
        ) {
            // Days of the week header
            items(7) { index ->
                Text(
                    text = daysOfWeek[index],
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // Calendar days
            val firstDayOfMonth = calendar.clone() as Calendar
            firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1)
            val daysBeforeMonth = firstDayOfMonth.get(Calendar.DAY_OF_WEEK) - 1
            val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            val totalDays = 35 // 5 rows * 7 days

            // Days from previous month
            items(daysBeforeMonth) {
                Text(
                    text = "",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }

            // Days of the current month
            items(minOf(daysInMonth, totalDays - daysBeforeMonth)) { day ->
                val date = calendar.clone() as Calendar
                date.set(Calendar.DAY_OF_MONTH, day + 1)
                val isToday = date.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                        date.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                        date.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)
                Box(
                    modifier = Modifier
                        .aspectRatio(1.3f)
                        .padding(3.dp)
                        .clickable { onDateSelected(date.time) },
                    contentAlignment = Alignment.Center
                ) {
                    //style for current day
                    Text(
                        text = (day + 1).toString(),
                        color = if (isToday) Color.Blue else Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }

            // Fill remaining cells if needed
            val remainingDays = totalDays - (daysBeforeMonth + minOf(daysInMonth, totalDays - daysBeforeMonth))
            items(remainingDays) { day ->
                Text(
                    text = (day + 1).toString(),
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun CurrentDate(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (10).dp)
        ,
        horizontalArrangement = Arrangement.Center
    ) {
        val currentDate = remember { Calendar.getInstance() }
        val dateFormat = remember { SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()) }

        Text(
            text = dateFormat.format(currentDate.time),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}