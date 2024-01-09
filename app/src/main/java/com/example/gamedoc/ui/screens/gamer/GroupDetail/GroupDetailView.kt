package com.example.gamedoc.ui.screens.gamer.GroupDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.gamedoc.BuildConfig
import com.example.gamedoc.R
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.model.group.DetailGroup
import com.example.gamedoc.model.group.DoctorDetailGroup
import com.example.gamedoc.model.group.SocialMedia
import com.example.gamedoc.ui.components.BottomNavBar
import com.example.gamedoc.ui.components.Button
import com.example.gamedoc.ui.components.ErrorScreen
import com.example.gamedoc.ui.components.LoadingScreen

@Composable
fun GroupDetailView(
    viewRouteParams: ViewRouteParams,
    groupid: String,

    // override view model for can put a constructor
    groupDetailViewModel: GroupDetailViewModel = viewModel(
        factory = object: ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GroupDetailViewModel(
                    viewRouteParams = viewRouteParams,
                    groupid,
                ) as T
            }
        }
    )
){

    val groupDetailUiState: GroupDetaiUiState = groupDetailViewModel._groupDetailUiState

    when(groupDetailUiState){
        is GroupDetaiUiState.Loading -> {
            LoadingScreen()
        }

        is GroupDetaiUiState.Error -> {
            ErrorScreen(retryAction = { /*TODO*/ }, message = groupDetailUiState.error)
        }

        is GroupDetaiUiState.Success -> {
            GroupDetail(
                groupDetailUiState.groupDetail!!,
                viewRouteParams
            )
        }

    }
}

@Composable
fun GroupDetail(
    groupDetailData: DetailGroup,
    viewRouteParams: ViewRouteParams
){

    val baseUrl = BuildConfig.BASE_URL
    Scaffold(
        bottomBar = { BottomNavBar.GamerDefault(navController = viewRouteParams.navController) }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            item {
                Row(
                    modifier = Modifier
                        .padding(start = 9.dp, end = 9.dp, top = 15.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (groupDetailData.image_url.contains(baseUrl)) {
                        AsyncImage(
                            model = baseUrl + groupDetailData.image_url,
                            contentDescription = groupDetailData.name + "image",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(shape = RoundedCornerShape(10))
                                .padding(end = 6.dp)
                        )
                    }else {
                        AsyncImage(
                            model = groupDetailData.image_url,
                            contentDescription = groupDetailData.name + "image",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(shape = RoundedCornerShape(10))
                                .padding(end = 6.dp)
                        )
                    }
                    Text(
                        overflow = TextOverflow.Ellipsis,
                        text = groupDetailData.name,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        ))
                }
            }

            item {
                Text(
                    overflow = TextOverflow.Ellipsis,
                    text = groupDetailData.description,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    ),
                    modifier = Modifier
                        .padding(horizontal = 19.dp)
                        .fillMaxWidth()
                )
            }

            item {
                Text(
                    overflow = TextOverflow.Ellipsis,
                    text = "Dokter",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    ),
                    modifier = Modifier
                        .padding(horizontal = 19.dp)
                        .fillMaxWidth()
                )
                LazyRow(){
                    groupDetailData.doctors.map { doctor ->
                        item {
                            DoctorCard(doctor)
                        }

                    }
                }
            }

            item {
                Row (
                    modifier = Modifier
                        .padding(horizontal = 19.dp)
                        .fillMaxWidth(),
                ){
                    Text(
                        overflow = TextOverflow.Ellipsis,
                        text = "Harga: ",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        ),
                        modifier = Modifier
                            .padding(horizontal = 19.dp)
                    )
                    Text(
                        overflow = TextOverflow.Ellipsis,
                        text = "Rp.${groupDetailData.price}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        ),
                        modifier = Modifier
                            .padding(horizontal = 19.dp)
                    )
                }
            }

                if(!groupDetailData.isOwned) (
                        item {

                            Column(
                                modifier = Modifier
                                    .width(180.dp)
                                    .padding(horizontal = 19.dp),
                            ) {
                                Button.DefaultFilled(
                                    buttonName = "Bergabung",
                                    onButtonClick = { /*TODO*/ })
                            }
                        }
                )else {

                    groupDetailData.social_media.map {socialMedia ->
                        item {
                            SocialMediaJoin(socialMedia)
                        }
                    }

                }

        }
    }
}

@Composable
fun SocialMediaJoin(
    socialMedia: SocialMedia
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    overflow = TextOverflow.Ellipsis,
                    text = socialMedia.name,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    ),
                    modifier = Modifier
                        .padding(horizontal = 19.dp)
                )
            }

            Column(
                modifier = Modifier
                    .width(180.dp)
                    .padding(horizontal = 19.dp),
            ) {
                Button.DefaultFilled(
                    buttonName = "Bergabung",
                    onButtonClick = { /*TODO*/ })
            }


        }


    }
}

@Composable
fun DoctorCard(
    doctor: DoctorDetailGroup
){
    val baseUrl = BuildConfig.BASE_URL
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.width(145.dp)
    ) {
        if (doctor.image_url.contains(baseUrl)) {

            AsyncImage(
                model = BuildConfig.BASE_URL + doctor.image_url,
                contentDescription = "Doctor image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = RoundedCornerShape(25))
                    .padding(end = 6.dp)
            )
        }else {
            AsyncImage(
                model = doctor.image_url,
                contentDescription = "Doctor image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = RoundedCornerShape(10))
                    .padding(end = 6.dp)
            )
        }
        Text(
            overflow = TextOverflow.Ellipsis,
            text = doctor.name,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
            ),
            modifier = Modifier
                .padding(horizontal = 19.dp)
                .fillMaxWidth()
        )
        Text(
            overflow = TextOverflow.Ellipsis,
            text = doctor.profession,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
            ),
            modifier = Modifier
                .padding(horizontal = 19.dp)
                .fillMaxWidth()
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GroupDetailPreview(){
//    GroupDetail(
//
//    )
//}