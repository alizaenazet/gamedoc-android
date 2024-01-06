package com.example.gamedoc.ui.auth.login

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamedoc.model.InvalidMessgRes
import com.example.gamedoc.model.user.LoginBodyRes
import com.example.gamedoc.network.user.UserContainer
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface LoginUiState{
    data class Success (
     val isSuccess: Boolean
    ): LoginUiState
    data class Error (
        val err: InvalidMessgRes
    ): LoginUiState
    object Loading: LoginUiState
}

class LoginViewModel(): ViewModel() {
    var _loginUiState : LoginUiState by mutableStateOf(LoginUiState.Success(false));
    private var _isAllValid by mutableStateOf(true)
    private var _userEmailInput by mutableStateOf("")
    val emailInput : String
        get() = _userEmailInput;

    private var _userPasswordInput by mutableStateOf("")
    val passwordInput : String
        get() = _userPasswordInput

    private var _errorMessage by mutableStateOf("")
    val errorMessage : String
        get() = _errorMessage

    init {
        login()
    }

   public fun relogin(){
        login();
    }
    private fun login(){
        viewModelScope.launch {
            _loginUiState = LoginUiState.Success(false);
            try {
                if (_isAllValid){
                    val loginData = UserContainer().userRepository.userLogin(_userEmailInput,_userPasswordInput)
                    _loginUiState = LoginUiState.Success(isSuccess = true);
                }
                _loginUiState = LoginUiState.Success(false);
            }catch (e: Throwable){
                _errorMessage = e.message!!
                _loginUiState = LoginUiState.Success(isSuccess = false);
            }catch (e: HttpException){
                _errorMessage = e.message!!
                _loginUiState = LoginUiState.Error(InvalidMessgRes(e.message()))
            }
        }
    }

     fun onInputEmail(email:String){
        _userEmailInput = email
    }

     fun onInputPassword(password:String){
        _userPasswordInput = password
    }

     fun loginClick(){
        login()
    }

      fun validateEmailInput(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
          val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
          if (!input.matches(emailRegex.toRegex())){
              validationFb("email tidak valid")
              validationFedbFun(false)
              _isAllValid = false
          }
          validationFedbFun(true)
          _isAllValid = true
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
        }
        validationFedbFun(true)
        _isAllValid = true
    }

    fun redirectToRegister(){

    }
}