package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)

        val cover = findViewById<ImageView>(R.id.kembalii)
        cover.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }
}