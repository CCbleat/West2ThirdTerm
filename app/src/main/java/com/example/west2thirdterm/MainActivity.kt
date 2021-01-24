package com.example.west2thirdterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val groupChatList = ArrayList<GroupChat>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent1 = Intent(this, AddActivity::class.java)
        when (item.itemId) {
            R.id.add_chat_group -> startActivity(intent1)
            R.id.clear_chat_group_list -> 
            R.id.sign_out -> finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGroupChat() // 初始化群聊数据
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = GroupChatAdapter(groupChatList)
        recyclerView.adapter = adapter
    }

    private fun initGroupChat() {
        groupChatList.add(GroupChat(("Group1"), ("Bob"), R.drawable.mars_planet_1))
        groupChatList.add(GroupChat(("Group2"), ("Bill"), R.drawable.mars_planet_2))
        groupChatList.add(GroupChat(("Group3"), ("Dan"), R.drawable.mars_planet_3))
        groupChatList.add(GroupChat(("Group4"), ("William"), R.drawable.mars_planet_4))
    }


}
