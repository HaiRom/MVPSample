package com.example.myapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var loginPresenter: LoginPresenter

    override fun showProgressLoading(visibility: Boolean) {
        Log.d("TAG:LoginActivity", "LoginContract.View showProgressLoading")
        progressCircular.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    override fun clearField() {
        Log.d("TAG:LoginActivity", "LoginContract.View clearField")
    }

    override fun loginResult(result: Boolean) {
        Log.d("TAG:LoginActivity", "LoginContract.View loginResult")
        if (result) {
            intent2Activity(this, MainActivity::class.java)
        } else {
            Snackbar.make(activityLogin, "Login failure", Snackbar.LENGTH_LONG).show()
        }
        showProgressLoading(false)
    }

    override fun showErroronEditText() {
        editTextUserName.error = "not null"
        editTextPassWord.error = "not null"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this)

        btnLogin.setOnClickListener {
            loginPresenter.setProgressLoading(true)
            loginPresenter.doLogin(editTextUserName.text.trim().toString(), editTextPassWord.text.trim().toString())
        }
    }

    private fun intent2Activity(activity: AppCompatActivity, toClass: Class<*>) {
        val intent = Intent(activity, toClass)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        activity.startActivity(intent)
        this.finish()
    }

}
