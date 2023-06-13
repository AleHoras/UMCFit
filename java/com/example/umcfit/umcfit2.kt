package com.example.umcfit


import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.google.android.material.textfield.TextInputEditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast



class umcfit2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.umcfit2)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val btnparq: RadioButton = findViewById(R.id.btnparq)
        val btnacad: RadioButton = findViewById(R.id.btnacad)
        val btnquad: RadioButton = findViewById(R.id.btnquad)
        val nome: TextInputEditText = findViewById(R.id.nome)
        val end: TextInputEditText = findViewById(R.id.end)
        val btn_cadastrar2: Button = findViewById(R.id.btn_cadastrar2)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.btnparq -> {
                    Toast.makeText(this, "Opção 1 selecionada", Toast.LENGTH_SHORT).show()
                }
                R.id.btnacad -> {
                    Toast.makeText(this, "Opção 2 selecionada", Toast.LENGTH_SHORT).show()
                }
                R.id.btnquad -> {
                    Toast.makeText(this, "Opção 3 selecionada", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_cadastrar2.setOnClickListener {
            val nome = nome.text.toString()
            val end = end.text.toString()


            val radioButtonId = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonId)



            if (nome.isNotEmpty() && end.isNotEmpty() && radioButtonId != -1) {



                val mensagem = "Cadastro realizado com sucesso!\nNome: $nome\nEndereço: $end\n"
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()


            } else {

                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
