package com.example.a5casospracticos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso2 : AppCompatActivity() {

    private lateinit var editTextNumber: EditText;
    private lateinit var button: Button
    private lateinit var txtResultado:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caso2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        editTextNumber = findViewById(R.id.Ventas)
        txtResultado= findViewById(R.id.resultadotxt)
        button=findViewById(R.id.button)

        button.setOnClickListener {CalcularComision()}

    }
    private fun CalcularComision(){
        val MontoVentas = editTextNumber.text.toString()

        if (MontoVentas.isEmpty()){
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
        return
        }
        val VentasNeto = MontoVentas.toInt()

        var comision:Double = 0.5;
        var bonificacion:Double = 0.0;

        if(VentasNeto<10000){
            comision = 5.0
        }
        if(VentasNeto in 10000..50000){
            comision = 7.5
            bonificacion = 200.0;
        }
        if (VentasNeto >= 50000){
            comision = 9.0;
            bonificacion = 300.0;
        }

        var porcentaje = VentasNeto * (comision/100);
        var ventasComision = VentasNeto * (comision/100) + bonificacion;

        var total = ventasComision + VentasNeto;

        var resultado = """
            Comision: S/.$comision
            Bonificacion: S/. $bonificacion
            Venta : S/.$VentasNeto
            % de venta : S/.$porcentaje
            Total : S/. $total
            
        """.trimIndent()

        txtResultado.text=resultado

    }
}