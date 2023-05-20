package com.example.todo_list

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DataBase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Tasks (id INTEGER PRIMARY KEY, name TEXT, description TEXT, dateAdd TEXT, dateAcc TEXT, status BOOLEAN)")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE Tasks")
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }

    //  Функция добавления новой записи в базу данных
    fun addTask(name: String, description: String, dateAdd: String? = null, dateAcc: String, status: Boolean) {
        // Автоподстановка текущего времени в значение dateAdd
        val dateAdd = dateAdd ?: SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Calendar.getInstance().time)
        val values = ContentValues().apply {
            put("name", name)
            put("description", description)
            put("dateAdd", dateAdd)
            put("dateAcc", dateAcc)
            put("status", status)
        }
        val db = writableDatabase
        db.insert("Tasks", null, values)
        //db.close()
    }
}