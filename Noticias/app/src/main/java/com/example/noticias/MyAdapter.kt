package com.example.noticias

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_items.view.*

class MyAdapter (val context: Context, val userList: List<Item>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var userId: TextView
    var title: TextView

    init {
        userId = itemView.Title
        title = itemView.Description
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = userList[position].title
        holder.title.text = userList[position].description
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}