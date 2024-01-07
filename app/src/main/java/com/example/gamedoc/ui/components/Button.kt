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
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import androidx.compose.runtime.mutableIntStateOf

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
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Color.White)
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
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Color.White)
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
            options: List<String>,
            selectedIndex: (Int) -> Unit,
            text: String,
            colors: List<Color> = listOf(Secondary, Success)
        ) {
            var expanded by remember { mutableStateOf(false) }
            val closeDropDown: () -> Unit = { expanded = false }
            var currentSelectedIndex by remember { mutableIntStateOf(-1) }
            if (currentSelectedIndex >= 0) {
                selectedIndex(currentSelectedIndex);
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.TopStart)
                    .clickable { expanded = !expanded }
                    .background(Color.White, shape = RoundedCornerShape(size = 6.dp))
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(
                        BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(6.dp)
                    )
                    .defaultMinSize(minWidth = 190.dp)
                    .padding(vertical = 7.dp, horizontal = 35.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = if (currentSelectedIndex >= 0) {
                            options[currentSelectedIndex]
                        } else {
                            text
                        },
                        color = Secondary,
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "dropdown icon",
                        tint = Secondary
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        closeDropDown()
                    },
                    modifier = Modifier
                        .background(Color.White)
                ) {
                    for ((index, value) in options.withIndex()) {
                        DropdownMenuItem(
                            text = { Text(text = value) },
                            onClick = {
                                currentSelectedIndex = index
                            },
                            enabled = currentSelectedIndex != index
                        )
                    }
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, showSystemUi = true)
@Composable
public fun ComponentButtonPreview() {
    val items = listOf("Option 1", "Option 2", "Option 3")
    var selectedItem by remember { mutableStateOf("default") }
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
        Text(text = selectedItem)
        Button.Dropdown(
            options = items,
            selectedIndex = { selectedItem = items[it] },
            text = "Dropdown"
        )

    }

}