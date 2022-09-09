package com.example.ugd3_c_kel9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    private lateinit var mainLayout: ConstraintLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setTitle("User Login")
        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        inputEmail = findViewById(R.id.inputLayoutEmail)
        inputTanggalLahir = findViewById(R.id.inputLayoutTanggalLahir)
        inputNomorTelepon = findViewById(R.id.inputLayoutNomorTelepon)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val textViewLogin: TextView = findViewById(R.id.textViewLogin)

        btnClear.setOnClickListener {
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")
            inputTanggalLahir.getEditText()?.setText("")
            inputEmail.getEditText()?.setText("")
            inputNomorTelepon.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        btnRegister.setOnClickListener(View.OnClickListener {
            var checkRegister = true
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()
            val tanggalLahir: String = inputTanggalLahir.getEditText()?.getText().toString()
            val email: String = inputEmail.getEditText()?.getText().toString()
            val nomorTelepon: String = inputNomorTelepon.getEditText()?.getText().toString()

            if (username.isEmpty()) {
                inputUsername.setError("Username must be filled with text")
                checkRegister = false
            }

            if (password.isEmpty()) {
                inputPassword.setError("Password must be filled with text")
                checkRegister = false
            }

            if (email.isEmpty()) {
                inputEmail.setError("Birth Date must be filled with text")
                checkRegister = false
            }

            if (tanggalLahir.isEmpty()) {
                inputTanggalLahir.setError("Email must be filled with text")
                checkRegister = false
            }

            if (nomorTelepon.isEmpty()) {
                inputNomorTelepon.setError("Phone Number must be filled with text")
                checkRegister = false
            }
            if (username == "kelompok9" && password == "123") checkRegister = true
            if (!checkRegister) return@OnClickListener
            val moveHome = Intent(this@RegisterActivity, MainActivity::class.java)

            val mBundle = Bundle()
            mBundle.putString("username", username)
            mBundle.putString("password", password)
            moveHome.putExtra("REGISTER", mBundle)


            startActivity(moveHome)
        })
        textViewLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    }



