package com.example.gamedoc.ui.screens.register.doctor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.model.doctor.DoctorRegisterBodyReq
import com.example.gamedoc.network.doctor.DoctorContainer
import com.example.gamedoc.ui.ListScreens
import com.example.gamedoc.ui.screens.register.gamer.RegisterGamerUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException

sealed interface DoctorRegisterUiState {
    data class Success(
        val isSuccess: Boolean,
        val invalidMessage: String?,
        val isFailed: Boolean
    ): DoctorRegisterUiState
    data class Error(
        val error: String
    ): DoctorRegisterUiState
    object Loading : DoctorRegisterUiState
}

class DoctorRegisterViewModel(viewRouteParams: ViewRouteParams) : ViewModel() {
    var _doctorRegisterUiState: DoctorRegisterUiState by mutableStateOf(DoctorRegisterUiState.Success(false,null,false))
        private set
    private var _isAllValid by mutableStateOf(true)

    private var _usernameInput by mutableStateOf("")
    val usernameInput : String
        get() = _usernameInput;
    fun setUsernameInput(username: String){
        _usernameInput = username
    }

    private var _userEmailInput by mutableStateOf("")
    val emailInput: String
        get() = _userEmailInput
    fun setEmailInput(email: String){
        _userEmailInput = email
    }

    private var _userPasswordInput by mutableStateOf("")
    val passwordInput: String
        get() = _userPasswordInput
    fun setPasswordInput(password: String){
        _userPasswordInput = password
    }

    private var _userPasswordConfirmInput by mutableStateOf("")
    val passwordConfirmInput: String
        get() = _userPasswordConfirmInput
    fun setPasswordConfirmInput(password: String){
        _userPasswordConfirmInput = password
    }

    private var _userDegreeInput by mutableStateOf("")
    val degreeInput: String
        get() = _userDegreeInput
    fun setDegreeInput(degree: String){
        _userDegreeInput = degree
    }

    private var _userServicesInput by mutableStateOf(listOf(""))
    val servicesViewOptions: List<String>
        get() = listOf("group","personal","personal & group");
    fun setServicesInput(serviceSelectedIndex: Int){
        val servicesValueOptions = listOf(listOf("group"), listOf("personal"), listOf("personal","group"));
        _userServicesInput = servicesValueOptions[serviceSelectedIndex]
    }

    private var _userProfessionInput by mutableStateOf("")
    val professionOptions: List<String>
        get() = listOf("pyscholog","psikiater","fisioterapis","social worker")
    fun setProfessionInput(professionSelectedIndex: Int){
        val professionValueOptions = listOf("pyscholog","psikiater","fisioterapis","social_worker")
        _userProfessionInput = professionValueOptions[professionSelectedIndex]
    }

    private var _userDobInput by mutableStateOf("")
    val dobInput : String
        get() = _userDobInput
    fun setDobInput(dob: String){
        _userDobInput = dob
    }

    private var _userPhoneNumberInput by mutableStateOf("")
    val phoneNumberInput : String
        get() = _userPhoneNumberInput
    fun setPhoneNumber(phoneNumber: String){
        _userPhoneNumberInput = phoneNumber
    }


    fun doctorRegister(
        navController: NavController,
    ){
        viewModelScope.launch {
            DoctorRegisterUiState.Loading
            try {
             if (_isAllValid){
                 val registerData = DoctorContainer().doctorRepository.doctorRegister(
                     DoctorRegisterBodyReq(
                         degree = _userDegreeInput,
                         email = _userEmailInput,
                         profession = _userProfessionInput,
                         services = _userServicesInput,
                         password = _userPasswordInput,
                         username = _usernameInput,
                         dob = _userDobInput,
                         phone_number = _userPhoneNumberInput
                     )
                 )
                 when(registerData.statusCode){
                     201 -> {
                         RegisterGamerUiState.Success(true)
                         navController.navigate(ListScreens.Login.name)
                     }

                     422 -> {
                         RegisterGamerUiState.Success(
                             isSuccess = false,
                             isFailed = true,
                             invalidMessage = "invalid register account")
                     }
                 }
             }
            }catch(e: HttpException) {
                RegisterGamerUiState.Error(error = e.message())
            }
        }
    }

    fun phoneNumberValidator(
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

    fun dobValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        val regEx = "^([0-9]{4})-([0-9]{1,2})-([0-9]{1,2})\$".toRegex()
        if (!regEx.matches(input)){
            validationFb("format DOB invalid, YYYY-MM-DD")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }

    fun professionValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.isEmpty()){
            validationFb("wajib di-isi")
            validationFedbFun(false)
            _isAllValid = false
        }else{
            validationFedbFun(true)
            _isAllValid = true
        }
    }

    fun degreeValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.isEmpty()){
            validationFb("wajib di-isi")
            validationFedbFun(false)
            _isAllValid = false
        }else{
            validationFedbFun(true)
            _isAllValid = true
        }
    }

    fun usernameValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 2) {
            validationFb("username terlalu pendek")
            validationFedbFun(false)
        }else {
            validationFedbFun(true)
        }
    }

    fun emailValidator(
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

    fun passwordValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 7){
            validationFb("password harus lebih 8 kata")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }
    }

    fun passwordConfirmValidator(
        input: String,
        validationFb: (String) -> Unit,
        validationFedbFun: (Boolean) -> Unit
    ){
        if (input.length < 7){
            validationFb("password harus lebih 8 kata")
            validationFedbFun(false)
            _isAllValid = false
        }else {
            validationFedbFun(true)
            _isAllValid = true
        }

        if (input != _userPasswordInput){
            validationFb("password harus sama")
            validationFedbFun(false)
            _isAllValid = false
        }
    }



}

