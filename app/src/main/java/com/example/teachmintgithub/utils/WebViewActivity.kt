package com.example.assignmenttrial1

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.web_view)

        Log.e("WebViewActivity", "in the WebViewActivity screen")
        // Get the URL from the intent
        val url = intent.getStringExtra("url") ?: ""

        // Load the URL in the WebView
        webView.loadUrl(url)
    }
}
