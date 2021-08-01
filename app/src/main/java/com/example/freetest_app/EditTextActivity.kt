package com.example.freetest_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        val editText = findViewById<EditText>(R.id.edit_text)
        val textView = findViewById<TextView>(R.id.text_view)
        val button = findViewById<Button>(R.id.button)
        val editText2 = findViewById<EditText>(R.id.edit_text2)
        val textView2 = findViewById<TextView>(R.id.text_view2)

        button.setOnClickListener {
            textView.text = editText.text.toString()
        }

        // EditText に入力中にリアルタイムで TextView に文字を表示させる
        editText2.addTextChangedListener {
            textView2.text = it.toString()
        }
    }
}