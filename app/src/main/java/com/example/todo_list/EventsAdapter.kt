package com.example.todo_list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

// Специальный адаптер, который заполняет RecycleView элементами по схеме item_event.xml
class EventsAdapter(val eventsList : List<Event>) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameCheckBox: CheckBox = itemView.findViewById(R.id.itemCheckBox)
        val eventButton: Button = itemView.findViewById(R.id.itemButton)
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
    override fun onBindViewHolder(holder: EventsAdapter.ViewHolder, position: Int) {
        val event : Event = eventsList.get(position)
        val eventCheckBox = holder.nameCheckBox
        eventCheckBox.text = (event.name)
        val button = holder.eventButton
        button.text = "Не нажимать"
        button.setOnClickListener {
            val intent = Intent(holder.itemView.context, Task::class.java)
            intent.putExtra("position", position) // передаем порядковый номер элемента
            holder.itemView.context.startActivity(intent, null)
        }
    }
}
