package com.example.umcfit_calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TabelaImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tb_imc)

        findViewById<TextView>(R.id.btnVoltar).setOnClickListener{
            goToCalculadora();
        }
    }

    private fun goToCalculadora(){
        val goToCalculadora = Intent(this, ImcActivity::class.java);
        startActivity(goToCalculadora);
        finish();
    }

}