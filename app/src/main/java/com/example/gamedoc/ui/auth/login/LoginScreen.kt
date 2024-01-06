package com.example.gamedoc.ui.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamedoc.ui.components.Button
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamedoc.R
import com.example.gamedoc.model.user.LoginBodyRes
import com.example.gamedoc.ui.components.ErrorScreen
import com.example.gamedoc.ui.components.InputField
import com.example.gamedoc.ui.components.LoadingScreen

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
            SuccessScreen(
                isSuccess = loginUiState.isSuccess,
                errMessage = loginViewModel.errorMessage,
                inputEmailState = loginViewModel.emailInput,
                onEmailInput = { loginViewModel.onInputEmail(it) },
                emailValidator = { input, validationFun, validationFedbFun ->
                    loginViewModel.validateEmailInput(input,validationFun,validationFedbFun)
                },

                inputPasswordState = loginViewModel.passwordInput,
                onPasswordInput = { loginViewModel.onInputPassword(it) },
                passwordValidator = { input, validationFun, validationFedbFun ->
                    loginViewModel.validatePasswordInput(input,validationFun,validationFedbFun)
                } ,

                onLoginClick = {loginViewModel.loginClick()},
                onRegisterClick = {loginViewModel.redirectToRegister()}
                )
    }
}

@Composable
fun SuccessScreen(isSuccess: Boolean,
                  errMessage: String = "",
                  inputEmailState: String,
                  onEmailInput: (String) -> Unit,
                  emailValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

                  inputPasswordState: String,
                  onPasswordInput: (String) -> Unit,
                  passwordValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

                  onLoginClick: ()-> Unit,
                  onRegisterClick: ()-> Unit
                  ){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 63.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            InputField.Login(
                input = inputEmailState,
                onInputChange = { onEmailInput(it) },
                defaultInput = "",
                isValidationFun = { input, validationFun, validationFedbFun ->
                    emailValidator(input, validationFun, validationFedbFun)
                },
                fieldName = "Email",
                info = "Masukan email pada akun"
            )

            InputField.Password(
                input = inputPasswordState,
                onInputChange = onPasswordInput,
                defaultInput = "",
                isValidationFun = { input, validationFun, validationFedbFun ->
                    passwordValidator(input, validationFun, validationFedbFun)
                },
                fieldName = "Password",
                info = "Password min:8 karakter"
            )
        }

        Button.Default(buttonName = "Login", onButtonClick = { onLoginClick() })

        Row {
            Text(text = "klik untuk",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
            )
            Text(text = "daftar baru",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.clickable { onRegisterClick() }
            )
        }
        if (!isSuccess){
            Text(text = errMessage, color = Color.Red)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginScreenPreview(){
    LoginScreen(modifier = Modifier.fillMaxSize())
}

/**
 * The home screen displaying error message with re-attempt button.
 */