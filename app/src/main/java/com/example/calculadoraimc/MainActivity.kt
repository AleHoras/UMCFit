package com.example.calculadoraimc

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

class MainActivity : ComponentActivity() {
    private lateinit var usernameText: EditText;
    private lateinit var passText: EditText;
    private lateinit var btnValidate: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        setContentView(R.layout.activity_main);

        usernameText = findViewById(R.id.username_input)
        passText = findViewById(R.id.pass)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {
            val username = usernameText.text.toString().trim()
            val password = passText.text.toString().trim()

            val errorMessages = mutableListOf<String>()

            if (username.isEmpty()) {
                errorMessages.add("Usuário é obrigatório")
            }
            if (password.isEmpty()) {
                errorMessages.add("Senha é obrigatória")
            }
            if (password.length < 8) {
                errorMessages.add("A senha deve ter no mínimo 8 caracteres")
            }
            if (!isValidEmail(username)) {
                errorMessages.add("Email inválido")
            }

            if (errorMessages.isNotEmpty()) {
                showErrorMessageDialog(errorMessages)
            } else {
                showSuccessMessageDialog()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun showErrorMessageDialog(errorMessages: List<String>) {
        val errorMessage = buildString {
            append("Os seguintes erros ocorreram:\n\n")
            errorMessages.forEachIndexed { index, message ->
                append("${index + 1}. $message\n")
            }
        }

        val dialogBuilder = AlertDialog.Builder(this)
            .setTitle("Erro de validação")
            .setMessage(errorMessage)
            .setPositiveButton("OK", null)
        val dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun navigateToNewScreen() {
        val intent = Intent(this, NewScreenActivity::class.java)
        startActivity(intent)
    }

    private fun showSuccessMessageDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
            .setTitle("Sucesso")
            .setMessage("Login feito com sucesso!")
            .setPositiveButton("OK") { _, _ ->
                navigateToNewScreen()
            }

        val dialog = dialogBuilder.create()
        dialog.show()
    }
}

class NewScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("LOGADO!")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraIMCTheme {
        Greeting("Android")
    }
}