package com.example.datastoredependencyinjection.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("texts")

class DataStoreManager(private val context: Context) {

    companion object {
        private val TEXT_KEY = stringPreferencesKey("text_key")
    }

    suspend fun saveText(text: String) {
        context.dataStore.edit { preferences ->
            preferences[TEXT_KEY] = text
        }
    }

    fun getText(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[TEXT_KEY] ?: ""
        }
    }
}

//val Context.dataStore by preferencesDataStore("texts")
//
//object DataStoreRepository {
//
//    private val TEXT_KEY = stringPreferencesKey("text_key")
//
//    suspend fun saveTexts(context: Context, texts: String) {
//        context.dataStore.edit { preferences ->
//            preferences[TEXT_KEY] = texts
//        }
//    }
//    fun getTexts(context: Context) : Flow<String> {
//        return context.dataStore.data.map { preferences ->
//            preferences[TEXT_KEY] ?: ""
//
//        }
//    }
//}