package com.example.a5casospracticos

import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso4 : AppCompatActivity() {

        private lateinit var SueldoBasico : EditText;
        private lateinit var CheckObrero : CheckBox;
        private lateinit var CheckEmpleado : CheckBox;
        private lateinit var CheckEjecutivo: CheckBox;
        private lateinit var ButtonCalcular : Button;
        private  lateinit var TxtResultado : TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caso4)

        SueldoBasico = findViewById(R.id.txtSueldoBasico)
        CheckObrero = findViewById(R.id.checkBoxObrero)
        CheckEjecutivo = findViewById(R.id.checkBoxEjecutivo)
        CheckEmpleado = findViewById(R.id.checkBoxEmpleado)
        ButtonCalcular = findViewById(R.id.buttonCalcular)
        TxtResultado = findViewById(R.id.textResultado)

        ButtonCalcular.setOnClickListener{ CalcularRemuneracion()}

    }
    private fun CalcularRemuneracion(){

        val Basico = SueldoBasico.text.toString()

        if (Basico.isEmpty()){
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
        }


        val SueldoFinal = Basico.toInt()

        var Bonificacion = 0;
        var Refrigerio = 0;
        var Asignacion= 0;
        if (CheckObrero.isChecked){
            Bonificacion = 100;
            Asignacion =120;
        }
        if (CheckEmpleado.isChecked){
            Bonificacion = 150;
            Refrigerio = 200;
            Asignacion = 150;
        }
        if (CheckEjecutivo.isChecked){
            Bonificacion = 250;
            Refrigerio = 250;
            Asignacion = 500
        }

        val PagoTotal = SueldoFinal + Bonificacion + Refrigerio + Asignacion

        val result = """
            Sueldo Base : S/. $Basico
            Bonificacion : S/. $Bonificacion
            Refrigerio : S/. $Refrigerio
            Asignacion : S/. $Asignacion
            Total : S/. $PagoTotal
            
        """.trimIndent()

        TxtResultado.text = result

    }
}