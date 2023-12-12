package com.example.gamedoc.ui.theme.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamedoc.model.LoginBodyRes
import com.example.gamedoc.network.user.UserContainer
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface LoginUiState{
    data class Success (
     val data: LoginBodyRes
    ): LoginUiState
    object Error: LoginUiState
    object Loading: LoginUiState
}

class LoginViewModel(): ViewModel() {
    private lateinit var login: LoginBodyRes;
    var _loginUiState : LoginUiState by mutableStateOf(LoginUiState.Loading);
    init {
        login()
    }

    private fun login(){
        viewModelScope.launch {
            _loginUiState = LoginUiState.Loading;
            try {
                val loginData = UserContainer().userRepository.userLogin("correctemail@email.com","correctpassword123")
                _loginUiState = LoginUiState.Success(loginData)
            }catch (e: IOException){
                _loginUiState = LoginUiState.Error
            }catch (e: HttpException){
                _loginUiState = LoginUiState.Error
            }
        }
    }
}