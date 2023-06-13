package com.example.relatorio

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IMC_Activity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataAdapterActivity: Data_Adapter_Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imc_activity)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide() // Remover a barra de título

        recyclerView = findViewById(R.id.recyclerView)

        val btnBackToMainActivity: Button = findViewById(R.id.btnBackToMainActivity)
        btnBackToMainActivity.setOnClickListener {
            finish()
        }

        // Dados fornecidos
        val data = arrayOf(
            "13/06/2023", "14/06/2023", "15/06/2023", "16/06/2023", "17/06/2023",
            "18/06/2023", "19/06/2023", "20/06/2023", "21/06/2023", "22/06/2023"
        )
        val imc = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        val dataList = mutableListOf<String>()
        for (i in data.indices) {
            val entry = "${data[i]}, ${imc[i]}"
            dataList.add(entry)
        }

        showData(dataList)
    }


    private fun showData(data: List<String>) {
        val filteredDataList = data.map { entry ->
            val parts = entry.split(", ")
            "Data: ${parts[0]} / IMC: ${parts[1]}"
        }

        dataAdapterActivity = Data_Adapter_Activity(filteredDataList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dataAdapterActivity
        dataAdapterActivity.notifyDataSetChanged()
    }

}

