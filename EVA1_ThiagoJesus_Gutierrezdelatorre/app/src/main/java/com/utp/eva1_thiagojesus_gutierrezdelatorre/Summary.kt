package com.utp.eva1_thiagojesus_gutierrezdelatorre

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Summary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        // Referencias a los elementos de la UI
        val nameTextView = findViewById<TextView>(R.id.textView17)
        val documentTextView = findViewById<TextView>(R.id.textView21)
        val typeTextView = findViewById<TextView>(R.id.textView23)
        val priceTextView = findViewById<TextView>(R.id.textView25)
        val bolsaTextView = findViewById<TextView>(R.id.textView27)
        val deliveryTextView = findViewById<TextView>(R.id.textView29)
        val totalTextView = findViewById<TextView>(R.id.textView33)
        val imagen = findViewById<ImageView>(R.id.imageView)

        // Obtener los datos desde el Intent
        val extras = intent.extras
        if (extras != null) {
            nameTextView.text = extras.getString("name", "")
            documentTextView.text = extras.getString("document", "")
            typeTextView.text = extras.getString("type", "")
            priceTextView.text = extras.getInt("price").toString()
            bolsaTextView.text = if (extras.getBoolean("bolsa")) "Sí" else "No"
            deliveryTextView.text = if (extras.getBoolean("delivery")) "Sí" else "No"
            totalTextView.text = extras.getInt("total").toString()
        }

        // Cambiar la imagen según el plato seleccionado
        val imageResource = when (extras?.getString("type")) {
            "Ceviche" -> R.drawable.ceviche
            "Arroz con Pollo" -> R.drawable.arrozconpollo
            "Lomo Saltado" -> R.drawable.lomo
            else -> R.drawable.ceviche
        }

        imagen.setImageResource(imageResource)

        // Botón para volver a MainActivity
        findViewById<Button>(R.id.button3).setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
            finish() // Cierra `Summary` para evitar acumulación en la pila de actividades
        }
    }
}