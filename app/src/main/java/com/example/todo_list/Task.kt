package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val db = DataBase(this)
        val position = intent.getIntExtra("position", -1) // получаем порядковый номер элемента
        val task = db.getTaskById(position + 1) // получаем данные из базы данных

        val editText4 = findViewById<EditText>(R.id.editTextText4)
        val editText5 = findViewById<EditText>(R.id.editTextText5)
        val editText6 = findViewById<EditText>(R.id.editTextText6)

        editText4.setText(task?.name)
        editText5.setText(task?.dateAcc)
        editText6.setText(task?.description)
    }
}