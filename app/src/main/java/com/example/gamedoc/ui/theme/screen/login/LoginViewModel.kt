package com.example.gamedoc.ui.theme.screen.login

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamedoc.data.SettingsDataStore
import com.example.gamedoc.model.InvalidMessgRes
import com.example.gamedoc.model.user.LoginBodyRes
import com.example.gamedoc.network.user.UserContainer
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface LoginUiState{
    data class Success (
     val data: LoginBodyRes
    ): LoginUiState
    data class Error (
        val err: InvalidMessgRes
    ): LoginUiState
    object Loading: LoginUiState
}

class LoginViewModel(): ViewModel() {
    var _loginUiState : LoginUiState by mutableStateOf(LoginUiState.Loading);
    init {
        login()
    }

   public fun relogin(){
        login();
    }
    private fun login(){
        viewModelScope.launch {
            _loginUiState = LoginUiState.Loading;
            try {
                val loginData = UserContainer().userRepository.userLogin("","")
                _loginUiState = LoginUiState.Success(loginData);

            }catch (e: Throwable){
                println(e.message)
                _loginUiState = LoginUiState.Error(InvalidMessgRes(e.message!!))
            }catch (e: HttpException){
                println(e.message)
                _loginUiState = LoginUiState.Error(InvalidMessgRes(e.message()))
            }
        }
    }
}