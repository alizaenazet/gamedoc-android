package com.example.gamedoc.ui.screens.register.gamer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gamedoc.data.SettingsDataStore
import com.example.gamedoc.model.gamer.GamerRegisterBodyReq
import com.example.gamedoc.network.gamer.GamerContainer
import com.example.gamedoc.ui.ListScreens
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface RegisterGamerUiState{
    data class Success(
        val isSuccess: Boolean,
        val invalidMessage: Map<String, Array<String>>?
    ): RegisterGamerUiState
    data class Error (
        val error: String,
    ): RegisterGamerUiState
    object Loading: RegisterGamerUiState
}

class RegisterGamerViewModel(): ViewModel() {
    var _registerGamerUiState: RegisterGamerUiState by mutableStateOf(RegisterGamerUiState.Success(false,null));
    private var _isAllValid by mutableStateOf(true)

    private var _usernameInput by mutableStateOf("",)
    val username : String
        get() = _usernameInput;

    private var _dob by mutableStateOf("")
    val dob : String
        get() = _dob

    private var _email by mutableStateOf("")
    val email : String
        get() = _email

    private var _phoneNumber by mutableStateOf("")
    val phoneNumber : String
        get() = _phoneNumber

    private var _password by mutableStateOf("")
    val password : String
        get() = _password

    private var _passwordConfirm by mutableStateOf("")
    val passwordConfirm : String
        get() = _passwordConfirm

    fun registerClick(
        navController: NavController,
        dataStore: SettingsDataStore,
    ){
        viewModelScope.launch {
            RegisterGamerUiState.Loading
            try {
                if (_isAllValid) {
                    val registerData = GamerContainer().gamerRepository.gamerRegister(
                        GamerRegisterBodyReq(
                            dob = _dob,
                            email = _email,
                            password = _password,
                            phone_number = _phoneNumber,
                            username = _usernameInput
                        )
                    )

                    when(registerData.statusCode){
                        200 -> {
                            navController.navigate(ListScreens.Login.name)
                        }

                        422 -> {
                            RegisterGamerUiState.Success(
                                isSuccess = false,
                                invalidMessage = registerData.errorResponse!!)
                        }

                    }

                }
            }catch(e: HttpException) {
                RegisterGamerUiState.Error(error = e.message())
            }

        }
    }

    fun onInputUsername(usernameInput: String){
        _usernameInput = usernameInput
    }
    fun validatedUsernameInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 2){
            validationFb("username harus di-isi")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }


    fun onInputDob(dob: String){
        _dob = dob
    }
    fun validatedDobInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        val regEx = "([0-9]{4})[\\-](1[0-2]|0[1-9]|[1-9])[\\-](3[01]|[12][0-9]|0[1-9]|[1-9])$".toRegex()
        if (!regEx.matches(input)){
            validationFb("format DOB invalid, YYYY-MM-DD")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }

    fun onInputEmail(email: String){
        _email = email
    }
    fun validatedEmailInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()){
            validationFb("format email invalid")
            validationFedbFun(false)
            _isAllValid = false
        }else{
            validationFedbFun(true)
            _isAllValid = true
        }
    }

    fun onInputPhoneNumber(phoneNumber: String){
        _phoneNumber = phoneNumber
    }
    fun validatedPhoneNumberInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ) {
        if(input.length > 13 || input.isEmpty()){
            validationFb("gunakan format 62...")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }


    fun onInputPassword(password: String){
        _password = password
    }
    fun validatePasswordInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 8){
            validationFb("password harus lebih 8 kata")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }


    fun onInputPasswordConfirm(password: String){
        _passwordConfirm = password
    }
    fun validatePasswordCofirmInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 8){
            validationFb("password harus lebih 8 kata")
            validationFedbFun(false)
            _isAllValid = false
        }else if(input != _password){
            validationFb("password tidak sama")
            validationFedbFun(false)
            _isAllValid = false
        } else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }





}