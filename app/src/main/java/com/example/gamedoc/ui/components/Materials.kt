package com.example.gamedoc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamedoc.R

class TextBasicInfo(
        val value: String,
        val color: Color,
        val textAlign : TextAlign,
        val fontFamily: FontFamily,
        val fontSize: TextUnit
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldValidation(
    name: TextBasicInfo = TextBasicInfo(
        "tes",
        color = Color.Red,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 10.sp
    ),
    info: TextBasicInfo,
    state: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onChange: (String) -> Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    invalidFeedBack: String = "Invalid input",
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Gray,
    shapeRoundedSize: Dp = 12.dp,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {

    var textInput by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        OutlinedTextField(
            value = state,
            label = {
                Text(
                    text = name.value,
                    color = name.color,
                    textAlign = name.textAlign,
                    fontFamily = name.fontFamily,
                    fontSize = name.fontSize
                )
            },
            placeholder = {
                Text(
                    text = info.value,
                    color = info.color,
                    textAlign = info.textAlign,
                    fontFamily = info.fontFamily,
                    fontSize = info.fontSize
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            ),
            onValueChange = { input ->
                isValid = onChange(input)
                textInput = input
            },
            leadingIcon = { leadingIcon?.invoke() },
            trailingIcon = { trailingIcon?.invoke() },
            shape = RoundedCornerShape(shapeRoundedSize),
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
            ),
            isError = !isValid,
            modifier = modifier
        )
        if (!isValid){
            Text(text = invalidFeedBack)
        }

    }

}