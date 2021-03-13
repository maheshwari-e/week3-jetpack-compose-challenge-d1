package com.example.androiddevchallenge

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally){
        val emailAddress = rememberSaveable { mutableStateOf("") }
        val password = rememberSaveable{ mutableStateOf("")}
        Text("Log in with email", modifier = Modifier.padding(top= 184.dp),
            color = MaterialTheme.colors.onPrimary,
            style =MaterialTheme.typography.h1)
        OutlinedTextField(value = emailAddress.value,
            onValueChange = {emailAddress.value = it},
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                .height(56.dp)
                .fillMaxWidth(),
            label = { Text("Email Address",
                style = MaterialTheme.typography.body1,
                color =  MaterialTheme.colors.onPrimary)}
        )
        OutlinedTextField(value = password.value,
            onValueChange = {password.value = it},
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp)
                .height(56.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Password (8+ characters)",
                style = MaterialTheme.typography.body1,
                color =  MaterialTheme.colors.onPrimary)}
        )
        Text("By Clicking below, you agree to our Terms od Use and consent to our Privacy Policy",
            style = MaterialTheme.typography.body2, color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 12.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center)
        Button(onClick = {navController.navigate("Home")}, shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .height(48.dp)) {
            Text("Log in", style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSecondary)
        }
    }
}