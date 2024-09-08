package com.example.a5casospracticos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    //metodos para cada caso

    //Metodo para el caso 1
    fun problema1(view: View) {
        // Aquí se define el intent para cambiar de actividad
        val intent = Intent(this, Caso1::class.java)
        startActivity(intent)
    }
    //Metodo para el caso 2
    fun problema2(view: View) {
        // Aquí se define el intent para cambiar de actividad
        val intent = Intent(this, Caso2::class.java)
        startActivity(intent)
    }
    //Metodo para el caso 3
    fun problema3(view: View) {
        // Aquí se define el intent para cambiar de actividad
        val intent = Intent(this, Caso3::class.java)
        startActivity(intent)
    }
    //Metodo para el caso 4
    fun problema4(view: View) {
        // Aquí se define el intent para cambiar de actividad
        val intent = Intent(this, Caso4::class.java)
        startActivity(intent)
    }
    //Metodo para el caso 5
    fun problema5(view: View) {
        // Aquí se define el intent para cambiar de actividad
        val intent = Intent(this, Caso5::class.java)
        startActivity(intent)
    }
}