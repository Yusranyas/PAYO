package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val foto = findViewById<ImageView>(R.id.tri)
        foto.setOnClickListener {
            val intent = Intent(this, detailprofil::class.java)
            startActivity(intent)
        }

        val b = findViewById<Button>(R.id.viewww)
        b.setOnClickListener {
            val intent = Intent(this, history::class.java)
            startActivity(intent)
        }

        val p = findViewById<ImageView>(R.id.transper)
        p.setOnClickListener {
            val intent = Intent(this, transfer::class.java)
            startActivity(intent)
        }
    }
}