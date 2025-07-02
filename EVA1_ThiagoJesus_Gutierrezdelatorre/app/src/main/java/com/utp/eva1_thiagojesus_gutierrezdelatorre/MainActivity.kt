package com.utp.eva1_thiagojesus_gutierrezdelatorre

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get


class MainActivity : AppCompatActivity() {

    private lateinit var nameClient : EditText
    private lateinit var documentClient : EditText
    private lateinit var  typePl : Spinner
    private lateinit var selecctionDelivery : CheckBox
    private lateinit var  selecctionBolsas : CheckBox

    private lateinit var buttonCalcu : Button

    private lateinit var  textShowMenu : TextView
    private lateinit var  textShowBolsas : TextView
    private lateinit var textShowDelevery : TextView
    private lateinit var  textShowTAdicional : TextView

    private lateinit var  textShowTotal : TextView

    private lateinit var  buttonImprimi :Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val productPrices = HashMap<String, Int>()
//        productPrices["Ceviche"] = 18
//        productPrices["Arroz con Pollo"] = 17
//        productPrices["Lomo Saltado"] = 20

        setContentView(R.layout.activity_main)

        nameClient = this.findViewById(R.id.editTextText2)
        documentClient = this.findViewById(R.id.editTextText3)
        typePl = this.findViewById(R.id.spinner)
        selecctionDelivery = this.findViewById(R.id.checkBox)
        selecctionBolsas = this.findViewById(R.id.checkBox2)
        buttonCalcu = this.findViewById(R.id.button)
        textShowMenu = this.findViewById(R.id.textView12)
        textShowBolsas = this.findViewById(R.id.textView13)
        textShowDelevery = this.findViewById(R.id.textView14)
        textShowTAdicional = this.findViewById(R.id.textView15)
        textShowTotal = this.findViewById(R.id.textView19)
        buttonImprimi = this.findViewById(R.id.button2)

        //Action button of
        buttonCalcu.setOnClickListener(View.OnClickListener {
            funcioCalcular()
        })


        buttonImprimi.setOnClickListener {
            val intent = Intent(this, Summary::class.java)

            // Pasar datos a la siguiente actividad
            intent.putExtra("name", nameClient.text.toString())
            intent.putExtra("document", documentClient.text.toString())
            intent.putExtra("type", typePl.selectedItem.toString())
            intent.putExtra("price", textShowMenu.text.toString().toInt())
            intent.putExtra("bolsa", selecctionBolsas.isChecked)
            intent.putExtra("delivery", selecctionDelivery.isChecked)
            intent.putExtra("total", textShowTotal.text.toString().toInt())

            startActivity(intent) // Cambia a Summary
        }

}


    fun funcioCalcular(){
        var  nombre  = nameClient.text
        var  dni = documentClient.text
        var tipoplato = typePl.selectedItem
        var precio = 0
        var precioBolsa = 0
        var precioDelever = 0

        if (tipoplato.equals("Ceviche")){
            precio = 18
        }else if (tipoplato.equals("Arroz con Pollo")){
            precio = 17
        }else if(tipoplato.equals("Lomo Saltado")){
            precio = 20
        }
        if (selecctionDelivery.isChecked){
            precioDelever = 5
        }
        if (selecctionBolsas.isChecked){
            precioBolsa = 1
        }

        textShowMenu.text = precio.toString()
        textShowBolsas.text = precioBolsa.toString()
        textShowDelevery.text = precioDelever.toString()
        textShowTAdicional.text = (precioBolsa + precioDelever).toString()
        textShowTotal.text = (precioBolsa + precio + precioDelever).toString()




        // Log.i("In" , "mENS $tipoplato")
    }



}