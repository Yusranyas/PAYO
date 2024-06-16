package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class detailprofil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_profil)

        val foto = findViewById<ImageView>(R.id.qr)
        foto.setOnClickListener {
            val intent = Intent(this, profilqr::class.java)
            startActivity(intent)
        }

        val x = findViewById<Button>(R.id.btn_keluar)
        x.setOnClickListener {
            val intent = Intent(this, loginpage::class.java)
            startActivity(intent)
        }

        val panah = findViewById<ImageView>(R.id.kembali)
        panah.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }
}