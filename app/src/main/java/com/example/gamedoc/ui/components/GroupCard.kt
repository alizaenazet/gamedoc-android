package com.example.gamedoc.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamedoc.ui.theme.Primary
import com.example.gamedoc.ui.theme.Secondary
import coil.compose.AsyncImage
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Accent
import com.example.gamedoc.ui.theme.Success

@Suppress("UNUSED_EXPRESSION")
class GroupCard {

    companion object {

        @Composable
        public fun Default(
            imageUrl : String,
            groupName: String,
            groupDesc: String,
            onCardClick: () -> Unit,
            colors : List<Color> = listOf(Secondary, Success)
        ){

            Row (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.White)
                    .fillMaxWidth(1f)
                    .padding(horizontal = 10.dp, vertical = 6.dp)
                    .clickable { onCardClick },
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                AsyncImage(model = imageUrl,
                    contentDescription = "Card image",
                    modifier = Modifier
                        .size(48.dp, 48.dp)
                        .clip(shape = RoundedCornerShape(100))
                )
                Column (verticalArrangement = Arrangement.spacedBy((-6).dp)) {
                    Text(text = groupName,style = TextStyle(
                        fontSize = 20.sp,
                        color = Secondary,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))),
                        modifier = Modifier.padding(bottom = 0.dp)
                    )
                    Text(text = groupDesc,style = TextStyle(
                        fontSize = 16.sp,
                        color = Secondary,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_light))
                    ) )

                }
            }
        }

        @Composable
        public fun DoctorGroup(
            imageUrl : String,
            groupName: String,
            groupDesc: String,
            onCardClick: () -> Unit,
            onEditClick: () -> Unit,
            onDeleteClick: () -> Unit,
            colors : List<Color> = listOf(Secondary, Success)
        ){

            Row (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.White)
                    .fillMaxWidth(1f)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
                    .clickable { onCardClick },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    AsyncImage(model = imageUrl,
                        contentDescription = "Card image",
                        modifier = Modifier
                            .size(48.dp, 48.dp)
                            .clip(shape = RoundedCornerShape(100))
                    )
                    Column (verticalArrangement = Arrangement.spacedBy((-6).dp)) {
                        Text(text = groupName,style = TextStyle(
                            fontSize = 20.sp,
                            color = Secondary,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))),
                            modifier = Modifier.padding(bottom = 0.dp)
                        )
                        Text(text = groupDesc,style = TextStyle(
                            fontSize = 16.sp,
                            color = Secondary,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_light))
                        ) )

                    }
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Default.Edit, contentDescription = "edit icon", tint = Secondary,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { onEditClick }
                    )
                    Icon(Icons.Default.Delete, contentDescription = "edit icon", tint = Secondary,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { onDeleteClick }
                    )
                }

            }
        }

        @Composable
        public fun GamerGroup(
            imageUrl : String,
            groupName: String,
            groupDesc: String,
            onCardClick: () -> Unit,
            onButtonClick: () -> Unit,
            colors : List<Color> = listOf(Secondary, Success)
        ){

            Row (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(2.dp, brush = Brush.horizontalGradient(colors)),
                        RoundedCornerShape(16.dp)
                    )
                    .background(Color.White)
                    .fillMaxWidth(1f)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
                    .clickable { onCardClick },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    AsyncImage(model = imageUrl,
                        contentDescription = "Card image",
                        modifier = Modifier
                            .size(48.dp, 48.dp)
                            .clip(shape = RoundedCornerShape(100))
                    )
                    Column (verticalArrangement = Arrangement.spacedBy((-6).dp)) {
                        Text(text = groupName,style = TextStyle(
                            fontSize = 20.sp,
                            color = Secondary,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))),
                        )
                        Text(text = groupDesc,style = TextStyle(
                            fontSize = 16.sp,
                            color = Secondary,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_light))
                        ) )

                    }
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(onClick = { onButtonClick },
                        modifier = Modifier
                            .width(100.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Brush.horizontalGradient(colors)),
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                        Text(text = "Join", fontSize = 14.sp, style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
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

//        "https://source.unsplash.com/800x800/?Group"
        Column(
            Modifier.fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Default(
                imageUrl = "https://source.unsplash.com/800x800/?Group",
                groupName = "Nama Group",
                groupDesc = "desc of group",
                onCardClick = {}
            )

            DoctorGroup(
                imageUrl = "https://source.unsplash.com/800x800/?Group",
                groupName = "Nama Group",
                groupDesc = "desc of group",
                onEditClick = {},
                onDeleteClick = {},
                onCardClick = {}
            )

            GamerGroup(
                imageUrl = "https://source.unsplash.com/800x800/?Group",
                groupName = "Nama Group",
                groupDesc = "desc of group",
                onButtonClick = {},
                onCardClick = {}
            )
        }
    }
}