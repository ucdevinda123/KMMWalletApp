package com.dev.kmmwallet.androidApp.view

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.dev.kmmwallet.androidApp.MainActivity
import com.dev.kmmwallet.androidApp.R
import com.dev.kmmwallet.androidApp.viewmodel.LoginViewModel
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status


class LoginPage : Fragment(), View.OnClickListener {

    lateinit var viewModel: LoginViewModel
    lateinit var mobileNumberEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button
    lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.login_page, container, false)
        initialize(view)
        return view
    }

    private fun initialize(view: View) {
        loginButton = view.findViewById(R.id.btn_signIn)
        mobileNumberEditText = view.findViewById(R.id.login_edit_email)
        passwordEditText = view.findViewById(R.id.login_edit_pass)
        loginButton.setOnClickListener(this)
        viewModel = LoginViewModel()

        toolBar = view.findViewById(R.id.toolbar_login) as Toolbar
        toolBar.setOnClickListener(this)
        toolBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24)
    }

    private fun authenticateUserEv() {
        val mobileNumber = mobileNumberEditText.text.toString()
        val passWord = passwordEditText.text.toString()
        if (validate(mobileNumber) && validate(passWord)) {
            loginButton.text = getString(R.string.loading)
            viewModel.authenticateUser(mobileNumber, passWord, fun(state: ScreenState) {
                handleState(state)
            })
        } else {
            showToast(getString(R.string.empty_values_not_allowed))
        }

    }

    private fun handleState(loginScreenState: ScreenState) {
        loginButton.text = getString(R.string.btn_login)
        when (loginScreenState.status) {
            Status.SUCCESS -> {
                navigateToHome()
            }
            Status.LOADING -> {

            }
            Status.ERROR -> {
                showToast(loginScreenState.message)
            }

            else -> showToast(loginScreenState.message)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_signIn -> {
                authenticateUserEv()
            }

            R.id.toolbar_login -> {
                goBack()
            }
        }
    }

    private fun goBack() {
        fragmentManager?.popBackStackImmediate()
    }

    private fun showToast(message: String) {
        (activity as MainActivity).showToast(message)
    }

    private fun validate(text: String): Boolean {
        return !(TextUtils.isEmpty(text))
    }

    private fun navigateToHome() {
        (activity as MainActivity).replaceFragment(HomePage(), "")
    }
}