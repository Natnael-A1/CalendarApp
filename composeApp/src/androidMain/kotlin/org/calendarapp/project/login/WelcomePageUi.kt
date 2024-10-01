package org.calendarapp.project.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.calendarapp.project.R
import org.calendarapp.project.Ui.LoginButtonBlue

@Composable
fun WelcomePageUi() {
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
            onClick = {},
            colors = ButtonDefaults.buttonColors(LoginButtonBlue),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .width(264.dp)
                .padding(top = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.login_get_started_btn_text),
                modifier = Modifier.padding(horizontal = 12.dp),
                color = Color.White,
                fontFamily = FontFamily.Serif
            )
        }
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text(text = stringResource(R.string.login_create_an_account_text))
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            Text(
                text = stringResource(R.string.login_text),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
fun WelcomePageUiPreview() {
    WelcomePageUi()
}