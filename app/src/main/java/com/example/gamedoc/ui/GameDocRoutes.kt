package com.example.gamedoc.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamedoc.data.SettingsDataStore
import com.example.gamedoc.ui.theme.screen.login.LoginScreen
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


enum class ListScreens(){
    Login,
    DoctorGroupChat,
    DoctorDetailGroup,
    DoctorGroupSetting,
    DoctorGroupCreate,
    DoctorUserSetting,

    GamerGroupChat,

}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun GameDocApp(){
    val navController = rememberNavController()
    val dataStore = SettingsDataStore(LocalContext.current)
    var startDestination = ListScreens.Login

//    Penyesuaian Screen awal saat login
    GlobalScope.launch {
        if (dataStore.getToken.first().isNotEmpty()){
            startDestination = if (dataStore.getUserRole.first() == "Doctor"){
                ListScreens.DoctorGroupChat
            }else {
                ListScreens.GamerGroupChat
            }
        }
    }


    Scaffold {
     innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination.name,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ){
//            List Screen yang akan digunakan pada route
            composable(ListScreens.Login.name){
                LoginScreen(modifier = Modifier.fillMaxSize())
            }
            
            composable(ListScreens.DoctorGroupChat.name){
                Logined("Doctor", navController)
            }
            
            composable(ListScreens.GamerGroupChat.name){
                Logined(userRole = "Gamer", navController)
            }
        }
    }
}


// Contoh kondisi halaman pertama saat kondisi telah login
@Composable
fun Logined(userRole: String, navController: NavController){
    var screenToGo = ListScreens.Login.name
    var toOtherScreen = "Doctor"
    if (userRole == "Doctor"){
        toOtherScreen = "Gamer"
        screenToGo = ListScreens.GamerGroupChat.name
    }else{
        screenToGo = ListScreens.DoctorGroupChat.name
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        Text(text = "Already login as $userRole")
        Button(onClick = {
            navController.navigate(screenToGo)
        }) {
            Text(text = "Move to $toOtherScreen Screen" )
        }
    }
}