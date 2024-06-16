package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class profilqr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil_qr)

        val info = findViewById<ImageView>(R.id.kembali)
        info.setOnClickListener {
            val intent = Intent(this, detailprofil::class.java)
            startActivity(intent)
        }
    }
}