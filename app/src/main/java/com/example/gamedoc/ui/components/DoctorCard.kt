package com.example.gamedoc.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.sp
import com.example.gamedoc.R
import com.example.gamedoc.ui.theme.Secondary
import com.example.gamedoc.ui.theme.Success

class DoctorCard {
    companion object {

        @RequiresApi(Build.VERSION_CODES.Q)
        @Composable
        fun Default(
            id: String,
            doctorName: String,
            bidang: String,
            services: Array<String>,
            imageUrl: String,
            onCardClick: (String) -> Unit,
            colors : List<Color> = listOf(Secondary, Success)
        ){
            Column (
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .background(Brush.horizontalGradient(colors))
                    .padding(11.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(9.dp)

            ){
                Row (
                    horizontalArrangement = Arrangement.spacedBy(9.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    AsyncImage(model = imageUrl,
                        contentDescription = "$doctorName Card image",
                        modifier = Modifier
                            .size(127.dp, 127.dp)
                            .clip(shape = RoundedCornerShape(14.dp)),
                    )
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(-3.dp)
                    ) {
                        Text(text = doctorName,
                            fontSize = 16.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            modifier = Modifier.padding(bottom = 4.dp)
                            )
                        Text(text = "Bidang $bidang",
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = Color.White
                            )
                        Text(text = "Layanan :",
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = Color.White
                        )
                        services.map {serviceName ->
                            Text(text = "- $serviceName",
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color.White
                            )
                        }
                    }
                }

                Button(onClick = { onCardClick(id) },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(50))
                    ) {
                    Text(text = "Kunjungi",
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_light)),
                        color = Secondary,
                        
                    )
                }
            }
        }
    }


}

class MockDoctor(
    val id:String = "00123",
    val doctorName:String = "Dr. Olivia Davidson ",
    val bidang:String = "kesehatan mental",
    val services:Array<String> = arrayOf("Personal","Group"),
    val imageUrl:String = "https://source.unsplash.com/800x800/?Face",
)

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showBackground = true, showSystemUi = true)
@Composable
public fun ComponentDoctorCardPreview() {
    val mockDoctor = MockDoctor()
    fun testCardClick (id:String){

    }
    Column(
    ) {
        DoctorCard.Default(
            id = mockDoctor.id,
            doctorName = mockDoctor.doctorName,
            bidang = mockDoctor.bidang,
            services = mockDoctor.services,
            imageUrl = mockDoctor.imageUrl,
            onCardClick = { testCardClick(id = it) }
        )
    }

}