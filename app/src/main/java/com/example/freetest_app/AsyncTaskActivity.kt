package com.example.freetest_app

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AsyncTaskActivity : AppCompatActivity() {

    private var task: MyAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        task = MyAsyncTask().apply {
            execute(100)
        }
    }

    override fun onDestroy() {
        task?.cancel(true)
        task = null
        super.onDestroy()
    }

    private inner class MyAsyncTask : AsyncTask<Int, String, String>() {

        val textView = findViewById<TextView>(R.id.text_view)

        override fun doInBackground(vararg params: Int?): String {
            for (i in 1..params[0]!! ) {
                publishProgress("loading...$i%")
                Thread.sleep(50)
            }
            return "完了"
        }

        override fun onProgressUpdate(vararg values: String?) {
            textView.text = values[0]
        }

        override fun onPostExecute(result: String?) {
            textView.text = result
        }
    }
}