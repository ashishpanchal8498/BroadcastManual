package com.example.broadcastmanual

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity() {

    private lateinit var btSendBroadcast: Button
    private var BROADCAST_ACTION = "com.example.sendbroadcast.SEND_TOAST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        btSendBroadcast = findViewById(R.id.bt_send_broadcast)
        btSendBroadcast.setOnClickListener {
            sendToastBroadcast()
        }
    }

    private fun sendToastBroadcast() {
        val intent = Intent()
        intent.action = BROADCAST_ACTION
        sendBroadcast(intent)


    }
}
