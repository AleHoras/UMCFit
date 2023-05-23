package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.btnDadosPessoais).setOnClickListener {
//            val goToCalculadora = Intent(this, );
//            startActivity(goToCalculadora);
//            finish();
        }

        findViewById<TextView>(R.id.btnTreinos).setOnClickListener {
//            val goToCalculadora = Intent(this, );
//            startActivity(goToCalculadora);
//            finish();
        }

        findViewById<TextView>(R.id.btnLembrete).setOnClickListener {
//            val goToCalculadora = Intent(this, );
//            startActivity(goToCalculadora);
//            finish();
        }

        findViewById<TextView>(R.id.btnCalculadora).setOnClickListener {
//            val goToCalculadora = Intent(this, ImcActivity::class.java);
//            startActivity(goToCalculadora);
//            finish();
        }

        findViewById<TextView>(R.id.btnrefeicao).setOnClickListener {
//            val goToCalculadora = Intent(this, );
//            startActivity(goToCalculadora);
//            finish();
        }

        findViewById<TextView>(R.id.btnMinhaEvolucao).setOnClickListener {
//            val goToCalculadora = Intent(this, );
//            startActivity(goToCalculadora);
//            finish();
        }

        findViewById<TextView>(R.id.btnAcademiasProx).setOnClickListener {
//            val goToCalculadora = Intent(this, );
//            startActivity(goToCalculadora);
//            finish();
        }


    }
}