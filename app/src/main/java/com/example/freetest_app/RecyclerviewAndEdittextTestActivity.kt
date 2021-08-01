package com.example.freetest_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAndEdittextTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_and_edittext_test)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MyAdapter()

        // どういう並び方をさせるかの設定
        recyclerView.layoutManager = LinearLayoutManager(this) // 上から下に並べる
        recyclerView.adapter = adapter

        val textList2 = mutableListOf<String>()

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val clearButton = findViewById<Button>(R.id.clear_button)

        button.setOnClickListener {

            val text = editText.text.toString()

            if (text == "") {
                editText.error = "入力してください"
            } else {

                // リストに追加して EditText 内の文字をクリアする
                textList2.add(text)
                editText.setText("")

                // 上の textList を下の textList に入れる
                adapter.textList2 = textList2

                // adapter の中身を変えたときに必ずこれを呼ぶ(必須)
                // 呼ばれないと中身の変更が反映されない
                adapter.notifyDataSetChanged()
            }
        }

        clearButton.setOnClickListener {
            textList2.clear()
            editText.setText("")
        }
    }

    private class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        var textList2: List<String> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.list_item, parent, false)
            return RecyclerviewAndEdittextTestActivity.MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = textList2[position]
            holder.itemView.setBackgroundColor(
                if (position % 2 == 0) Color.WHITE else Color.LTGRAY
            )
        }

        override fun getItemCount(): Int = textList2.size
    }

    private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }
}