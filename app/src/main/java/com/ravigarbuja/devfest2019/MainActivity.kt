package com.ravigarbuja.devfest2019

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_email.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                checkEmailField(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                btn_login.isEnabled =
                    checkEmailField(s.toString()) && checkPasswordField(et_password.text.toString())
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }
        })

        et_password.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkPasswordField(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                btn_login.isEnabled =
                    checkEmailField(et_email.text.toString()) && checkPasswordField(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }

    //a placeholder function to validate email field
    private fun checkEmailField(emailString: String): Boolean {
        if (Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
            et_email.error = null
            return true
        } else {
            et_email.error = getString(R.string.invalid_email)
            return false
        }
    }

    //a placeholder function to validate password field
    private fun checkPasswordField(passwordString: String): Boolean {
        if (passwordString.length < 8) {
            et_password.error = getString(R.string.invalid_password)
            return false
        } else {
            et_password.error = null
            return true
        }
    }
}
