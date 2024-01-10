package com.example.gamedoc.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

import java.io.IOException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private const val AUTH_PREFERENCE_NAME = "auth_preference"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = AUTH_PREFERENCE_NAME
)
class SettingsDataStore(
    context: Context
    ) {
    private val dataStore = context.dataStore
    companion object {
        private val AUTH_TOKEN = stringPreferencesKey("authToken")
        private val USER_ROLE = stringPreferencesKey("userRole")
    }

    suspend fun saveUserRoleToPreferencesStore(role: String){
        dataStore.edit { preferences ->
            preferences[USER_ROLE] = role
        }
    }
    suspend fun saveTokenToPreferencesStore(token:String){
        dataStore.edit { preferences ->
            preferences[AUTH_TOKEN] = token
        }
    }

    val getUserRole : Flow<String> = dataStore.data.map {preferences ->
        preferences[USER_ROLE] ?: "";
    }

    val getToken : Flow<String> = dataStore.data.map { preferences ->
        preferences[AUTH_TOKEN] ?: ""
    }


}