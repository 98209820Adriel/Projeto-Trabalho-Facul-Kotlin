package com.example.cheerupapp.Infra

import android.content.Context

class  SecurityPreferences( context:Context){

    private val msharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        msharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return   msharedPreferences.getString(key,"") ?: ""
    }

}