package com.example.umcfit


import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.google.android.material.textfield.TextInputEditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast



class umcfit3 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.umcfit3)
        val radioGroup2: RadioGroup = findViewById(R.id.radioGroup2)
        val btnparq2: RadioButton = findViewById(R.id.btnparq2)
        val btnacad2: RadioButton = findViewById(R.id.btnacad2)
        val btnquad2: RadioButton = findViewById(R.id.btnquad2)
        val nome2: TextInputEditText = findViewById(R.id.nome2)
        val end2: TextInputEditText = findViewById(R.id.end2)
        val btn_edit2: Button = findViewById(R.id.btn_edit2)

        radioGroup2.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.btnparq2 -> {
                    Toast.makeText(this, "Opção 1 selecionada", Toast.LENGTH_SHORT).show()
                }
                R.id.btnacad2 -> {
                    Toast.makeText(this, "Opção 2 selecionada", Toast.LENGTH_SHORT).show()
                }
                R.id.btnquad2 -> {
                    Toast.makeText(this, "Opção 3 selecionada", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_edit2.setOnClickListener {
            val nome = nome2.text.toString()
            val end = end2.text.toString()


            val radioButtonId = radioGroup2.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonId)



            if (nome.isNotEmpty() && end.isNotEmpty() && radioButtonId != -1) {



                val mensagem = "Cadastro realizado com sucesso!\nNome: $nome2\nEndereço: $end2\n"
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()


            } else {

                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}


