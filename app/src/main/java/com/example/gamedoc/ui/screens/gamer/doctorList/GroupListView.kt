package com.example.gamedoc.ui.screens.gamer.doctorList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gamedoc.model.ViewRouteParams
import com.example.gamedoc.model.doctor.DoctorList
import com.example.gamedoc.model.group.GroupList
import com.example.gamedoc.model.group.GroupListItem
import com.example.gamedoc.ui.ListScreens
import com.example.gamedoc.ui.components.BottomNavBar
import com.example.gamedoc.ui.components.ErrorScreen
import com.example.gamedoc.ui.components.GroupCard
import com.example.gamedoc.ui.components.LoadingScreen
import com.example.gamedoc.ui.components.Navbar

@Composable
fun GamerGroupListView(
    viewRouteParams: ViewRouteParams,

    // override view model for can put a constructor
    gamerGroupListViewModel : GamerGroupListViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GamerGroupListViewModel(
                    viewRouteParams = viewRouteParams,
                ) as T
            }
        }
    )
){
    
    val groupListUiState: GamerGroupListUiState = gamerGroupListViewModel._gamerGroupListUiState
    
    when(groupListUiState) {
        is GamerGroupListUiState.Loading -> {
            LoadingScreen()
        }
        
        is GamerGroupListUiState.Error -> {
            ErrorScreen(retryAction = { /*TODO*/ }, message = groupListUiState.error)
        }

        is GamerGroupListUiState.Success -> {
            GamerGroupList(
                groupList = groupListUiState.groupList,
                onSearchGroup = { gamerGroupListViewModel.serachGroup(it) },
                viewRouteParams.navController
            )
        }
    }
    
    

}

@Composable
fun GamerGroupList(
    groupList: GroupList? ,
    onSearchGroup: (String) -> Unit,
    navController: NavController
    ){

    Scaffold(
        bottomBar = { BottomNavBar.GamerDefault(navController = navController) },
        topBar = {
            Navbar.Variant5(
            onClickBackButton = { /*TODO*/ },
            onSearch = onSearchGroup,
            {}
        )
        }
    ) {

        LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(it),
            ){

            if (groupList == null){
                item {
                    Text(text = "Group list is empty")
                }
            }else {
                item {
                    GroupCardList(groupList,navController)
                }
            }

        }


    }

}

@Composable
fun GroupCardList(
    groupList: GroupList,
    navController: NavController
){
    groupList.map { group ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .clickable { navController.navigate(ListScreens.GamerGroupDetail.name +"/"+ group.id) }
        ) {
            GroupCard.Default(
                imageUrl = group.image_url,
                groupName = group.name,
                groupDesc = group.description,
                onCardClick = { navController.navigate(ListScreens.GamerGroupDetail.name +"/"+ group.id) })
        }
    }
}