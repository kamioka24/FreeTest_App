package com.example.freetest_app

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class UrlTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url_test)

        val urlTestTextView = findViewById<TextView>(R.id.urlTestTextView)
        urlTestTextView.text = HtmlCompat.fromHtml(getString(R.string.url_test_text_view), HtmlCompat.FROM_HTML_MODE_COMPACT)
        urlTestTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}