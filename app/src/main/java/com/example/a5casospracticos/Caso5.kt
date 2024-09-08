package com.example.a5casospracticos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso5 : AppCompatActivity() {


    private lateinit var CheckAdidas:CheckBox;
    private lateinit var CheckNike:CheckBox;
    private lateinit var CheckBoxFila:CheckBox;
    private lateinit var txtPares:EditText;
    private  lateinit var Checkt38:CheckBox;
    private  lateinit var Checkt40:CheckBox;
    private  lateinit var Checkt42:CheckBox;
    private  lateinit var ButtonCalcular:Button;
    private  lateinit var TxtResultado:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caso5)

        CheckAdidas = findViewById(R.id.checkBoxAdidas)
        CheckNike = findViewById(R.id.checkBoxNike)
        CheckBoxFila = findViewById(R.id.checkBoxFila)
        txtPares = findViewById(R.id.txtPares)
        Checkt38= findViewById(R.id.checkBoxTalla38)
        Checkt40= findViewById(R.id.checkBoxTalla40)
        Checkt42= findViewById(R.id.checkBoxTalla42)
        ButtonCalcular = findViewById(R.id.button10)
        TxtResultado = findViewById(R.id.textViewResultado)

        ButtonCalcular.setOnClickListener{CalcularVenta()}

    }

    private fun CalcularVenta(){

        val CPares = txtPares.text.toString();

        if (CPares.isEmpty())
        {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
        return
        }

        val pares = CPares.toInt();
        var talla = arrayOf(0, 0, 0);
        val t38 = arrayOf(150,140,80)
        val t40 = arrayOf(160,150,85)
        val t42 = arrayOf(160,150,90)
        var Nmarca = 0

                //identificar marca
        if (CheckNike.isChecked){
            Nmarca = 0
        }
        if (CheckAdidas.isChecked){
            Nmarca = 1
        }
        if (CheckBoxFila.isChecked){
            Nmarca = 2
        }

            //identificar talla
         if(Checkt38.isChecked){
             talla = t38
         }
        if(Checkt40.isChecked){
            talla = t40
        }
        if(Checkt42.isChecked){
            talla = t42
        }


    //Descuentos por par

        var descuento =0
        if (pares in 2..5){
            descuento = 5
        }
        if (pares in 6..10){
            descuento = 8
        }
        if (pares in 11..20){
            descuento = 10
        }
        if (pares>20){
            descuento = 15
        }

        //calcular precios

        val preciototal = talla[Nmarca] * pares;
        var porcentaje = descuento/100.0
        var montodescontar = preciototal * porcentaje;

        var  preciofinal = preciototal - montodescontar;



        var result = """
            Descuento : %$descuento
            Pares : $pares
            Precio total = $preciototal
            Descuento: S/.$montodescontar
            Precio Final : S/.$preciofinal
        """.trimIndent()

        TxtResultado.text = result;
    }
}