package com.example.west2thirdterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val inputTextName = group_name.text.toString()
        val inputTextFounderName = group_founder.text.toString()
        group_name.setText("")
        group_founder.setText("")
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("inputTextName", inputTextName)
        intent.putExtra("inputTextFounderName", inputTextFounderName)
        create_group_chat.setOnClickListener {
            startActivity(intent)
        }
    }
}