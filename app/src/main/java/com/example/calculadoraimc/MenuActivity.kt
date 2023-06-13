package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<TextView>(R.id.btnDadosPessoais).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

        findViewById<TextView>(R.id.btnTreinos).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

        findViewById<TextView>(R.id.btnLembretes).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

        findViewById<TextView>(R.id.btnCalcImc).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

        findViewById<TextView>(R.id.btnDicasReceitas).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

        findViewById<TextView>(R.id.btnMInhaEvolu).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

        findViewById<TextView>(R.id.btnAcademiasProxima).setOnClickListener {
            val goToTelaTeste = Intent(this, TesteActivity::class.java);
            startActivity(goToTelaTeste);
            finish();
        }

    }
}