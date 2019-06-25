package com.example.myapplication.login


/**
 * This specifies the contract between the view and the presenter.
 */
interface LoginContract {
    interface View {
        fun showProgressLoading(visibility: Boolean)
        fun clearField()
        fun loginResult(result: Boolean)
        fun showErroronEditText()
    }
    interface Presenter {
        fun clear()
        fun doLogin(userName: String, pass: String)
        fun setProgressLoading(visibility: Boolean)
    }
}