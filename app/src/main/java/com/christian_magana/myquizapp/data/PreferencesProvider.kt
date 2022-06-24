package com.christian_magana.myquizapp.provider

import android.content.Context
import android.content.SharedPreferences

enum class PreferencesKey(val value: String){
    PREFERENCES_APP("preferencesApp"),
    RANKING_QUIZ("rankig_quiz")
}

object PreferencesProvider {

    fun string(context: Context, key: PreferencesKey): String? {
        return prefs(context).getString(key.value, null)
    }

    fun set(context: Context, key: PreferencesKey, value: String) {
        val editor = prefs(context).edit()
        editor.putString(key.value, value).apply()
    }

    private fun prefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PreferencesKey.PREFERENCES_APP.value, Context.MODE_PRIVATE)
    }
}