package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        findViewById<TextView>(R.id.textView2).setOnClickListener {
            val goToMenu = Intent(this, MenuActivity::class.java);
            startActivity(goToMenu);
            finish();
        }

    }
}