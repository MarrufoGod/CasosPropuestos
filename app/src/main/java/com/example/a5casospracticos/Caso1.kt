package com.example.a5casospracticos

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Caso1 : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var editTextText: EditText
    private lateinit var checkBoxEmpleado: CheckBox
    private lateinit var checkBoxObrero: CheckBox
    private lateinit var button: Button
    private lateinit var textView19: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso1)

        editTextNumber = findViewById(R.id.editTextNumber)
        editTextText = findViewById(R.id.editTextText)
        checkBoxEmpleado = findViewById(R.id.checkBoxEmpleado)
        checkBoxObrero = findViewById(R.id.checkBoxObrero)
        button = findViewById(R.id.button)
        textView19 = findViewById(R.id.textView19)

        button.setOnClickListener { calculateRemuneration() }
    }

    private fun calculateRemuneration() {
        val numChildrenStr = editTextNumber.text.toString()
        val basicIncomeStr= editTextText.text.toString()

        if (basicIncomeStr.isEmpty() || numChildrenStr.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val basicIncome = basicIncomeStr.toInt()
        val numChildren = numChildrenStr.toInt()
        var bonus = 0

        if (checkBoxEmpleado.isChecked) {
            bonus = 120
        } else if (checkBoxObrero.isChecked) {
            bonus = 100
        }

        val assignment = numChildren * 41
        val total = basicIncome + bonus + assignment

        val result = """
            Ingreso Básico: $basicIncome
            Bonificación: $bonus
            Asignación por Hijos ($numChildren hijos): $assignment
            Remuneración Total: $total
        """.trimIndent()

        textView19.text = result
    }
}
