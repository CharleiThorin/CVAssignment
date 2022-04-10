package com.example.charles.curriculumvitae

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.charles.curriculumvitae.databinding.ActivityRegisterBinding


class RegisterActivity : Activity(){

    private lateinit var regBinder: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        regBinder = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(regBinder.root)

        regBinder.signUp.setOnClickListener {
            val intent = Intent()

            intent.putExtra(
                "user", User(
                regBinder.firstname.text.toString(),
                regBinder.lastname.text.toString(),
                regBinder.emailAddress.text.toString(),
                regBinder.pass.text.toString()
                )
            )
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
