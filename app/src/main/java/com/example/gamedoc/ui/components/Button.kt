package com.example.gamedoc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Accent
import com.example.gamedoc.ui.theme.Primary
import com.example.gamedoc.ui.theme.Secondary

class Button {
    companion object {
        @Composable
        public fun Default(
            onClickButton: () -> Unit,
            buttonName: String
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = onClickButton,
                    modifier = Modifier
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.8f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(50)
                        )
                        .width(200.dp)
                ) {
                    Text(
                        text = buttonName,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        )
                    )
                }
            }
        }

        @Composable
        public fun Rectangle(
            onClickButton: () -> Unit,
            buttonName: String
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(vertical = 5.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = onClickButton,
                    modifier = Modifier
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    0.0f to Accent,
                                    0.8f to Secondary
                                )
                            ),
                            shape = RoundedCornerShape(20)
                        )
                        .width(200.dp)
                ) {
                    Text(
                        text = buttonName,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        )
                    )
                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    public fun ComponentPreview() {
        Column(
            Modifier.fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Button.Default(
                onClickButton = {},
                buttonName = "Button"
            )

            Button.Rectangle(
                onClickButton = {},
                buttonName = "Button"
            )
        }
    }
}