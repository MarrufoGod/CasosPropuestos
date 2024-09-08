package com.example.a5casospracticos

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso3 : AppCompatActivity() {
        private lateinit var NombreObrero:EditText;
        private  lateinit var HorasTrabajadas:EditText;
        private lateinit var CheckBoxPintado:CheckBox;
        private lateinit var CheckBoxLaqueado:CheckBox;
        private lateinit var CheckBoxBarnizado:CheckBox;
        private  lateinit var ButtonCalcular: Button;
        private lateinit var TxtResultado:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso3)

        NombreObrero = findViewById(R.id.txtNombreObrero);
        HorasTrabajadas = findViewById(R.id.txtHorasTrabajadas);
        CheckBoxPintado = findViewById(R.id.checkBoxPintado);
        CheckBoxLaqueado = findViewById(R.id.checkBoxLaqueado);
        CheckBoxBarnizado = findViewById(R.id.checkBoxBarnizado);
        ButtonCalcular = findViewById(R.id.buttonCalcular);
        TxtResultado = findViewById(R.id.txtResultado);

        ButtonCalcular.setOnClickListener{CalcularJornada()}

    }

    private  fun CalcularJornada(){
        val N_Obrero = NombreObrero.text.toString()
        val H_Trabajadas = HorasTrabajadas.text.toString()
        if (N_Obrero.isEmpty() || H_Trabajadas.isEmpty() ){
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
        }

        val nombre = N_Obrero;
        val horas = H_Trabajadas.toInt()
        var servicio = 0;
        var extra = 0.0;

        if (CheckBoxPintado.isChecked){
            servicio = 10;
        }
        if (CheckBoxLaqueado.isChecked){
            servicio = 12;
        }
        if (CheckBoxBarnizado.isChecked){
            servicio = 14;
        }

         if(horas > 40){
             extra = 30.0
         }


        val JornadaSemanal = horas * servicio;
        val JornadaExtra = JornadaSemanal *(extra/100)
        val JornadaTotal = JornadaExtra + JornadaSemanal;

        val result = """
            
            Jornada Semanal : $JornadaSemanal
            Jornada Extra : $JornadaExtra
            Jornada Total : $JornadaTotal
            
            
        """.trimIndent()

             TxtResultado.text = result

    }

}