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

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }
        })
    }

    //a placeholder function to validate email field
    private fun checkEmailField(emailString: String) {
        return if (Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
            et_email.error = null
        } else {
            et_email.error = getString(R.string.invalid_email)
        }
    }
}
