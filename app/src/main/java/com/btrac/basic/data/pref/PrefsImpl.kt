package com.btrac.basic.data.pref

import android.content.Context
import android.content.SharedPreferences

class PrefsImpl(context: Context) : Prefs {

  private var sessionPrefs: SharedPreferences = context.applicationContext.getSharedPreferences(
    SESSION_PREFS,
    Context.MODE_PRIVATE
  )

  // override fun saveUser(user: User) {
  //     val gson = Gson()
  //     val type = object : TypeToken<User>() {}.type
  //     sessionPrefs.edit().putString(PREFS_USER, gson.toJson(user, type)).apply()
  // }
  //
  // override fun getUser(): User? {
  //     val gson = Gson()
  //     val json = sessionPrefs.getString(PREFS_USER, null)
  //     return gson.fromJson(json, User::class.java)
  // }

  override fun clearSession() {
    sessionPrefs.edit().clear().apply()
  }

  companion object {
    const val SESSION_PREFS = "SESSION_PREFS"
    const val PREFS_USER = "USER"
  }
}