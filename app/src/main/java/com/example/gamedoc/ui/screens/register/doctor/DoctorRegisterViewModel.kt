package com.example.gamedoc.ui.screens.register.doctor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed interface DoctorRegisterUiState {
    data class Success(
        val isSuccess: Boolean
    ): DoctorRegisterUiState
    data class Error(
        val errMessage: String
    ): DoctorRegisterUiState
    object Loading : DoctorRegisterUiState
}

class DoctorRegisterViewModel(): ViewModel() {
    var _doctorRegisterUiState: DoctorRegisterUiState by mutableStateOf(DoctorRegisterUiState.Success(false))
        private set

    private var _usernameInput by mutableStateOf("")
    val usernameInput : String
        get() = _usernameInput;

    fun setUsernameInput(username: String){
        _usernameInput = username
    }
    fun usernameValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 2) {
            validationFb("email tidak valid")
            validationFedbFun(false)
        }else {
            validationFedbFun(true)
        }
    }

}