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

class HomePage : Fragment(), View.OnClickListener {

    private lateinit var viewModel: HomeViewModel
    private lateinit var profileButton: ImageView
    private lateinit var logoutButton: ImageView
    private lateinit var userName: TextView
    private lateinit var greetingText: TextView
    private lateinit var cardHolderName: TextView

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

    private fun initView(view: View) {
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

    private fun setUiValues() {
        viewModel.initHomePage(fun(homeState: HomeScreenState) {
            userName.text = homeState.name
            cardHolderName.text = homeState.fullName
            greetingText.text = homeState.greeting
        })
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

    private fun performLogout() {
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setMessage(getString(R.string.are_you_sure_you_wanna_logout))
            .setCancelable(false)
            .setPositiveButton(
                getString(R.string.yes), DialogInterface.OnClickListener { _, _ ->
                    viewModel.logoutUser(fun(_: HomeScreenState) {
                        (activity as MainActivity).addLandingPageFragment(LandingPage())
                    })
                }
            )
            .setNegativeButton(
                getString(R.string.no),
                DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() })
        val alert = builder.create()
        alert.show()
    }
}