package com.example.remotedesk.network

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "server_config")

class ServerConfigStore(private val context: Context) {
    companion object {
        private val SERVER_IP = stringPreferencesKey("server_ip")
        private val IS_PAIRED = booleanPreferencesKey("is_paired")
    }

    suspend fun saveServerIp(ip: String) {
        context.dataStore.edit { prefs -> prefs[SERVER_IP] = ip }
    }

    val serverIpFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[SERVER_IP] ?: ""   // ✅ always non-null
    }

    val isPairedFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[IS_PAIRED] ?: false
    }

    suspend fun setPaired(value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_PAIRED] = value
        }
    }
}
