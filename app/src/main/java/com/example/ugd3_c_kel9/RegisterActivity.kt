package com.example.ugd3_c_kel9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputTanggalLahir: TextInputLayout
    private lateinit var inputNomorTelepon: TextInputLayout
    private lateinit var registerLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        inputEmail = findViewById(R.id.inputLayoutEmail)
        inputTanggalLahir = findViewById(R.id.inputLayoutTanggalLahir)
        inputNomorTelepon = findViewById(R.id.inputLayoutNomorTelepon)
        registerLayout = findViewById(R.id.registerLayout)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val textViewLogin: TextView = findViewById(R.id.textViewLogin)

        textViewLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //  Aksi btnClear ketika di klik
        btnClear.setOnClickListener { // Mengosongkan Input
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")
            inputEmail.getEditText()?.setText("")
            inputTanggalLahir.getEditText()?.setText("")
            inputNomorTelepon.getEditText()?.setText("")

            //  Memunculkan SnackBar
            Snackbar.make(registerLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }
    }
}