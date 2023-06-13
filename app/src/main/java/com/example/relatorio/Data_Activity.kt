package com.example.relatorio

import android.app.DatePickerDialog
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Data_Activity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var btnSelectDate: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataAdapterActivity: Data_Adapter_Activity

    private var selectedDate: Date? = null
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_activity)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.setDisplayShowTitleEnabled(false)

        btnSelectDate = findViewById(R.id.btnSelectDate)
        val btnBackToMainActivity: Button = findViewById(R.id.btnBackToMainActivity)
        btnBackToMainActivity.setOnClickListener {
            finish() // Finaliza a atividade atual e retorna à atividade anterior (MainActivity)
        }
        recyclerView = findViewById(R.id.recyclerView)

        btnSelectDate.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, this, year, month, day)
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        selectedDate = calendar.time

        val selectedDateStr = dateFormat.format(selectedDate!!)
        ReadDataFromExcelTask().execute(selectedDateStr)
    }

    private inner class ReadDataFromExcelTask : AsyncTask<String, Void, List<String>>() {
        override fun doInBackground(vararg params: String): List<String> {
            val selectedDate = params[0]
            val dataList = mutableListOf<String>()

            // Dados fornecidos
            val data = arrayOf(
                "13/06/2023", "14/06/2023", "15/06/2023", "16/06/2023", "17/06/2023",
                "18/06/2023", "19/06/2023", "20/06/2023", "21/06/2023", "22/06/2023"
            )
            val peso = arrayOf("60", "70", "80", "90", "100", "110", "120", "130", "140", "150")
            val altura = arrayOf("1,7", "1,8", "1,9", "2", "2,1", "2,2", "2,3", "2,4", "2,5", "2,6")
            val imc = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
            val atividade = arrayOf("atividade1","atividade2","atividade3","atividade4","atividade5","atividade6","atividade7","atividade8","atividade9","atividade10",)

            for (i in data.indices) {
                if (data[i] == selectedDate) {
                    val entry = "Data: ${data[i]} / Peso: ${peso[i]} Kg / Altura: ${altura[i]} m / IMC: ${imc[i]} / Atividade: ${atividade[i]}"
                    dataList.add(entry)
                    break
                }
            }

            return dataList
        }

        override fun onPostExecute(result: List<String>) {
            super.onPostExecute(result)
            dataAdapterActivity = Data_Adapter_Activity(result)
            recyclerView.layoutManager = LinearLayoutManager(this@Data_Activity)
            recyclerView.adapter = dataAdapterActivity
        }
    }
}
