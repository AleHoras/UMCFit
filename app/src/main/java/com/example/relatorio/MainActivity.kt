package com.example.relatorio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        val bDATA = findViewById<Button>(R.id.bDATA)
        bDATA.setOnClickListener {
            val intent = Intent(this, Data_Activity::class.java)
            startActivity(intent)

            val bIMC = findViewById<Button>(R.id.bIMC)
            bIMC.setOnClickListener {
                val intent = Intent(this, IMC_Activity::class.java)
                startActivity(intent)

                val bPESO = findViewById<Button>(R.id.bPESO)
                bPESO.setOnClickListener {
                    val intent = Intent(this, Peso_activity::class.java)
                    startActivity(intent)

                }

            }
        }
    }
}