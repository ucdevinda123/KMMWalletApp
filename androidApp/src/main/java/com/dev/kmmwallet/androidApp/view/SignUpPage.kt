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
import com.dev.kmmwallet.androidApp.viewmodel.SignUpViewModel
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

class SignUpPage : Fragment(), View.OnClickListener {

    private lateinit var viewModel: SignUpViewModel
    private lateinit var mobileNumberEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var signUpButton: Button
    private lateinit var toolBar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.signup_page, container, false)
        initialize(view)
        return view
    }

    private fun initialize(view: View) {
        signUpButton = view.findViewById(R.id.btn_signIn)
        mobileNumberEditText = view.findViewById(R.id.login_edit_email)
        passwordEditText = view.findViewById(R.id.login_edit_pass)
        firstName = view.findViewById(R.id.login_edit_first_name)
        lastName = view.findViewById(R.id.login_edit_last_name)
        signUpButton.setOnClickListener(this)
        viewModel = SignUpViewModel()

        toolBar = view.findViewById(R.id.toolbar_login) as Toolbar
        toolBar.setOnClickListener(this)
        toolBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24)
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

    private fun authenticateUserEv() {
        val mobileNumber = mobileNumberEditText.text.toString()
        val passWord = passwordEditText.text.toString()
        val firstNameText = firstName.text.toString()
        val lastNameText = lastName.text.toString()
        if (validate(mobileNumber) && validate(passWord) && validate(firstNameText) && validate(
                lastNameText
            )
        ) {
            signUpButton.text = getString(R.string.loading)
            viewModel.signUpUser(
                mobileNumber,
                passWord,
                firstNameText,
                lastNameText,
                fun(state: ScreenState) {
                    signUpButton.text = getString(R.string.btn_signup)
                    handleState(state)
                })
        } else {
            showToast(getString(R.string.empty_values_not_allowed))
        }
    }


    private fun handleState(loginScreenState: ScreenState) {
        when (loginScreenState.status) {
            Status.SUCCESS -> {
                navigateToLogin()
            }
            Status.LOADING -> {

            }
            Status.ERROR -> {
                showToast(loginScreenState.message)
            }

            else ->  showToast(loginScreenState.message)
        }
    }

    private fun showToast(message: String) {
        (activity as MainActivity).showToast(message)
    }

    private fun validate(text: String): Boolean {
        return !(TextUtils.isEmpty(text))
    }

    private fun navigateToLogin() {
        (activity as MainActivity).replaceFragment(LoginPage(), "")
    }
}