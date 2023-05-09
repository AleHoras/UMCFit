package com.example.umcfit_calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            var txtAltura = findViewById<TextView>(R.id.txtAltura).text;
            var txtPeso = findViewById<TextView>(R.id.txtPeso).text;

            findViewById<TextView>(R.id.btnCalcular).setOnClickListener {
                //TODO: CONVERTER A ENTRADA PARA DOUBLE E CALCULAR
//                var altura =
//                var peso =  txtPeso
//
//                val resultadoConta = altura + peso;

                var resultado = findViewById<TextView>(R.id.txtResultado);
                resultado.text = txtPeso
            };

        } catch (error:Exception){
            println("Deu erro!")
        }




    }

    fun calculate(txtAltura:String, txtPeso:String){

        try {
            var altura = txtAltura.toDouble();
            var peso = txtPeso.toDouble();

            var resultado = findViewById<TextView>(R.id.txtResultado);

            resultado.text = (altura + peso).toString();

        } catch (error:Exception){
            println("Deu erro!")
        }
    }

}