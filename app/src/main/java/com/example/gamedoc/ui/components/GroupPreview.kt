package com.example.gamedoc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

class GroupPreview {
    companion object {
        @Composable
        public fun Default(
            onClickGroup: () -> Unit
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                    .border(
                        width = 3.dp,
                        brush = Brush.horizontalGradient(
                            colorStops = arrayOf(
                                0.0f to Accent,
                                0.3f to Secondary
                            )
                        ),
                        shape = RoundedCornerShape(30)
                    )
                    .clickable(onClick = onClickGroup),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                    )

                    Column(
                        modifier = Modifier.padding(start = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Row {
                            Text(
                                text = "Nama Grup",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    color = Secondary,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                                )
                            )
                        }

                        Row {
                            Text(
                                text = "Description",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Secondary,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                                )
                            )
                        }
                    }
                }
            }
        }

        @Composable
        public fun DoctorGroup(
            onClickGroup: () -> Unit,
            onClickEdit: () -> Unit,
            onClickDelete: () -> Unit
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                    .border(
                        width = 3.dp,
                        brush = Brush.horizontalGradient(
                            colorStops = arrayOf(
                                0.0f to Accent,
                                0.3f to Secondary
                            )
                        ),
                        shape = RoundedCornerShape(30)
                    )
                    .clickable(onClick = onClickGroup),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.padding(end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                        )

                        Column(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Row {
                                Text(
                                    text = "Nama Grup",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = Secondary,
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                                    )
                                )
                            }

                            Row {
                                Text(
                                    text = "Description",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Secondary,
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                                    )
                                )
                            }
                        }
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(0.dp),
                        onClick = onClickEdit
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Edit Button",
                            tint = Secondary,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(0.dp),
                        onClick = onClickDelete
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Delete Button",
                            tint = Secondary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }

        @Composable
        public fun GamerGroup(
            onClickGroup: () -> Unit,
            onClickJoin: () -> Unit
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(Primary)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                    .border(
                        width = 3.dp,
                        brush = Brush.horizontalGradient(
                            colorStops = arrayOf(
                                0.0f to Accent,
                                0.3f to Secondary
                            )
                        ),
                        shape = RoundedCornerShape(30)
                    )
                    .clickable(onClick = onClickGroup),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.padding(end = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                        )

                        Column(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Row {
                                Text(
                                    text = "Nama Grup",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = Secondary,
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                                    )
                                )
                            }

                            Row {
                                Text(
                                    text = "Description",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Secondary,
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                                    )
                                )
                            }
                        }
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        onClick = onClickJoin,
                        modifier = Modifier.background(
                            Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0.0f to Secondary,
                                    0.9f to Accent
                                )
                            ),
                            shape = RoundedCornerShape(60)
                        ).width(100.dp)
                    ) {
                        Text(
                            text = "Join",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.poppins_light))
                            )
                        )
                    }
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
            GroupPreview.Default(
                onClickGroup = {}
            )

            GroupPreview.DoctorGroup(
                onClickGroup = {},
                onClickEdit = {},
                onClickDelete = {}
            )

            GroupPreview.GamerGroup(
                onClickGroup = {},
                onClickJoin = {}
            )
        }
    }
}