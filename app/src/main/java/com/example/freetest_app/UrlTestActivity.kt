package com.example.freetest_app

import android.os.Bundle
import android.text.util.Linkify
import android.text.util.Linkify.TransformFilter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class UrlTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url_test)

        val urlTestTextView = findViewById<TextView>(R.id.urlTestTextView)
        urlTestTextView.setText("あかさたなはまやらわ")
        val pattern = Pattern.compile("なは")

        addLink("https://www.youtube.com/", pattern, urlTestTextView)
    }

    private fun addLink(link: String, pattern: Pattern, textview: TextView) {
        val filter = TransformFilter { match, url -> link }
        Linkify.addLinks(textview, pattern, link, null, filter)
    }
}