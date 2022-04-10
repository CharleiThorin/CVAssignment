package com.example.charles.curriculumvitae

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.charles.curriculumvitae.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity(){

    private lateinit var binder: ActivityWebViewBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?){
       super.onCreate(savedInstanceState)
        binder = ActivityWebViewBinding.inflate(layoutInflater)
       setContentView(binder.root)
       loadUrl()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(url: String){
        binder.webView.webViewClient = WebViewClient()
        binder.webView.settings.javaScriptEnabled = true
        binder.webView.settings.builtInZoomControls = true
        binder.webView.loadUrl(url)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadUrl(){
        val intent = getIntent()
        val url: String? = intent.getStringExtra("link")
        webViewSetup(url?:"https://www.google.com")

    }
}