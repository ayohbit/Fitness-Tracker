package com.androidexpress.fitnesstracker

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class imcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        editWeight = findViewById(R.id.edit_imc_weight)
        editHeight = findViewById(R.id.edit_imc_height)

        val btnSend: Button = findViewById(R.id.btn_imc_send)
        btnSend.setOnClickListener {
            if (!validate()) {
                Toast.makeText(this, R.string.fields_message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val weight = editWeight.text.toString().toInt()
                val height = editHeight.text.toString().toInt()
                val result = calculateImc(weight, height)

                val imcResponseId = imcResponse(result)
                // Mostrar condição da pessoa
                //Toast.makeText(this, getString(imcResponseId), Toast.LENGTH_SHORT).show()

                // Criar e mostrar o diálogo apenas se o cálculo for bem-sucedido
                val dialog = AlertDialog.Builder(this)
                dialog.setTitle(getString(R.string.imc_response, result))
                dialog.setMessage(getString(imcResponseId))  // Corrigido: use getString() para converter Int em String
                dialog.setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        // Nada aqui, ou adicione lógica se necessário
                    }
                })
                val d = dialog.create()
                d.show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun imcResponse(imc: Double): Int {
        return when {
            imc < 15.0 -> R.string.imc_severely_low_weight
            imc < 16.0 -> R.string.imc_very_low_weight
            imc < 18.5 -> R.string.imc_low_weight
            imc < 25.0 -> R.string.normal
            imc < 30.0 -> R.string.imc_high_weight
            imc < 35.0 -> R.string.imc_so_high_weight
            imc < 40.0 -> R.string.imc_severely_high_weight  // Corrigido: era "severely_low", agora "high" para obesidade severa
            else -> R.string.imc_extreme_weight
        }
    }

    private fun calculateImc(weight: Int, height: Int): Double {
        return weight / ((height / 100.0) * (height / 100.0))
    }

    private fun validate(): Boolean {
        val weightStr = editWeight.text.toString()
        val heightStr = editHeight.text.toString()
        return (weightStr.isNotEmpty()
                && heightStr.isNotEmpty()
                && !weightStr.startsWith("0")
                && !heightStr.startsWith("0")
                && heightStr.toIntOrNull()?.let { it > 0 } == true)  // Adicionado: evita altura zero para divisão por zero
    }
}