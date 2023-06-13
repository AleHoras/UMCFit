package com.example.umcfit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.umcfit.ui.theme.UmcFitTheme
import com.google.android.material.textfield.TextInputEditText

class umcfit1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.umcfit1)
        setContent {
            UmcFitTheme {
                val nome: TextView = findViewById(R.id.nome)
                val end: TextView = findViewById(R.id.end)
                val btn_cadastrar: Button = findViewById(R.id.btn_cadastrar)
                val btn_edit1: Button = findViewById(R.id.btn_edit1)

            }
            btn_cadastrar.setOnClickListener {
                val intent = Intent(this, umcfit2::class.java)


                startActivity(intent)
            }
            btn_edit1.setOnClickListener {
                val intent = Intent(this, umcfit3::class.java)


                startActivity(intent)
            }
            }
        }
    }

