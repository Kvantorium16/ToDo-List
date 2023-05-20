package com.example.todo_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Специальный адаптер, который заполняет RecycleView элементами по схеме item_event.xml
class EventsAdapter(val eventsList : List<Event>) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameCheckBox = itemView.findViewById<CheckBox>(R.id.itemCheckBox)
        val Zametka = itemView.findViewById<TextView>(R.id.Zametka)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.item_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    // Здесь определяется, как данные из объекта класса Event отображаются на экране
    override fun onBindViewHolder(holder: EventsAdapter.ViewHolder, position: Int) {
        val event : Event = eventsList.get(position)
        val eventCheckBox = holder.nameCheckBox
        eventCheckBox.text = (event.name)
        val Zametka = holder.Zametka
    }
}