package com.example.freetest_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class EditTextTestActivity : AppCompatActivity() {

    private val editText = findViewById<EditText>(R.id.edit_text)
    private val textView = findViewById<TextView>(R.id.text_view)
    private val button = findViewById<Button>(R.id.button)
    private val editText2 = findViewById<EditText>(R.id.edit_text2)
    private val textView2 = findViewById<TextView>(R.id.text_view2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_test)

        button.setOnClickListener {
            textView.text = editText.text.toString()
        }

        // EditText に入力中にリアルタイムで TextView に文字を表示させる
        editText2.addTextChangedListener {
            textView2.text = it.toString()
        }
    }
}