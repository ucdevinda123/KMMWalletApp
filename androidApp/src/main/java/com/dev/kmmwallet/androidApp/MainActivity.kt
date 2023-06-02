package com.dev.kmmwallet.androidApp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dev.kmmwallet.androidApp.view.EditProfilePage
import com.dev.kmmwallet.androidApp.view.LandingPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addLandingPageFragment(LandingPage())
        }
    }

    fun addLandingPageFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_view, fragment).commit()
    }


    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_view, fragment, tag).addToBackStack(null).commit()
    }

    fun openEditProfilePage() {
        EditProfilePage().show(
            supportFragmentManager,
            getString(R.string.tag_profile_fragment)
        )
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
}