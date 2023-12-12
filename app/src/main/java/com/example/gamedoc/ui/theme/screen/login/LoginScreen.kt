package com.example.gamedoc.ui.theme.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamedoc.model.user.LoginBodyRes

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    modifier: Modifier
){
    val loginUiState: LoginUiState = loginViewModel._loginUiState

    when(loginUiState){
        is LoginUiState.Error ->
            ErrorScreen(retryAction = { loginViewModel.relogin() }, loginUiState.err.message)
        is LoginUiState.Loading ->
            LoadingScreen()
        is LoginUiState.Success ->
            SuccessScreen(data = loginUiState.data)
    }
}

@Composable
fun SuccessScreen(data: LoginBodyRes){
    LazyColumn(
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(text = data.id)
        }
        item {
            Text(text = data.role)
        }
        item {
            Text(text = data.token)
        }
        item {
            Text(text = "\n\n ${data.toString()}")
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(100.dp),
        imageVector = Icons.Default.Cached,
        contentDescription = "Loading")
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit,
                message: String,
                modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(imageVector = Icons.Default.ErrorOutline, contentDescription = "Error")
        Text(text = message, modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text("Try again")
        }
    }
}
