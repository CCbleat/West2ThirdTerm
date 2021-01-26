package com.example.west2thirdterm

import android.content.Intent
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
//        val intent2 = Intent(this, DetailActivity::class.java)
//        viewHolder.itemView.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val itemPostion = groupChatList[position]
//            Toast.makeText(parent.context, "you clicked view ${itemPostion.name}", Toast.LENGTH_SHORT).show()
//        }
        viewHolder.groupImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val groupMes = groupChatList[position]
//            startActivity 不会用view写这个，555
            Toast.makeText(parent.context, "Detail Message \nGroupName：${groupMes.name} \nGroupFounder: ${groupMes.Founder}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val group_chat = groupChatList[position]
        holder.groupImage.setImageResource(group_chat.imageID)
        holder.groupName.text = group_chat.name
        holder.groupFounder.text = group_chat.Founder
    }

    override fun getItemCount() = groupChatList.size

}