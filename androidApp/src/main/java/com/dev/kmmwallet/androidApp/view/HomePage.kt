package com.dev.kmmwallet.androidApp.view

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.dev.kmmwallet.androidApp.MainActivity
import com.dev.kmmwallet.androidApp.R
import com.dev.kmmwallet.androidApp.viewmodel.HomeViewModel
import com.dev.kmmwallet.shared.viewmodel.event.home.HomeScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

class HomePage : Fragment(), View.OnClickListener {

    lateinit var viewModel: HomeViewModel
    lateinit var profileButton: ImageView
    lateinit var logoutButton : ImageView
    lateinit var userName: TextView
    lateinit var greetingText: TextView
    lateinit var cardHolderName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.home_page, container, false)
        initView(view)
        return view
    }


    fun initView(view: View) {
        viewModel = HomeViewModel()
        profileButton = view.findViewById(R.id.editProfileButton)
        logoutButton = view.findViewById(R.id.logout)
        userName = view.findViewById(R.id.user_name)
        greetingText = view.findViewById(R.id.user_greet_message)
        cardHolderName = view.findViewById(R.id.card_holder_name)
        logoutButton.setOnClickListener(this)
        profileButton.setOnClickListener(this)
        setUiValues()
    }


    fun handleState(loginScreenState: HomeScreenState) {
        when (loginScreenState.status) {
            Status.SUCCESS -> {
                print("SSUSUSUSUS") // Navigation
            }
            Status.LOADING -> {

            }
            Status.ERROR -> {
                showMessage(loginScreenState.message)
            }

        }
    }


    private fun setUiValues(){
       greetingText.text =  viewModel.greetUser()
        userName.text = viewModel.getFirstName()
        cardHolderName.text = viewModel.getFirstName() + " " + viewModel.getLastName()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.editProfileButton -> {
                (activity as MainActivity).openEditProfilePage()
            }

            R.id.logout -> {
                performLogout()
            }
        }
    }

    private fun showMessage(message: String) {
        (activity as MainActivity).showToast(message)
    }

    private fun performLogout(){
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setMessage(getString(R.string.are_you_sure_you_wanna_logout))
            .setCancelable(false)
            .setPositiveButton(
                getString(R.string.yes),DialogInterface.OnClickListener { dialog, id ->
                    viewModel.clearToken()
                    (activity as MainActivity).addLandingPageFragment(LandingPage(),"Landing")
                 }
            )
            .setNegativeButton(getString(R.string.no), DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alert = builder.create()
        alert.show()
    }

}

