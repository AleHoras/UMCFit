package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_salvar).setOnClickListener{
            val nome = findViewById<EditText>(R.id.edit_text_nome)
            val peso = findViewById<EditText>(R.id.edit_text_peso)
            val dataNascimento = findViewById<EditText>(R.id.edit_text_data_nascimento)
        }
        findViewById<Button>(R.id.button_cancelar).setOnClickListener{
            findViewById<EditText>(R.id.edit_text_nome).text = null
            findViewById<EditText>(R.id.edit_text_peso).text = null
            findViewById<EditText>(R.id.edit_text_data_nascimento).text = null
        }
    }
}
