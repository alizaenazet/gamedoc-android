package com.example.gamedoc.model

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gamedoc.data.SettingsDataStore

class ViewRouteParams(
   val navController: NavController,
   val dataStore: SettingsDataStore,
   val setIsAuthenticated: (status: Boolean) -> Unit
)