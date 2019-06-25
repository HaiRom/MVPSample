package com.example.myapplication.login

import android.os.Handler
import android.os.Looper

class LoginPresenter(private val loginView: LoginContract.View) : LoginContract.Presenter {

    //  private lateinit var loginView : LoginContract.View
    private var handler: Handler = Handler(Looper.getMainLooper())
    private lateinit var userModel: User

    override fun clear() {
        loginView.clearField()
    }

    override fun doLogin(userName: String, pass: String) {
        userModel = User(userName, pass)
        val validate = userModel.checkUserValidaty(userName, pass)
        if (!validate){
            loginView.showProgressLoading(false)
            loginView.showErroronEditText()
            return
        }

        val isResult = userModel.requestCheckLogin(userName, pass)
        handler.postDelayed({
            loginView.loginResult(isResult)
        }, 2000)

    }

    override fun setProgressLoading(visibility: Boolean) {
        loginView.showProgressLoading(visibility)
    }

}