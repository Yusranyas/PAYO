package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val h = findViewById<ImageView>(R.id.cover)
        h.setOnClickListener {
            val intent = Intent(this, loginpage::class.java)
            startActivity(intent)
        }
    }
}