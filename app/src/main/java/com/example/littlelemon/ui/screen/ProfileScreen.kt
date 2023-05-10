package com.example.littlelemon.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.components.LittleLemonButton
import com.example.littlelemon.utils.OnBoarding
import com.example.littlelemon.data.model.UserInfo
import com.example.littlelemon.ui.theme.LittleLemonYellow
import com.example.littlelemon.ui.theme.Typography

@Composable
fun ProfileScreen(navController: NavController) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(top = 8.dp, bottom = 16.dp)
        )

        Text(
            text = "Personal information",
            style = Typography.h3,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        Text(
            text = "First Name",
            style = Typography.caption
        )
        Text(
            text = UserInfo.firstName.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            style = Typography.body2
        )

        Text(
            text = "Last Name",
            style = Typography.caption
        )
        Text(
            text = UserInfo.lastName.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            style = Typography.body2
        )

        Text(
            text = "Email",
            style = Typography.caption
        )
        Text(
            text = UserInfo.email.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            style =  Typography.body2
        )

        LittleLemonButton(
            text = "Logout", onClick = {
                UserInfo.logout(context)
                navController.navigate(OnBoarding.route)

            },
            color = LittleLemonYellow
        )

    }
}