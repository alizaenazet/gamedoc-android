package com.example.gamedoc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Secondary
import com.example.gamedoc.ui.theme.Success
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider

class Button {
    companion object {
        @Composable
        public fun Default(
            buttonName: String,
            onButtonClick: () -> Unit,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onButtonClick },
                    modifier = Modifier
                        .width(300.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Brush.horizontalGradient(colors)),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = buttonName, fontSize = 14.sp, style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    )
                }
            }
        }

        @Composable
        public fun Kotak(
            buttonName: String,
            onButtonClick: () -> Unit,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onButtonClick },
                    modifier = Modifier
                        .width(300.dp)
                        .clip(RoundedCornerShape(10))
                        .background(Brush.horizontalGradient(colors)),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = buttonName, fontSize = 14.sp, style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    )
                }
            }
        }

        @Composable
        public fun PutihBunder(
            buttonName: String,
            onButtonClick: () -> Unit,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onButtonClick },
                    modifier = Modifier
                        .width(300.dp)
//                        .clip(RoundedCornerShape(50))
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Color.White)
//                        .color(Color.White)
                        .border(
                            BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                            RoundedCornerShape(50.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = buttonName, fontSize = 14.sp,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ),
                        color = Secondary,
                    )
                }
            }
        }

        @Composable
        public fun PutihKotak(
            buttonName: String,
            onButtonClick: () -> Unit,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onButtonClick },
                    modifier = Modifier
                        .width(300.dp)
//                        .clip(RoundedCornerShape(50))
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Color.White)
//                        .color(Color.White)
                        .border(
                            BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                            RoundedCornerShape(50.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = buttonName, fontSize = 14.sp,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ),
                        color = Secondary,
                    )
                }
            }
        }

        @Composable
        public fun Dropdown(

            buttonName: String,
            onButtonClick: () -> Unit,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onButtonClick },
                    modifier = Modifier
                        .width(300.dp)
//                        .clip(RoundedCornerShape(50))
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color.White)
//                        .color(Color.White)
                        .border(
                            BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                            RoundedCornerShape(10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(text = buttonName, fontSize = 14.sp, style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_medium))),
                        color = Secondary,
                    )
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "dropdown icon", tint = Secondary,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
        }
        @Composable
        public fun Dropdown(
            buttonName: String,
            onButtonClick: () -> Unit,
            onItemSelected: (String) -> Unit,
            items: List<String>,
            selectedValue: String,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            var expanded by remember { mutableStateOf(false) }
            var selectedItem by remember { mutableStateOf(items.firstOrNull()) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Original Button code
                Button(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .width(300.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .border(
                            BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                            RoundedCornerShape(10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = buttonName,
                        fontSize = 14.sp,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ),
                        color = Secondary
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "dropdown icon",
                        tint = Secondary,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }

                // Dropdown
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(300.dp)
                        .border(
                            BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                            RoundedCornerShape(10.dp)
                        )
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                selectedItem = item
                                onItemSelected(item)
                            }
                        ) {
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                                Text(text = item)
                            }
                        }
                    }
                }
            }
        }
    }


    @SuppressLint("UnrememberedMutableState")
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    public fun ComponentPreview() {
        val items = listOf("Option 1", "Option 2", "Option 3")
        var selectedItem by remember { mutableStateOf<String?>(null) }
        Column(
            Modifier.fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceAround

        ) {
            Button.Default(
                buttonName = "Button",
                onButtonClick = {}
            )
            Button.Kotak(
                buttonName = "Button",
                onButtonClick = {}
            )
            Button.PutihBunder(
                buttonName = "Button",
                onButtonClick = {}
            )
            Button.PutihKotak(
                buttonName = "Button",
                onButtonClick = {}
            )
            Button.Dropdown(
                buttonName = "Dropdown Button",
                onButtonClick = {},
                onItemSelected = { selectedItem = it },
                items = items,
                selectedValue = selectedItem
                        selectedItem = it
            )

        }
    }
}

