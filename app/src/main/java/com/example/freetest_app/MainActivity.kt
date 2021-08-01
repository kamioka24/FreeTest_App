package com.example.freetest_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.freetest_app.R.id.url_test_activity_button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_url_test.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlTestActivityButton = findViewById<Button>(R.id.url_test_activity_button)
        val editTextTestActivityButton = findViewById<Button>(R.id.edit_text_test_activity_button)
        val recyclerviewTestActivityButton = findViewById<Button>(R.id.recyclerview_test_activity_button)
        val recyclerviewAndEdittextTestActivityButton = findViewById<Button>(R.id.recyclerview_and_edittext_test_activity_button)

        urlTestActivityButton.setOnClickListener {
            val intent = Intent(this, UrlTestActivity::class.java)
            startActivity(intent)
        }

        editTextTestActivityButton.setOnClickListener {
            val intent = Intent(this, EditTextTestActivity::class.java)
            startActivity(intent)
        }

        recyclerviewTestActivityButton.setOnClickListener {
            val intent = Intent(this, RecyclerviewTestActivity::class.java)
            startActivity(intent)
        }

        recyclerviewAndEdittextTestActivityButton.setOnClickListener {
            val intent = Intent(this, RecyclerviewAndEdittextTestActivity::class.java)
            startActivity(intent)
        }
    }
}