package com.example.freetest_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.UiThread
import kotlinx.coroutines.*
import org.w3c.dom.Text

class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        val scope = CoroutineScope(Job() + Dispatchers.Main)
        var job: Job? = null

        val textView = findViewById<TextView>(R.id.text_view)
        val startButton = findViewById<Button>(R.id.start_button)
        val stopButton = findViewById<Button>(R.id.stop_button)

        startButton.setOnClickListener {
            // 連打無効
            if (job?.isActive == true) return@setOnClickListener
            job = scope.launch {
                var count = 0
                try {
                    while (true) {
                        textView.text = "${count}秒"
                        count++
                        delay(1000)
                    }
                } finally {
                    textView.text = "停止"
                }
            }
        }

        stopButton.setOnClickListener {
            job?.cancel()
        }
    }
}