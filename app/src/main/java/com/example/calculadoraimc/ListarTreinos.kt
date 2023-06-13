package com.example.calculadoraimc

import TreinosAdapter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class ListarTreinos : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAdicionar: Button
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var treinosAdapter: TreinosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listar_treinos)

        recyclerView = findViewById(R.id.recyclerView)
        buttonAdicionar = findViewById(R.id.buttonAdicionar)

        databaseHelper = DatabaseHelper(this)
        treinosAdapter = TreinosAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = treinosAdapter

        buttonAdicionar.setOnClickListener {
            // Abrir tela de adicionar treino
            startActivity(DefinirTreino.newIntent(this))
        }
    }

    private fun formatarDataHora(dataHora: Date): String {
        val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
        formato.timeZone = TimeZone.getTimeZone("GMT+3")
        return formato.format(dataHora)
    }

    override fun onResume() {
        super.onResume()
        // Atualizar a lista de treinos ao retomar a atividade
        val treinos = databaseHelper.obterTodosTreinos()
        treinosAdapter.setTreinos(treinos)
    }
}
