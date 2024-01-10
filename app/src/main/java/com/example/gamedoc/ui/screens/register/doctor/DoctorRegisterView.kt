package com.example.gamedoc.ui.screens.register.doctor

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.gamedoc.data.SettingsDataStore
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.ui.ListScreens
import com.example.gamedoc.ui.components.Button
import com.example.gamedoc.ui.components.ErrorScreen
import com.example.gamedoc.ui.components.InputField
import com.example.gamedoc.ui.components.LoadingScreen

@Composable
fun DoctorRegisterView(
    doctorGamerViewModel: DoctorRegisterViewModel = viewModel(),
    viewRouteParams: ViewRouteParams
) {
    val registerDoctorUiState: DoctorRegisterUiState = doctorGamerViewModel._doctorRegisterUiState
    when (registerDoctorUiState) {
        is DoctorRegisterUiState.Error -> {
            ErrorScreen(
                retryAction = { viewRouteParams.navController.navigate(ListScreens.RegisterGamer.name) },
                message = registerDoctorUiState.error)
        }

        is DoctorRegisterUiState.Loading -> {
            LoadingScreen()
        }
        is DoctorRegisterUiState.Success -> {
            GamerRegister(
                viewRouteParams,
                invalidMessage = registerDoctorUiState.invalidMessage,
                isFailed = registerDoctorUiState.isFailed,

                userNameState = doctorGamerViewModel.usernameInput,
                userNameInput = { doctorGamerViewModel.setUsernameInput(it) },
                userNameValidator = { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.usernameValidator(input,validationFun,validationFedbFun)
                },

                emailState = doctorGamerViewModel.emailInput,
                emailInput = { doctorGamerViewModel.setEmailInput(it) },
                emailValidator =  { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.emailValidator(input,validationFun,validationFedbFun)
                },

                passwordState = doctorGamerViewModel.passwordInput,
                passwordInput = { doctorGamerViewModel.setPasswordInput(it) },
                passwordValidator =  { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.passwordValidator(input,validationFun,validationFedbFun)
                } ,

                passwordConfirmState = doctorGamerViewModel.passwordConfirmInput,
                passwordConfirmInput = { doctorGamerViewModel.setPasswordConfirmInput(it) },
                passwordConfirmValidator =  { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.passwordConfirmValidator(input,validationFun,validationFedbFun)
                } ,

                degreeState = doctorGamerViewModel.degreeInput,
                degreeInput = { doctorGamerViewModel.setDegreeInput(it) },
                degreeValidator = { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.degreeValidator(input,validationFun,validationFedbFun)
                } ,

                servicesOptions = doctorGamerViewModel.servicesViewOptions,
                servicesInput = {doctorGamerViewModel.setServicesInput(it)},

                dobState = doctorGamerViewModel.dobInput,
                dobInput = {doctorGamerViewModel.setDobInput(it)},
                dobValidator = { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.dobValidator(input,validationFun,validationFedbFun)
                },

                phoneNumberState = doctorGamerViewModel.phoneNumberInput,
                phoneNumberInput = {doctorGamerViewModel.setPhoneNumber(it)},
                phoneNumberValidator = { input, validationFun, validationFedbFun ->
                    doctorGamerViewModel.phoneNumberValidator(input,validationFun,validationFedbFun)
                },

                professionOptions = doctorGamerViewModel.professionOptions,
                professionInput = { doctorGamerViewModel.setProfessionInput(it) },
                onRegisterClick = { doctorGamerViewModel.doctorRegister(viewRouteParams.navController) }
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

    emailState: String,
    emailInput: (String) -> Unit,
    emailValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    passwordState: String,
    passwordInput: (String) -> Unit,
    passwordValidator:  (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    passwordConfirmState: String,
    passwordConfirmInput: (String) -> Unit,
    passwordConfirmValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    degreeState: String,
    degreeInput: (String) -> Unit,
    degreeValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    servicesOptions: List<String>,
    servicesInput: (Int) -> Unit,

    phoneNumberState: String,
    phoneNumberInput: (String) -> Unit,
    phoneNumberValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    dobState: String,
    dobInput: (String) -> Unit,
    dobValidator: (String, (String) -> Unit, (Boolean) -> Unit) -> Unit,

    professionOptions:  List<String>,
    professionInput: (Int) -> Unit,
    
    onRegisterClick: () -> Unit
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 63.dp, horizontal = 20.dp),
    ) {
        item {
            Row (
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ){
                Row (
                    modifier = Modifier.width(130.dp)
                ){
                    Button.Default(buttonName = "Gamer", onButtonClick = { viewRouteParams.navController.navigate(ListScreens.RegisterGamer.name)  })
                }
                Row (
                    modifier = Modifier.width(130.dp)
                ){
                    Button.DefaultFilled(buttonName = "Dokter", onButtonClick = { /* Disable */})
                }
            }
        }

        item {
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
        }

        item {
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
        }

        item {
            InputField.Variant8(
                input = degreeState,
                onInputChange = degreeInput,
                defaultInput = "",
                isValidationFun = {input, validationFun, validationFedbFun ->
                    degreeValidator(input,validationFun,validationFedbFun)
                },
                fieldName = "degree",
                info = "ex: S.Kom"
            )
        }

        item {
            Column(
                modifier = Modifier.height(60.dp)
//                    .fillMaxWidth()
            ) {
                Button.Dropdown(
                    options = servicesOptions,
                    selectedIndex = { servicesInput(it) },
                    text = "services"
                )
            }
        }

        item {
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
        }

        item {

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
        }

        item {
            // TODO(fix: Dropdown component view)
            Column(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            ) {
                Button.Dropdown(
                    options = professionOptions,
                    selectedIndex = { professionInput(it) },
                    text = "profession"
                )
            }
        }



        item {
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
        }

        item { InputField.Password(
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
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, showSystemUi = true)
@Composable
public fun ButtonComponentPreview() {
    val navController = rememberNavController()
    DoctorRegisterView(viewRouteParams = ViewRouteParams(rememberNavController(),
        SettingsDataStore(LocalContext.current),
        {true}
    ))
}