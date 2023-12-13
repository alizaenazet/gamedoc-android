package com.example.gamedoc.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


class SettingsDataStore(
    private val preferenceDataStore: DataStore<Preferences>
    ) {

    private val AUTH_TOKEN = stringPreferencesKey("authToken")

    suspend fun getTokenFromPreferencesStore(): String {
        val preference = preferenceDataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .first()
        return preference[AUTH_TOKEN] ?: ""
    }

    suspend fun saveTokenToPreferencesStore(token:String){
        preferenceDataStore.edit { preferences ->
            preferences[AUTH_TOKEN] = token
        }
    }
}