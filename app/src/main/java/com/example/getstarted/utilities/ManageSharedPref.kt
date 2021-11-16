package com.example.getstarted.utilities

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

fun Context.putStringInLoginPref(key: String, value: String) {
    val sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, value)
    editor.apply()
}
fun Context.putStringInLoginPrefFcm(key: String, value: String) {
    val sharedPreferences = getSharedPreferences("fcm", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, value)
    editor.apply()
}

fun Context.getStringFromLoginPrefFcm(context: Context, key: String): String {
    val sharedPreferences =
        context.getSharedPreferences("fcm", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getString(key, "null")

    return mtoken!!
}
fun Context.putStringInLoginPrefLanguage(key: String, value: String) {
    val sharedPreferences = getSharedPreferences("language", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, value)
    editor.apply()
}

fun Context.getStringFromLoginPrefLanguage(context: Context, key: String): String {
    val sharedPreferences =
        context.getSharedPreferences("language", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getString(key, "null")

    return mtoken!!
}

fun Context.putIntInLoginPref(key: String, value: Int) {
    val sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putInt(key, value)
    editor.apply()
}

fun Context.putBoolInLoginPref(key: String, value: Boolean) {
    val sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, value)
    editor.apply()
}

fun Context.sharedPrefHasValue(context: Context, value: String): Boolean {
    val sharedPreferences =
        context.getSharedPreferences("login", Context.MODE_PRIVATE)
    return sharedPreferences.contains(value)
}

fun Context.getStringFromLoginPref(context: Context, key: String): String {
    val sharedPreferences =
        context.getSharedPreferences("login", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getString(key, "null")

    return mtoken!!
}

fun Context.getIntFromLoginPref(context: Context, key: String): Int {
    val sharedPreferences =
        context.getSharedPreferences("login", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getInt(key, 0)

    return mtoken
}

fun Context.getBoolFromLoginPref(context: Context, key: String): Boolean {
    val sharedPreferences =
        context.getSharedPreferences("login", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getBoolean(key, false)

    return mtoken
}

fun Context.clearLoginPref(context: Context) {
    val sharedPreferences =
        context.getSharedPreferences("login", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor?.clear()
    editor.apply()
}

fun Context.getIntFromContactsPref(context: Context, key: String): Int {
    val sharedPreferences =
        context.getSharedPreferences("contacts", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getInt(key, 0)

    return mtoken
}


fun Context.putIntInContactsPref(key: String, value: Int) {
    val sharedPreferences = getSharedPreferences("contacts", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putInt(key, value)
    editor.apply()
}

fun Context.putBoolInContactsPref(key: String, value: Boolean) {
    val sharedPreferences = getSharedPreferences("contacts", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, value)
    editor.apply()
}

fun Context.getBoolInContactsPref(context: Context, key: String): Boolean {
    val sharedPreferences =
        context.getSharedPreferences("contacts", Context.MODE_PRIVATE)
    val mtoken = sharedPreferences!!.getBoolean(key, false)
    return mtoken
}

fun Context.putActivityApiData(key: String, data: JSONObject) {
    val sharedPreferences = getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, data.toString())
    editor.apply()
}

fun Context.putActivityApiData(key: String, data: JSONArray) {
    val sharedPreferences = getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, data.toString())
    editor.apply()
}

fun Context.getActivityJSONArrayData(context: Context, key: String): JSONArray? {
    val sharedPreferences =
        context.getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val jsonObj = sharedPreferences!!.getString(key, "null")
    var obj: JSONArray? = null
    try {
        obj = JSONArray(jsonObj)
        Log.d("JSONData: ", obj.toString())
    } catch (t: Throwable) {
        Log.e("JSONData: ", "Could not parse malformed JSON: \"" + jsonObj.toString() + "\"")
    }

    if(obj == null)
        return null
    else
        return obj!!
}


fun Context.getActivityJSONData(context: Context, key: String): JSONObject {
    val sharedPreferences =
        context.getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val jsonObj = sharedPreferences!!.getString(key, "null")
    var obj: JSONObject? = null
    try {
        obj = JSONObject(jsonObj)
        Log.d("JSONData: ", obj.toString())
    } catch (t: Throwable) {
        Log.e("JSONData: ", "Could not parse malformed JSON: \"" + jsonObj.toString() + "\"")
    }

    return obj!!
}

fun Context.putBoolInApiDatasPref(key: String, value: Boolean) {
    val sharedPreferences = getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, value)
    editor.apply()
}

fun Context.getBoolInApiDataPref(context: Context, key: String): Boolean {
    val sharedPreferences =
        context.getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val apiData = sharedPreferences!!.getBoolean(key, false)
    return apiData
}

fun clearApiData(context: Context) {

    val sharedPreferences =
        context.getSharedPreferences("appCache", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor?.clear()
    editor.apply()
}
