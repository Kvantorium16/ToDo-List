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

        val db = DataBase(this)
        db.initialize()

        // Инициализируем список под названием events типа RecycleView, заполняя его с помощью адаптера EventsAdapter
        val events = findViewById<View>(R.id.mainList) as RecyclerView
        val adapter = EventsAdapter(db)
        events.adapter = adapter
        events.layoutManager = LinearLayoutManager(this)

        val p2 = findViewById<Button>(R.id.button6)
        val myNotification = Notification(this)
        myNotification.createNotificationChannel("channel_id_example_01")
        p2.setOnClickListener {
            myNotification.sendNotification("channel_id_example_01", 101)
        }

        val but1 = findViewById<Button>(R.id.button5)
        but1.setOnClickListener {
            val intent = Intent(this, Note::class.java)
            startActivity(intent)
        }
    }
}
