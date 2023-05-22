package com.example.todo_list

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.Calendar

class Note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        // Создаем объект класса MyDatabase
        val myDatabase = DataBase(this)
        val db = myDatabase.writableDatabase

        // Получить ссылку на EditText, который будет использоваться для выбора даты
        val dateEditText = findViewById<EditText>(R.id.editTextDate)

        // Установить слушатель нажатия для EditText
        dateEditText.setOnClickListener {
            // Создать DatePickerDialog для выбора даты
            val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                    // Получить выбранную дату и установить ее в EditText
                    val selectedDate = String.format("%02d-%02d-%d", dayOfMonth, monthOfYear+1, year)
                    dateEditText.setText(selectedDate)
                },
                // Установить текущую дату как начальную дату в DatePickerDialog
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            // Показать DatePickerDialog
            datePickerDialog.show()
        }

        val dateEditText2 = findViewById<EditText>(R.id.editTextText3)
        val dateEditText3 = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)
        val but1 = findViewById<Button>(R.id.button5)
        // Вызываем функцию addTask, передавая ей необходимые параметры
        button.setOnClickListener {
            val dateAcc = dateEditText.text.toString()
            val descriptor = dateEditText2.text.toString()
            val name = dateEditText3.text.toString()
            myDatabase.addTask(name = name , description = descriptor , dateAcc = dateAcc, status = true/*статус еще не готов*/)
            super.onResume()
            db.close()
            finish()
        }

        but1.setOnClickListener {
            super.onResume()
            db.close()
            finish()
        }

        val button2 = findViewById<Button>(R.id.button3)
        button2.setOnClickListener {
            db.execSQL("CREATE TABLE IF NOT EXISTS Tasks (id INTEGER PRIMARY KEY, name TEXT, description TEXT, dateAdd TEXT, dateAcc TEXT, status BOOLEAN)")
        }

        val button1 = findViewById<Button>(R.id.button2)
        button1.setOnClickListener {
            db.execSQL("DROP TABLE IF EXISTS Tasks")
        }
    }
}
