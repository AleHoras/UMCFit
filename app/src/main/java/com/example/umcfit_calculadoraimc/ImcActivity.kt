package com.example.umcfit_calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_imc)
        try{

            findViewById<TextView>(R.id.btnCalcular).setOnClickListener {

                var txtAltura = findViewById<TextView>(R.id.txtAltura).text.toString();
                var txtPeso = findViewById<TextView>(R.id.txtPeso).text.toString();

                var altura = txtAltura.toDouble();
                var peso =  txtPeso.toDouble();

                var resultadoConta = peso / ((altura / 100) * (altura / 100));

                var decimalFormat = DecimalFormat("#.##");
                decimalFormat.roundingMode = RoundingMode.UP;
                val finalResult = decimalFormat.format(resultadoConta).toString();

                var resultado = findViewById<TextView>(R.id.txtResultado);
                resultado.text = finalResult


                if(resultadoConta < 18.5 ){
                    resultado.setTextColor(getResources().getColor(R.color.magreza));
                } else if(resultadoConta >= 18.5 && resultadoConta <= 24.9){
                    resultado.setTextColor(getResources().getColor(R.color.normal));
                } else if(resultadoConta > 24.9 && resultadoConta <= 29.9){
                    resultado.setTextColor(getResources().getColor(R.color.excesso));
                } else if(resultadoConta > 29.9 && resultadoConta <= 34.9){
                    resultado.setTextColor(getResources().getColor(R.color.obesidade_1));
                } else if(resultadoConta > 34.9 && resultadoConta <= 39.9){
                    resultado.setTextColor(getResources().getColor(R.color.obesidade_2));
                } else if(resultadoConta > 39.9){
                    resultado.setTextColor(getResources().getColor(R.color.obesidade_3));
                }

            }

        } catch (error:Exception){

        }
    }

}