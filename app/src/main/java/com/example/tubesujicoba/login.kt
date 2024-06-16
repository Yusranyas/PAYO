package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tubesujicoba.databinding.LoginBinding
import com.example.tubesujicoba.databinding.SignupBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    lateinit var binding: LoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = LoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signup2.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener {
            val email = binding.etName2.text.toString()
            val password = binding.etName1.text.toString()

            //validasi email
            if(email.isEmpty()){
                binding.etName2.error = "Email harus diisi"
                binding.etName2.requestFocus()
                return@setOnClickListener
            }

            //validasi email tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etName2.error = "Email tidak sesuai"
                binding.etName2.requestFocus()
                return@setOnClickListener
            }

            //validasi password
            if(password.isEmpty()){
                binding.etName1.error = "Password harus diisi"
                binding.etName1.requestFocus()
                return@setOnClickListener
            }

            Loginfirebase(email,password)
        }
    }

    private fun Loginfirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Welcome $email", Toast.LENGTH_LONG).show()
                    val intent = Intent(this,home::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}