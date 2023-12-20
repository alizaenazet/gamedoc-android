package com.example.gamedoc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LibraryAdd
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp;
import com.example.gamedoc.R;
import androidx.compose.material3.Icon;
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.gamedoc.ui.theme.Secondary
import com.example.gamedoc.ui.theme.poppins

class BottomNavBar {
    companion object {
        @Composable
        public fun UserDefault(
            onClickDoctors : () -> Unit,
            onClickGroups : () -> Unit,
            onClickPost : () -> Unit,
            onClickProfile : () -> Unit,
            onClickFavorite : () -> Unit
        ) {
            Row (
                modifier = Modifier
                    .background(Secondary)
                    .fillMaxWidth(1f)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickFavorite) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(painter = painterResource(id = R.drawable.ecg_heart),
                            contentDescription = "Favorite icon", tint = Color.White
                        )
                        Text(text = "Favorite", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPost) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.LibraryAdd,
                            contentDescription = "Post icon", tint = Color.White
                        )
                        Text(text = "Post", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickDoctors) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(painter = painterResource(id = R.drawable.clinical_notes),
                            contentDescription = "Doctor icon", tint = Color.White
                        )
                        Text(text = "Doctors", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickGroups) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.Group,
                            contentDescription = "Group icon", tint = Color.White
                        )
                        Text(text = "Group", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickProfile) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.AccountCircle,
                            contentDescription = "Profile icon", tint = Color.White
                        )
                        Text(text = "Profile", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

            }
        }

        @Composable
        public fun UserRounded(
            onClickDoctors : () -> Unit,
            onClickGroups : () -> Unit,
            onClickPost : () -> Unit,
            onClickProfile : () -> Unit,
            onClickFavorite : () -> Unit
        ) {
            Row (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                    .background(Secondary)
                    .fillMaxWidth(1f)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickFavorite) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(painter = painterResource(id = R.drawable.ecg_heart),
                            contentDescription = "Favorite icon", tint = Color.White
                        )
                        Text(text = "Favorite", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickPost) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.LibraryAdd,
                            contentDescription = "Post icon", tint = Color.White
                        )
                        Text(text = "Post", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickDoctors) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(painter = painterResource(id = R.drawable.clinical_notes),
                            contentDescription = "Doctor icon", tint = Color.White
                        )
                        Text(text = "Doctors", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickGroups) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.Group,
                            contentDescription = "Group icon", tint = Color.White
                        )
                        Text(text = "Group", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickProfile) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.AccountCircle,
                            contentDescription = "Profile icon", tint = Color.White
                        )
                        Text(text = "Profile", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

            }
        }

        @Composable
        public fun DoctorDefault(
            onClickDoctors : () -> Unit,
            onClickGroups : () -> Unit,
            onClickProfile : () -> Unit
        ) {
            Row (
                modifier = Modifier
                    .background(Secondary)
                    .fillMaxWidth(1f)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickDoctors) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(painter = painterResource(id = R.drawable.clinical_notes),
                            contentDescription = "Doctor icon", tint = Color.White
                        )
                        Text(text = "Doctors", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickGroups) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.Group,
                            contentDescription = "Group icon", tint = Color.White
                        )
                        Text(text = "Group", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickProfile) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.AccountCircle,
                            contentDescription = "Profile icon", tint = Color.White
                        )
                        Text(text = "Profile", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

            }
        }

        @Composable
        public fun DoctorRounded(
            onClickDoctors : () -> Unit,
            onClickGroups : () -> Unit,
            onClickProfile : () -> Unit
        ) {
            Row (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                    .fillMaxWidth(1f)
                    .background(Secondary)
                    .padding(vertical = 5.dp, horizontal = 24.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickDoctors) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(painter = painterResource(id = R.drawable.clinical_notes),
                            contentDescription = "Doctor icon", tint = Color.White
                        )
                        Text(text = "Doctors", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickGroups) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.Group,
                            contentDescription = "Group icon", tint = Color.White
                        )
                        Text(text = "Group", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    onClick = onClickProfile) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(Icons.Default.AccountCircle,
                            contentDescription = "Profile icon", tint = Color.White
                        )
                        Text(text = "Profile", style = TextStyle(
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ) )
                    }
                }

            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    public fun ComponentPreview(){
        Column (
            Modifier.fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            UserDefault(
                onClickDoctors = {},
                onClickGroups = {},
                onClickProfile = {},
                onClickFavorite = {},
                onClickPost = {},
            )

            UserRounded(
                onClickDoctors = {},
                onClickGroups = {},
                onClickProfile = {},
                onClickFavorite = {},
                onClickPost = {},
            )

            DoctorDefault(
                onClickDoctors = {},
                onClickGroups = {},
                onClickProfile = {},
            )

            DoctorRounded(
                onClickDoctors = {},
                onClickGroups = {},
                onClickProfile = {},
            )

        }
    }
}