package com.example.west2thirdterm

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.Toast

class GroupChatAdapter(val groupChatList: List<GroupChat>) : RecyclerView.Adapter<GroupChatAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val groupImage: ImageView = view.findViewById(R.id.groupImage)
        val groupName: TextView = view.findViewById(R.id.groupName)
        val groupFounder: TextView = view.findViewById(R.id.groupFounder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.group_chat_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = groupChatList[position]
            Toast.makeText(parent.context, "you clicked view ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.groupImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = groupChatList[position]
            Toast.makeText(parent.context, "you clicked image ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = groupChatList[position]
        holder.groupImage.setImageResource(fruit.imageID)
        holder.groupName.text = fruit.name
        holder.groupFounder.text = fruit.Founder
    }

    override fun getItemCount() = groupChatList.size

}