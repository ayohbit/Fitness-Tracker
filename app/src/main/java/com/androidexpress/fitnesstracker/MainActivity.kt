package com.androidexpress.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnImc: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnImc = findViewById(R.id.btn_imc)

        btnImc.setOnClickListener {
            // navegar para a proxima tela
            val i = Intent(this, imcActivity::class.java)
            startActivity(i)
        }
    }
}