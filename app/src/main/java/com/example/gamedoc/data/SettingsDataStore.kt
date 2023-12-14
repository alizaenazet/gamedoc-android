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

    val getUserRole : Flow<String> = dataStore.data.map {
        it[USER_ROLE] ?: "Doctor";
    }

    val getToken : Flow<String> = dataStore.data.map { preferences ->
        preferences[AUTH_TOKEN] ?: "eyJhbGciOiJSUzI1NiIsImtpZCI6Imluc18yVWhqbzVOckVZc2J2MWFSUFpNcXBsSzNJWkciLCJ0eXAiOiJKV1QifQ.eyJhenAiOiJodHRwOi8vbG9jYWxob3N0OjMwMDAiLCJleHAiOjE2OTU3OTE2MjQsImlhdCI6MTY5NTc5MTU2NCwiaXNzIjoiaHR0cHM6Ly9saXZpbmctaGVuLTc1LmNsZXJrLmFjY291bnRzLmRldiIsIm5iZiI6MTY5NTc5MTU1NCwic2lkIjoic2Vzc18yVnNVV1l5d2FzdlFzZjdickJPWU1mWlc0NjgiLCJzdWIiOiJ1c2VyXzJVaG1ZRFJXUVhNWjVlMDhFdFZ5OERubW1XQyJ9.C3na353_wFWlCEQBfky9d4U5dMeZLLCjDoiuHJL3LPqGzNBKrMhmJB18wnyhoPPVHKdrFHzzg1A0x2N2RI19vVu3QavRmDm-AsbdtRe5RpwmWf7Ibzregb1YxzIx9CAA8ogLbByBsNB93UoLGlND1nWKdrXKcsK5slVc-nkBbEhmV_nplXNG0arUNimXQpy5etFV34eJZuKOCKioK_zyckxtNUSP16ihSavMHPu1yZYDzADWuTGfCTBhmIyOl2w0U4V6L5qgnQo83XETxWeehmqRCSC9O7bMvGhkJ1_4Q0gdlGSluSs4DKylqwJOJy1IW0j-0ainTH-QCDqOLL4p1g"
    }


}