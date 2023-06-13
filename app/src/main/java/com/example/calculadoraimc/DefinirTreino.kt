package com.example.calculadoraimc

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class DefinirTreino : AppCompatActivity() {
    private lateinit var editTextData: EditText
    private lateinit var editTextHora: EditText
    private lateinit var buttonAgendar: Button
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var spinnerTipoTreino: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.definir_treino)

        editTextData = findViewById(R.id.editTextData)
        editTextHora = findViewById(R.id.editTextHora)
        buttonAgendar = findViewById(R.id.buttonAgendar)
        spinnerTipoTreino = findViewById(R.id.spinnerTipoTreino)

        databaseHelper = DatabaseHelper(this)

        editTextData.setOnClickListener {
            exibirDatePicker()
        }

        editTextHora.setOnClickListener {
            exibirTimePicker()
        }

        buttonAgendar.setOnClickListener {
            val tipoTreino = spinnerTipoTreino.selectedItem.toString()
            val data = editTextData.text.toString()
            val hora = editTextHora.text.toString()

            if (tipoTreino.isNotBlank() && data.isNotBlank() && hora.isNotBlank()) {
                val dataHora = parseDataHora(data, hora)

                // Inserir treino no banco de dados
                val treino = Treino(tipoTreino, dataHora.toString())
                inserirTreinoNoBancoDeDados(treino)

                Toast.makeText(this, "Treino agendado para: $dataHora", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor, selecione o tipo de treino, a data e a hora do treino", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun exibirDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val formatoData = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val dataSelecionada = formatoData.format(calendar.time)
            editTextData.setText(dataSelecionada)
        }

        val datePickerDialog = DatePickerDialog(this, datePickerListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePickerDialog.show()
    }

    private fun exibirTimePicker() {
        val calendar = Calendar.getInstance()
        val timePickerListener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)

            val formatoHora = SimpleDateFormat("HH:mm", Locale.getDefault())
            val horaSelecionada = formatoHora.format(calendar.time)
            editTextHora.setText(horaSelecionada)
        }

        val timePickerDialog = TimePickerDialog(this, timePickerListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)
        timePickerDialog.show()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DefinirTreino::class.java)
        }
    }

    private fun parseDataHora(data: String, hora: String): Date {
        val formatoDataHora = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return formatoDataHora.parse("$data $hora")!!
    }

    private fun inserirTreinoNoBancoDeDados(treino: Treino) {
        val db = databaseHelper.writableDatabase

        val values = ContentValues()
        values.put("tipo", treino.tipo)
        values.put("data_hora", treino.dataHora)

        db.insert("treinos", null, values)
        db.close()
    }
}
