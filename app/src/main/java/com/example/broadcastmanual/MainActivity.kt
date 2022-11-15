package com.example.broadcastmanual

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var btSecond: Button
    private var BROADCAST_ACTION = "com.example.sendbroadcast.SEND_TOAST"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btSecond = findViewById(R.id.button_second)

        registerBroadcast(applicationContext)

        btSecond.setOnClickListener {
            val intent = Intent(this@MainActivity, NewActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun registerBroadcast(context: Context) {
        val filter = IntentFilter(BROADCAST_ACTION)
        context.registerReceiver(BroadcastApp(), filter)
    }

    inner class BroadcastApp : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            Toast.makeText(applicationContext,  "broadcast received", Toast.LENGTH_LONG ).show()
        }
    }
}






