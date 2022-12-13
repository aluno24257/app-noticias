package com.example.noticias

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import org.w3c.dom.Text

class MyAdapter (val context: Context, val userList: List<UltimasNoticias>): RecyclerView.Adapter<MyAdapter.viewHolder>() {
    class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var userId: TextView
    var title: TextView

    init {
        userId = itemView.userId
        title = itemView.title
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var attachToRoot = false
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, attachToRoot : false )
        return RecyclerView.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.userId.text = userList[position].userId.toString()
        holder.title.text = userList[position].title
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}