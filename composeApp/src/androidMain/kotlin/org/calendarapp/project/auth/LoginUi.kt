package org.calendarapp.project.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import org.calendarapp.project.R
import org.calendarapp.project.ui.LoginButtonBlue

@Composable
fun LoginPageUi() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
            text = stringResource(R.string.login_now_text),
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 7.dp)
        )
        Text(
            text = stringResource(R.string.login_text_page_description),
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier
                .width(286.dp)
                .padding(top = 24.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(stringResource(R.string.login_email)) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(R.string.login_password)) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            )
            Text(
                text = stringResource(R.string.login_forget_password),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp)
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(LoginButtonBlue),
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .width(264.dp)
                    .padding(top = 12.dp)
            ) {
                Text(
                    text = stringResource(R.string.login_text),
                    modifier = Modifier.padding(horizontal = 12.dp),
                    color = Color.White,
                    fontFamily = FontFamily.Serif
                )
            }
        }
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text(text = stringResource(R.string.login_dont_have_an_account_text))
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            Text(
                text = stringResource(R.string.sign_up_text),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = LoginButtonBlue
            )
        }
    }
}

@Composable
@Preview
fun LoginPageUiPreview() {
    LoginPageUi()
}