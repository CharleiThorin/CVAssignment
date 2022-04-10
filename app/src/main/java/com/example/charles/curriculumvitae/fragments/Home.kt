package com.example.charles.curriculumvitae.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.Fragment
import com.example.charles.curriculumvitae.R
import com.example.charles.curriculumvitae.WebViewActivity

class Home : Fragment(){
    lateinit var linkedInBtn : Button
    private lateinit var binder: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        linkedInBtn = view.findViewById(R.id.linkedIn)
        linkedInBtn.setOnClickListener {
            linkedBtnPressed()
        }
        return view

    }

    override fun onStart() {
        super.onStart()

        roundImage()
    }


    private fun roundImage() {
        val img = BitmapFactory.decodeResource(resources, R.drawable.charles)
        val round = RoundedBitmapDrawableFactory.create(resources,img)
        round.isCircular = true
        val imageView = this.view?.findViewById<ImageView>(R.id.imageView)
        imageView?.setImageDrawable(round)
    }

    //Actions
    fun linkedBtnPressed(){
        val intent = Intent (getActivity(), WebViewActivity::class.java)
        intent.putExtra("link","http://www.linkedin.com/in/ckyewalabye")
        activity?.startActivity(intent)


    }
}