package com.example.myapplication.login

import android.text.TextUtils

data class User(val username: String, val pass: String) {

    fun checkUserValidaty(username: String, pass: String): Boolean {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pass)) {
            return false
        }
        return true
    }

    fun requestCheckLogin(username: String, pass: String): Boolean {
        return TextUtils.equals(username, "mvp") && TextUtils.equals(pass, "mvp")
    }

}