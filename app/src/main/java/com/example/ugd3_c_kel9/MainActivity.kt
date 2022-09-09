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

class MainActivity : AppCompatActivity() {
    //  Attribute yang akan kita pakai
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout
    var mBundle: Bundle? = null

    lateinit var vUsername: String
    lateinit var vPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Ubah Title pada App Bar Aplikasi
        setTitle("Login Page")

        //  Hubungkan variabel dengan view di layoutnya.
        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val textViewRegister: TextView = findViewById(R.id.textViewRegister)




        //  Aksi btnClear ketika di klik
        btnClear.setOnClickListener { // Mengosongkan Input
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")

            //  Memunculkan SnackBar
            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        textViewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //  Aksi pada btnLogin
        btnLogin.setOnClickListener(View.OnClickListener {
            var checkLogin = true
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            //  Pengecekan apakah inputan kosong
            if (username.isEmpty()) {
                inputUsername.setError("Username must be filled with text")
                checkLogin = false
            }

            //  Pengecekan apakah Inputan kosong
            if (password.isEmpty()) {
                inputPassword.setError("Password must be filled with text")
                checkLogin = false
            }

            //  Ganti Password dengan NPM kalian.
            if(mBundle != null){
                getBundle()
                if(username == vUsername && password == vPassword){
                    checkLogin = true
                }
            }else if (username == "kelompok9" && password == "123")checkLogin = true
            if (!checkLogin) return@OnClickListener
            val moveHome = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(moveHome)
        })

       }

        fun getBundle() {
            lateinit var mBundle: Bundle
            mBundle = intent.getBundleExtra("REGISTER")!!
            vUsername = mBundle.getString("username")!!
            vPassword = mBundle.getString("password")!!
        }

}