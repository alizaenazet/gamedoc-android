package com.example.gamedoc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Accent
import com.example.gamedoc.ui.theme.Primary
import com.example.gamedoc.ui.theme.Secondary

class InputField {
    companion object {
        @Composable
        public fun Login(
            input: String,
            onInputChange: (String) -> Unit,
            defaultInput: String,
            isValidationFun: (
                input: String,
                validationFb: (String) -> Unit,
                setIsAllValidFun: (Boolean) -> Unit
            ) -> Unit,
            fieldName: String,
            info: String
        ) {
            var isAllValid by rememberSaveable { mutableStateOf<Boolean>(false) }
            val setIsAllValid: (condition: Boolean) -> Unit = { isAllValid = it }
            var invalidFeedBack = "invalid input";
            val setInvalidFeedBack: (value: String) -> Unit = { invalidFeedBack = it }
            isValidationFun(input, setInvalidFeedBack, setIsAllValid)

            fun inputChanges(fieldInput: String): Boolean {
                if (fieldInput.isEmpty() || !isAllValid) {
                    onInputChange(defaultInput)
                    return false
                }
                onInputChange(fieldInput)
                return true
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTextFieldValidation(
                    name = TextBasicInfo(
                        "User Name",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 16.sp
                    ),
                    info = TextBasicInfo(
                        "",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 16.sp
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Person Icon",
                            tint = Secondary
                        )
                    },
                    state = input,
                    onChange = { inputChanges(it) },
                    invalidFeedBack = invalidFeedBack,
                    shapeRoundedSize = 16.dp,
                    borderColor = Color.Transparent,
                    modifier = Modifier
                        .border(
                            width = 3.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                )
            }
        }

        @Composable
        public fun Password(
            input: String,
            onInputChange: (String) -> Unit,
            defaultInput: String,
            isValidationFun: (
                input: String,
                validationFb: (String) -> Unit,
                setIsAllValidFun: (Boolean) -> Unit
            ) -> Unit,
            fieldName: String,
            info: String
        ) {
            var isAllValid by rememberSaveable { mutableStateOf<Boolean>(false) }
            val setIsAllValid: (condition: Boolean) -> Unit = { isAllValid = it }
            var invalidFeedBack = "invalid input";
            val setInvalidFeedBack: (value: String) -> Unit = { invalidFeedBack = it }
            isValidationFun(input, setInvalidFeedBack, setIsAllValid)

            var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

            fun inputChanges(fieldInput: String): Boolean {
                if (fieldInput.isEmpty() || !isAllValid) {
                    onInputChange(defaultInput)
                    return false
                }
                onInputChange(fieldInput)
                return true
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTextFieldValidation(
                    name = TextBasicInfo(
                        "Password",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 16.sp
                    ),
                    info = TextBasicInfo(
                        "Password",
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 16.sp
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Lock Icon",
                            tint = Secondary
                        )
                    },
                    state = input,
                    onChange = { inputChanges(it) },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (isPasswordVisible) {
                            Icons.Outlined.Visibility
                        } else {
                            Icons.Outlined.VisibilityOff
                        }
                        Icon(
                            imageVector = image,
                            contentDescription = "Visibility Icon",
                            tint = Secondary,
                            modifier = Modifier.clickable { isPasswordVisible = !isPasswordVisible }
                        )
                    },
                    invalidFeedBack = invalidFeedBack,
                    shapeRoundedSize = 16.dp,
                    borderColor = Color.Transparent,
                    modifier = Modifier
                        .border(
                            width = 3.dp,
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.3f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth(),
                )
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant5(
            input: String,
            onInputChange: (String) -> Unit,
            defaultInput: String,
            isValidationFun: (
                input: String,
                validationFb: (String) -> Unit,
                setIsAllValidFun: (Boolean) -> Unit
            ) -> Unit,
            fieldName: String,
            info: String
        ) {
//            var input by rememberSaveable { mutableStateOf("") }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 5.dp, horizontal = 24.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                TextField(
//                    value = input,
//                    onValueChange = {
//                        input = it
//                        onInput(it)
//                    },
//                    label = { Text(text = "Phone Number") },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Outlined.Phone,
//                            contentDescription = "Phone Icon",
//                            tint = Secondary
//                        )
//                    },
//                    supportingText = {
//                        if (input.isEmpty()) {
//                            Text(
//                                text = "Please fill with the right input",
//                                color = Color.Red,
//                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
//                                modifier = Modifier
//                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
//                                    .background(color = Color.White)
//                            )
//                        }
//                    },
//                    modifier = Modifier
//                        .border(
//                            width = 2.dp,
//                            brush = Brush.horizontalGradient(
//                                colorStops = arrayOf(
//                                    0.0f to Accent,
//                                    0.3f to Secondary
//                                )
//                            ),
//                            shape = RoundedCornerShape(16.dp)
//                        )
//                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
//                        .fillMaxWidth(),
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
//                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
//                )
//            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant6(
            input: String,
            onInputChange: (String) -> Unit,
            defaultInput: String,
            isValidationFun: (
                input: String,
                validationFb: (String) -> Unit,
                setIsAllValidFun: (Boolean) -> Unit
            ) -> Unit,
            fieldName: String,
            info: String
        ) {
//            var input by rememberSaveable { mutableStateOf("") }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 5.dp, horizontal = 24.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                TextField(
//                    value = input,
//                    onValueChange = {
//                        input = it
//                        onInput(it)
//                    },
//                    label = { Text(text = "Date") },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Outlined.CalendarMonth,
//                            contentDescription = "Calendar Icon",
//                            tint = Secondary
//                        )
//                    },
//                    supportingText = {
//                        if (input.isEmpty()) {
//                            Text(
//                                text = "Please fill with the right input",
//                                color = Color.Red,
//                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
//                                modifier = Modifier
//                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
//                                    .background(color = Color.White)
//                            )
//                        }
//                    },
//                    modifier = Modifier
//                        .border(
//                            width = 2.dp,
//                            brush = Brush.horizontalGradient(
//                                colorStops = arrayOf(
//                                    0.0f to Accent,
//                                    0.3f to Secondary
//                                )
//                            ),
//                            shape = RoundedCornerShape(16.dp)
//                        )
//                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
//                        .fillMaxWidth(),
//                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
//                )
//            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant7(
            input: String,
            onInputChange: (String) -> Unit,
            defaultInput: String,
            isValidationFun: (
                input: String,
                validationFb: (String) -> Unit,
                setIsAllValidFun: (Boolean) -> Unit
            ) -> Unit,
            fieldName: String,
            info: String
        ) {
//            var input by rememberSaveable { mutableStateOf("") }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 5.dp, horizontal = 24.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                TextField(
//                    value = input,
//                    onValueChange = {
//                        input = it
//                        onInput(it)
//                    },
//                    label = { Text(text = "Email") },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Outlined.AlternateEmail,
//                            contentDescription = "Email Icon",
//                            tint = Secondary
//                        )
//                    },
//                    supportingText = {
//                        if (input.isEmpty()) {
//                            Text(
//                                text = "Please fill with the right input",
//                                color = Color.Red,
//                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
//                                modifier = Modifier
//                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
//                                    .background(color = Color.White)
//                            )
//                        }
//                    },
//                    modifier = Modifier
//                        .border(
//                            width = 2.dp,
//                            brush = Brush.horizontalGradient(
//                                colorStops = arrayOf(
//                                    0.0f to Accent,
//                                    0.3f to Secondary
//                                )
//                            ),
//                            shape = RoundedCornerShape(16.dp)
//                        )
//                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
//                        .fillMaxWidth(),
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
//                )
//            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        public fun Variant8(
            input: String,
            onInputChange: (String) -> Unit,
            defaultInput: String,
            isValidationFun: (
                input: String,
                validationFb: (String) -> Unit,
                setIsAllValidFun: (Boolean) -> Unit
            ) -> Unit,
            fieldName: String,
            info: String
        ) {
//            var input by rememberSaveable { mutableStateOf("") }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 5.dp, horizontal = 24.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                TextField(
//                    value = input,
//                    onValueChange = {
//                        input = it
//                        onInput(it)
//                    },
//                    label = { Text(text = "Input") },
//                    supportingText = {
//                        if (input.isEmpty()) {
//                            Text(
//                                text = "Please fill with the right input",
//                                color = Color.Red,
//                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
//                                modifier = Modifier
//                                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
//                                    .background(color = Color.White)
//                            )
//                        }
//                    },
//                    modifier = Modifier
//                        .border(
//                            width = 2.dp,
//                            brush = Brush.horizontalGradient(
//                                colorStops = arrayOf(
//                                    0.0f to Accent,
//                                    0.3f to Secondary
//                                )
//                            ),
//                            shape = RoundedCornerShape(16.dp)
//                        )
//                        .background(color = Primary, shape = RoundedCornerShape(16.dp))
//                        .fillMaxWidth(),
//                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
//                )
//            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, showSystemUi = true)
@Composable
public fun ComponentPreview() {
    Column(
        Modifier.fillMaxHeight(1f),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        var userTestInput by mutableStateOf("")
//        fun userOnChangeInputTest (input :String){
//            userTestInput = input
//        }

        fun validationTest(
            input: String,
            validationFb: (String) -> Unit,
            validationFedbFun: (Boolean) -> Unit
        ) {
            if (input.length < 3) {
                validationFb("salah cok")
                validationFedbFun(false)
            }
            validationFedbFun(true)
        }

        InputField.Login(
            input = userTestInput,
            onInputChange = { userTestInput = it },
            defaultInput = "",
            isValidationFun = { input, validationFun, validationFedbFun ->
                validationTest(input, validationFun, validationFedbFun)
            },
            info = "info text",
            fieldName = "fieldname"
        )
    }
}
