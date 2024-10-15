package org.calendarapp.project.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import org.calendarapp.project.R
import org.calendarapp.project.navigation.Login
import org.calendarapp.project.navigation.Register
import org.calendarapp.project.ui.LoginButtonBlue

@Composable
fun WelcomePageUi(navToLogin: () -> Unit, navToRegister: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(.2f))
        Image(
            painter = painterResource(R.drawable.login_cog_wheel),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.login_welcome_title),
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 12.dp)
        )
        Text(
            text = stringResource(R.string.login_welcome_description),
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = navToLogin,
            colors = ButtonDefaults.buttonColors(LoginButtonBlue),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .width(264.dp)
                .padding(top = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.login_get_started_btn_text),
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                color = Color.White,
                fontFamily = FontFamily.Serif,
            )
        }
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text(text = stringResource(R.string.login_dont_have_an_account_text))
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            Text(
                text = stringResource(R.string.sign_up_text),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = LoginButtonBlue,
                modifier = Modifier
                    .clickable {
                        navToRegister()
                    }
            )
        }
    }
}

@Preview
@Composable
fun WelcomePageUiPreview() {
    WelcomePageUi(navToLogin = {}, navToRegister = {})
}