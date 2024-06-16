package com.example.tubesujicoba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.tubesujicoba.databinding.SignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {

    lateinit var binding: SignupBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = SignupBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        binding.signup.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            //validasi email
            if(email.isEmpty()){
                binding.email.error = "Email harus diisi"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            //validasi email tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.email.error = "Email tidak sesuai"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            //validasi password
            if(password.isEmpty()){
                binding.password.error = "Password harus diisi"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            if(password.length < 6){
                binding.password.error = "Password minimal 6 karakter"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            Signupfirebase(email,password)
        }
    }

    private fun Signupfirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Signup berhasil", Toast.LENGTH_LONG).show()
                    val intent = Intent(this,login::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}


