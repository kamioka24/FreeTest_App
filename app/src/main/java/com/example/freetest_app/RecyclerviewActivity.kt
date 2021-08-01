package com.example.freetest_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MyAdapter()

        // どういう並び方をさせるかの設定
        recyclerView.layoutManager = LinearLayoutManager(this) // 上から下に並べる
        recyclerView.adapter = adapter

        val textList = mutableListOf<String>()
        for (i in 1..300) {
            textList.add("要素$i")
        }

        // 上の textList を下の textList に入れる
        adapter.textList = textList

        // adapter の中身を変えたときに必ずこれを呼ぶ(必須)
        // 呼ばれないと中身の変更が反映されない
        adapter.notifyDataSetChanged()
    }

    private class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        var textList: List<String> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.list_item, parent, false)
            return MyViewHolder(view)
        }

        // View にデータを設定するためのメソッド(必須)
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = textList[position]
            holder.itemView.setBackgroundColor(
                if (position % 2 == 0) Color.WHITE else Color.LTGRAY
            )
        }

        // アイテム総数メソッド(必須)
        override fun getItemCount(): Int = textList.size
    }

    private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }
}