package com.app.pg_saude

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSaude = findViewById<Button>(R.id.btsaude)
        btnSaude.setOnClickListener {
            val intent = Intent(this@MainActivity, SaudeActivity::class.java)
            startActivity(intent)
        }
        val btnBe = findViewById<Button>(R.id.btbe)
        btnBe.setOnClickListener {
            val intent = Intent(this@MainActivity, BemestarActivity::class.java)
            startActivity(intent)
        }
        val btnAlimentacao = findViewById<Button>(R.id.btalimentacao)
        btnAlimentacao.setOnClickListener {
            val intent = Intent(this@MainActivity, AlimentacaoActivity::class.java)
            startActivity(intent)
        }
        val btnEsporte = findViewById<Button>(R.id.btesporte)
        btnEsporte.setOnClickListener {
            val intent = Intent(this@MainActivity, EsporteActivity::class.java)
            startActivity(intent)
        }
        val btnReceitas = findViewById<Button>(R.id.btreceitas)
        btnReceitas.setOnClickListener {
            val intent = Intent(this@MainActivity, ReceitasActivity::class.java)
            startActivity(intent)
        }

    }
}
