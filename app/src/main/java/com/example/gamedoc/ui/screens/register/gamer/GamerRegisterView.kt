package com.example.gamedoc.ui.screens.register.gamer

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamedoc.model.InvalidMessgRes
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.ui.ListScreens
import com.example.gamedoc.ui.components.Button
import com.example.gamedoc.ui.components.ErrorScreen
import com.example.gamedoc.ui.components.InputField
import com.example.gamedoc.ui.components.LoadingScreen

@Composable
fun GamerRegisterView(
    registerGamerViewModel: RegisterGamerViewModel = viewModel(),
    viewRouteParams: ViewRouteParams
) {
    val registerGamerUiState: RegisterGamerUiState = registerGamerViewModel._registerGamerUiState
    when (registerGamerUiState) {
        is RegisterGamerUiState.Error -> {
            ErrorScreen(
                retryAction = { viewRouteParams.navController.navigate(ListScreens.RegisterGamer.name) },
                message = registerGamerUiState.error)
        }

        is RegisterGamerUiState.Loading -> {
            LoadingScreen()
        }
        is RegisterGamerUiState.Success -> {
            GamerRegister(
                viewRouteParams,
                invalidMessage = registerGamerUiState.invalidMessage,
                isFailed = registerGamerUiState.isFailed,

                userNameState = registerGamerViewModel.username,
                userNameInput = { registerGamerViewModel.onInputUsername(it) },
                userNameValidator = { input, validationFun, validationFedbFun ->
                    registerGamerViewModel.validatedUsernameInput(input,validationFun,validationFedbFun)
                },

                dobState = registerGamerViewModel.dob,
                dobInput = { registerGamerViewModel.onInputDob(it) },
                dobValidator =  { input, validationFun, validationFedbFun ->
                    registerGamerViewModel.validatedDobInput(input,validationFun,validationFedbFun)
                } ,

                emailState = registerGamerViewModel.email,
                emailInput = { registerGamerViewModel.onInputEmail(it) },
                emailValidator =  { input, validationFun, validationFedbFun ->
                    registerGamerViewModel.validatedEmailInput(input,validationFun,validationFedbFun)
                },

                phoneNumberState = registerGamerViewModel.phoneNumber,
                phoneNumberInput = { registerGamerViewModel.onInputPhoneNumber(it) },
                phoneNumberValidator =  { input, validationFun, validationFedbFun ->
                    registerGamerViewModel.validatedPhoneNumberInput(input,validationFun,validationFedbFun)
                } ,

                passwordState = registerGamerViewModel.password,
                passwordInput = { registerGamerViewModel.onInputPassword(it) },
                passwordValidator =  { input, validationFun, validationFedbFun ->
                    registerGamerViewModel.validatePasswordInput(input,validationFun,validationFedbFun)
                } ,

                passwordConfirmState = registerGamerViewModel.passwordConfirm,
                passwordConfirmInput = { registerGamerViewModel.onInputPasswordConfirm(it) },
                passwordConfirmValidator =  { input, validationFun, validationFedbFun ->
                    registerGamerViewModel.validatePasswordCofirmInput(input,validationFun,validationFedbFun)
                } ,

                onRegisterClick = { registerGamerViewModel.registerClick(viewRouteParams.navController,viewRouteParams.dataStore) }
            )
        }



    }
}

@Composable
fun GamerRegister(
    viewRouteParams: ViewRouteParams,
    invalidMessage: String?,
    isFailed: Boolean,

    userNameState: String,
    userNameInput: (String) -> Unit,
    userNameValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    dobState: String,
    dobInput: (String) -> Unit,
    dobValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    emailState: String,
    emailInput: (String) -> Unit,
    emailValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    phoneNumberState: String,
    phoneNumberInput: (String) -> Unit,
    phoneNumberValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    passwordState: String,
    passwordInput: (String) -> Unit,
    passwordValidator:  (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    passwordConfirmState: String,
    passwordConfirmInput: (String) -> Unit,
    passwordConfirmValidator:  (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    onRegisterClick: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 63.dp, horizontal = 20.dp),
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ){
            Row (
                modifier = Modifier.width(130.dp)
            ){
                Button.DefaultFilled(buttonName = "Gamer", onButtonClick = { /*TODO*/ })
            }
            Row (
                modifier = Modifier.width(130.dp)
            ){
                Button.Default(buttonName = "Dokter", onButtonClick = { viewRouteParams.navController.navigate(ListScreens.RegisterDoctor.name) })
            }
        }

        InputField.Login(
            input = userNameState,
            onInputChange = { userNameInput(it) },
            defaultInput = "",
            isValidationFun = {input, validationFun, validationFedbFun ->
                userNameValidator(input,validationFun,validationFedbFun)
            },
            fieldName = "Username",
            info = "your username"
        )

        InputField.Variant6(
            input = dobState,
            onInputChange = { dobInput(it) },
            defaultInput = "",
            isValidationFun = {input, validationFun, validationFedbFun ->
                dobValidator(input,validationFun,validationFedbFun)
            },
            fieldName = "Tanggal lahir",
            info = "yyyy-mm-dd"
        )

        InputField.Variant7(
            input = emailState,
            onInputChange = {emailInput(it)},
            defaultInput = "",
            isValidationFun = {input, validationFun, validationFedbFun ->
                emailValidator(input,validationFun,validationFedbFun)
            },
            fieldName = "email",
            info = "your email"
        )

        InputField.Variant5(
            input = phoneNumberState,
            onInputChange = {phoneNumberInput(it)},
            defaultInput = "",
            isValidationFun = {input, validationFun, validationFedbFun ->
                phoneNumberValidator(input,validationFun,validationFedbFun)
            },
            fieldName = "Phone number",
            info = "your phone number"
        )

        InputField.Password(
            input = passwordState,
            onInputChange = {passwordInput(it)},
            defaultInput = "",
            isValidationFun = {input, validationFun, validationFedbFun ->
                passwordValidator(input,validationFun,validationFedbFun)
            },
            fieldName = "Password",
            info = "your password"
        )

        InputField.Password(
            input = passwordConfirmState,
            onInputChange = { passwordConfirmInput(it) },
            defaultInput = "",
            isValidationFun = {input, validationFun, validationFedbFun ->
                passwordConfirmValidator(input,validationFun,validationFedbFun)
            },
            fieldName = "Password",
            info = "your password"
        )
        if (isFailed){
            Toast.makeText(LocalContext.current,invalidMessage,Toast.LENGTH_LONG).show()
        }
        Button.RoundedFilled(buttonName = "Register", onButtonClick = { onRegisterClick() })
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GamerRegisterScreenPreview(){
//    GamerRegisterView()
//}