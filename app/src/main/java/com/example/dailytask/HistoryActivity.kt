package com.example.dailytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*


class HistoryActivity : AppCompatActivity() {
    val list = arrayListOf<TodoModel>()
    val adpter = TodoAdapter(list)
    val db by lazy {
        AppDatabase.getDatabase(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        recyclehistory.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = this@HistoryActivity.adpter
        }
        db.todoDao().finishTask(1)
    }



}