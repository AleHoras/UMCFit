package com.example.umcfit_calculadoraimc

import android.content.Context
import android.content.Intent
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_imc)
        try{

            findViewById<TextView>(R.id.txtAltura).addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged( s: CharSequence?,start: Int,count: Int, after: Int ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    TODO("Not yet implemented")
                }

                override fun afterTextChanged(s: Editable?) {
                    if(s?.length == 3){
                        closeKeyBoard();
                    }
                }

            })



            findViewById<TextView>(R.id.btnCalcular).setOnClickListener {

                var txtAltura = findViewById<TextView>(R.id.txtAltura).text.toString().replace("/\\D/g", "");
                var txtPeso = findViewById<TextView>(R.id.txtPeso).text.toString().replace("/\\D/g", "");
                if(txtAltura.isNotEmpty() && txtPeso.isNotEmpty()){
                    calculateImc(txtAltura, txtPeso);
                }
            }

            findViewById<TextView>(R.id.btnTabela).setOnClickListener {
                goTabelaImc();
            }


        } catch (error:Exception){

        }
    }

    private fun calculateImc(txtAltura:String, txtPeso:String){
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

    private fun goTabelaImc(){
        val goTabelaImc = Intent(this, TabelaImcActivity::class.java);
        startActivity(goTabelaImc);
        finish();
    }


    private fun closeKeyBoard(){
        val view: View? = currentFocus;
        view?.let {
//            val imm: InputMethodService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodService;
        }
    }


}