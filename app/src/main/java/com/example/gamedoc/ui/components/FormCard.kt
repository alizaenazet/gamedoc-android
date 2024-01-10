package com.example.gamedoc.ui.components

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Accent
import com.example.gamedoc.ui.theme.Error
import com.example.gamedoc.ui.theme.Secondary
import com.example.gamedoc.ui.theme.Success

class FormCard {
    companion object {

        @OptIn(ExperimentalLayoutApi::class)
        @Composable
        fun OptionTextInput(
            question: String,
            isRequired: Boolean,
            inputState: String,
            onChooseOption: (Boolean) -> Unit,
            onInputChange: (String) -> Unit,
            placeHolder: String,
            colors: List<Color> = listOf(Success, Secondary)
        ) {
            var chooseOption by remember { mutableStateOf(true) }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(3.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
                    .background(Color.White)

            ) {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    modifier = Modifier
                ) {
                    Text(
                        text = question,
                        color = Secondary,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                    if (!isRequired) {
                        Text(
                            text = "(Opsional)",
                            color = Secondary,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
                Row {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (chooseOption),
                            onClick = {
                                chooseOption = true
                                onChooseOption(true)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Secondary,
                                unselectedColor = Error
                            )
                        )
                        Text(text = "iya")
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (!chooseOption),
                            onClick = {
                                chooseOption = false
                                onChooseOption(false)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Secondary,
                                unselectedColor = Error
                            )
                        )
                        Text(text = "tidak")
                    }
                }

                OutlinedTextField(
                    value = inputState,
                    onValueChange = { onInputChange(it) },
                    placeholder = { Text(text = placeHolder) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(95.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .border(2.dp, Secondary, shape = RoundedCornerShape(16.dp))
                )
            }
        }


        @OptIn(ExperimentalLayoutApi::class)
        @Composable
        fun TextInput(
            question: String,
            isRequired: Boolean,
            inputState: String,
            onInputChange: (String) -> Unit,
            placeHolder: String,
            colors: List<Color> = listOf(Success, Secondary)
        ) {
            var chooseOption by remember { mutableStateOf(true) }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(3.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
                    .background(Color.White)

            ) {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    modifier = Modifier
                ) {
                    Text(
                        text = question,
                        color = Secondary,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                    if (!isRequired) {
                        Text(
                            text = "(Opsional)",
                            color = Secondary,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontStyle = FontStyle.Italic
                        )
                    }
                }

                OutlinedTextField(
                    value = inputState,
                    onValueChange = { onInputChange(it) },
                    placeholder = { Text(text = placeHolder) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(95.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .border(2.dp, Secondary, shape = RoundedCornerShape(16.dp))
                )
            }
        }


        @SuppressLint("MutableCollectionMutableState")
        @OptIn(ExperimentalLayoutApi::class)
        @Composable
        fun Options(
            question: String,
            isRequired: Boolean,
            onChooseOption: (List<String>) -> Unit,
            radioOptions: List<String>,
            colors: List<Color> = listOf(Success, Secondary)
        ) {
            val selectedOptions = remember { mutableStateListOf<String>() }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(3.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
                    .background(Color.White)

            ) {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    modifier = Modifier
                ) {
                    Text(
                        text = question,
                        color = Secondary,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                    if (!isRequired) {
                        Text(
                            text = "(Opsional)",
                            color = Secondary,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
                Column (
                    horizontalAlignment = Alignment.Start
                ){
                    radioOptions.map { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(0.dp)
                                .height(25.dp)
                                .fillMaxWidth()
                        ) {
                            RadioButton(
                                selected = selectedOptions.contains(option),
                                onClick = {
                                    if (selectedOptions.contains(option)) {
                                        selectedOptions.remove(option)
                                        onChooseOption(selectedOptions)
                                    } else {
                                        selectedOptions.add(option)
                                        onChooseOption(selectedOptions)
                                    }
                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Secondary,
                                    unselectedColor = Error
                                )
                            )
                            Text(text = option,color = Secondary, fontFamily = FontFamily(Font(R.font.poppins_regular)))
                        }
                    }
                }
            }
        }
    }
}

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    public fun ComponentFormCardPreview() {
        var tesInput by remember { mutableStateOf("") }
        var tesIsChoosed by remember { mutableStateOf(true) }
        val choosedMultipleOptions = remember { mutableStateListOf<String>() }

        fun onChooseOption(isChoosed: Boolean) {
            tesIsChoosed = isChoosed
        }

        fun onInputChange(input: String) {
            tesInput = input
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
//        FormCard.OptionTextInput(
//            question = "Apakah Anda merasa kehilangan minat atau motivasi untuk melakukan aktivitas lain selain bermain game?",
//            isRequired = false,
//            inputState = tesInput,
//            onChooseOption = {onChooseOption(it)},
//            onInputChange = {onInputChange(it)},
//            placeHolder = "placeholder..."
//        )

//            FormCard.TextInput(
//                question = "Apakah Anda merasa kehilangan minat atau motivasi untuk melakukan aktivitas lain selain bermain game?",
//                isRequired = false,
//                inputState = tesInput,
//                onInputChange = { onInputChange(it) },
//                placeHolder = "placeholder..."
//            )

            FormCard.Options(question = "info keluhan mu",
                isRequired = false,
                onChooseOption = {choosedMultipleOptions.clear();
                                 it.map { choosedMultipleOptions.add(it) }
                                 },
                radioOptions = listOf("Mental","Sosial","Fisik")
            )


            Row {
                Text(text = "$tesInput   $tesIsChoosed ${choosedMultipleOptions.toList().toString()}")
            }
        }
    }

