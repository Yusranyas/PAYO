package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)

        val cover = findViewById<Button>(R.id.login1)
        cover.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        val h = findViewById<TextView>(R.id.signup)
        h.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
    }
}