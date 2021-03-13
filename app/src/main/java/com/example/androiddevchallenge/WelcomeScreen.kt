package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.primary)
        .fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.ic_welcome_bg), contentDescription = null)
        Column {
            Image(
                painterResource(id = R.drawable.ic_welcome_illos),
                contentDescription = null,
                modifier = Modifier.padding(top = 72.dp, start = 88.dp)
            )
            Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null,
                modifier = Modifier
                    .padding(top = 48.dp)
                    .align(Alignment.CenterHorizontally))
            Text("Beautiful home garden solutions",style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
            Button(onClick = {}, shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                    .height(48.dp)) {
                Text("Create account", style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary)
            }
            Box(modifier = Modifier
                .clickable {navController.navigate("Login")}
                .align(Alignment.CenterHorizontally)) {
                Text(
                    "Log in", modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.button,
                    color = if (isSystemInDarkTheme()) white else pink900
                )
            }
        }
    }
}