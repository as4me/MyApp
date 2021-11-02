package com.apusx.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        val email: EditText  = findViewById(R.id.editTextTextPersonName)
        val password: EditText = findViewById(R.id.editTextTextPassword)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this,"Нажали на кнопочку",Toast.LENGTH_LONG).show()
            val email_text: String = email.text.toString().trim()
            val password_text: String = password.text.toString().trim()

            auth.createUserWithEmailAndPassword(email_text, password_text)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"Вошли",Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this,"Ошибка",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}