package com.example.littlelemon.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.R.*
import com.example.littlelemon.utils.HomeScreen
import com.example.littlelemon.components.LittleLemonButton
import com.example.littlelemon.utils.OnBoarding
import com.example.littlelemon.data.model.UserInfo
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.ui.theme.LittleLemonYellow
import com.example.littlelemon.ui.theme.Typography

@Composable
fun OnBoarding(navController: NavController) {

    navController.clearBackStack(OnBoarding.route)

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Logo image
        Image(
            painter = painterResource(id = drawable.logo),
            contentDescription = context.getString(string.logo),
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .padding(top = 8.dp, bottom = 16.dp)
        )

        // Title with green background
        Text(
            text = stringResource(id = string.onboarding_title),
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(font.roboto_regular)),
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(LittleLemonGreen)
                .padding(16.dp)
                .fillMaxWidth()
                .height(85.dp)
                .wrapContentHeight()

        )

        Text(
            style = Typography.h3,
            text = context.getString(string.personal_information),
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        Text(
            text = context.getString(string.first_name),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(font.roboto_regular, FontWeight.Bold))
        )

        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Text(
            text = context.getString(string.last_name),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(font.roboto_regular, FontWeight.Bold)),
        )

        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Text(
            text = context.getString(string.email),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(font.roboto_regular, FontWeight.Bold))
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        LittleLemonButton(
            text = context.getString(R.string.register), onClick = {

                if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
                    Toast.makeText(context, string.unsuccessful_reg, Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, string.successful_reg, Toast.LENGTH_LONG).show()
                    saveUser(firstName, lastName, email, true, context)
                    navController.navigate(HomeScreen.route)
                }

            },
            color = LittleLemonYellow
        )
    }
}

fun saveUser(
    firstName: String,
    lastName: String,
    email: String,
    isLoggedIn: Boolean,
    context: Context
) {
    UserInfo.firstName = firstName
    UserInfo.lastName = lastName
    UserInfo.email = email
    UserInfo.isLoggedIn = isLoggedIn
    UserInfo.saveToPreferences(context)
}









