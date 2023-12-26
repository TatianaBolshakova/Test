package com.example.mytestwork.data.shared

import android.content.SharedPreferences
import com.example.mytestwork.data.constant.Constants

object Shared {
    var pref: SharedPreferences? = null
    var sitePref: SharedPreferences? = null
    fun saveStartTime(startTime: String) {
        val editor = pref?.edit()
        editor?.putString(Constants.KEY_START_TIME, startTime)
        editor?.apply()
    }

    fun saveExpirationTime(expirationTime: String) {
        val editor = pref?.edit()
        editor?.putString(Constants.KEY_EXPIRATION_TIME, expirationTime)
        editor?.apply()
    }

    fun saveStartDate(startDate: String) {
        val editor = pref?.edit()
        editor?.putString(Constants.KEY_START_DATE, startDate)
        editor?.apply()
    }

    fun saveExpirationDate(expirationDate: String) {
        val editor = pref?.edit()
        editor?.putString(Constants.KEY_EXPIRATION_DATE, expirationDate)
        editor?.apply()
    }

    fun saveSite(site: String) {
        val editor = sitePref?.edit()
        editor?.putString(Constants.KEY_SITE, site)
        editor?.apply()
    }

}