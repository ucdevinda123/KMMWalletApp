package com.dev.kmmwallet.androidApp.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.kmmwallet.androidApp.MainActivity

import com.dev.kmmwallet.androidApp.R


class LandingPage : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view =  inflater.inflate(R.layout.landing_page, container, false)
        var signInButton = view.findViewById<View>(R.id.landing_btn_login)
        var signUpButton = view.findViewById<View>(R.id.landing_btn_signup)
        signInButton.setOnClickListener(this)
        signUpButton.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.landing_btn_login -> {
                navigateToLogin()
            }

            R.id.landing_btn_signup -> {
                navigateToSignUp()
            }
        }
    }

    private fun navigateToSignUp() {
      (activity as MainActivity).replaceFragment(SignUpPage(),"")
    }

    private fun navigateToLogin() {
        (activity as MainActivity).replaceFragment(LoginPage(),"")
    }
}