package com.example.charles.curriculumvitae.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.charles.curriculumvitae.R
import com.example.charles.curriculumvitae.WebViewActivity

class Contact : Fragment() {
    lateinit var linkedInBtn : Button
    lateinit var twitterBtn : Button
    lateinit var facebookBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_contact, container, false)
        linkedInBtn = view.findViewById(R.id.linkedIn)
        twitterBtn = view.findViewById(R.id.twitter)
        facebookBtn = view.findViewById(R.id.github)

        linkedInBtn.setOnClickListener {
            makeSomeIntents("linkedIn")
        }
        twitterBtn.setOnClickListener {
            makeSomeIntents("twitter")
        }
        facebookBtn.setOnClickListener {
            makeSomeIntents("facebook")
        }

        return view
    }

    fun makeSomeIntents(destination: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        when(destination) {
            "linkedIn" -> intent.data =  Uri.parse("https://www.linkedin.com/in/charles-kyewalabye/")
            "twitter" -> intent.data=Uri.parse( "https://twitter.com/")
            "facebook" ->  intent.data=Uri.parse( "https://facebook.com")
            else -> intent.data=Uri.parse( "https://www.google.com")
        }
        startActivity(intent)

    }
}