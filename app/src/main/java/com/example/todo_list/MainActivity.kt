package com.example.todo_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Заполняем основное окно
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализируем список под названием events типа RecycleView, заполняя его с помощью адаптера EventsAdapter
        val events = findViewById<View>(R.id.mainList) as RecyclerView
        val eventsList = ArrayList<Event>()
        for (i in 1..2) {
            eventsList.add(Event("Событие №$i"))
        }
        val adapter = EventsAdapter(eventsList)
        events.adapter = adapter
        events.layoutManager = LinearLayoutManager(this)

        val but1 = findViewById<Button>(R.id.button4)
        but1.setOnClickListener {
            val intent = Intent(this, Task::class.java)
            startActivity(intent)
        }

        val but2 = findViewById<Button>(R.id.button5)
        but2.setOnClickListener {
            val intent = Intent(this, Note::class.java)
            startActivity(intent)
        }
    }
}