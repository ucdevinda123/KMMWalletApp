package com.dev.kmmwallet.androidApp.view

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.dev.kmmwallet.androidApp.MainActivity
import com.dev.kmmwallet.androidApp.R
import com.dev.kmmwallet.androidApp.viewmodel.UserProfileViewModel
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.UserProfileScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class EditProfilePage : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var viewModel: UserProfileViewModel
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var updateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.edit_profile_page, container, false)
        initView(view)
        return view
    }


    private fun initView(view: View) {
        viewModel = UserProfileViewModel()
        firstName = view.findViewById(R.id.profile_edit_first_name)
        lastName = view.findViewById(R.id.profile_edit_last_name)
        updateButton = view.findViewById(R.id.btn_edit_profile)
        updateButton.setOnClickListener(this)
        initProfileValues()
    }

    private fun initProfileValues() {
        viewModel.initProfile (fun(profileState: UserProfileScreenState){
            firstName.text  = Editable.Factory.getInstance().newEditable(profileState.name)
            lastName.text = Editable.Factory.getInstance().newEditable(profileState.lastName)
        })
    }


    private fun handleUserProfileState(userProfileScreenState: UserProfileScreenState) {
        when (userProfileScreenState.status) {
            Status.SUCCESS -> {
                showMessage(userProfileScreenState.message)
            }
            Status.LOADING -> {

            }
            Status.ERROR -> {
                showMessage(userProfileScreenState.message)
            }

            else -> showMessage(userProfileScreenState.message)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_edit_profile -> {
                val firstName = firstName.text.toString()
                val lastName = lastName.text.toString()
                if (validate(firstName) && validate(lastName)) {
                    updateButton.text = getString(R.string.loading)
                    viewModel.updateUserProfile(firstName, lastName, fun(profileState) {
                        updateButton.text = getString(R.string.btn_update)
                        handleUserProfileState(profileState)
                    })
                } else {
                    showMessage(getString(R.string.empty_values_not_allowed))
                }
            }
        }
    }

    private fun showMessage(message: String) {
        (activity as MainActivity).showToast(message)
    }

    private fun validate(text: String): Boolean {
        return !(TextUtils.isEmpty(text))
    }
}