package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val btnGenerate = findViewById<Button>(R.id.generar)
        val btnBorrar = findViewById<Button>(R.id.borrar)
        val name = findViewById<EditText>(R.id.nombre)
        val apellidoPat = findViewById<EditText>(R.id.apellidosP)
        val apellidoMat = findViewById<EditText>(R.id.apellidosM)


        val valores = mutableListOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "X",
            "Y",
            "Z",
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9"
        )

        date.setOnClickListener {
            val datePicker = DatePickerFragment { day, month, year ->
                var mes = (month + 1).toString()
                if (mes.toInt() < 10) {
                    mes = "0" + mes
                }
                var dia = (day).toString()
                if (dia.toInt() < 10) {
                    dia = "0" + dia
                }
                date.setText("" + dia + "/" + (mes) + "/" + year)
            }
            datePicker.show(supportFragmentManager, "datePicker")
        }

        //Calcular RFC
        btnGenerate.setOnClickListener {
            var apellidoP = apellidoPat.text.toString()
            var apellidoM = apellidoMat.text.toString()
            var nombre = name.text.toString()
            var fecha = date.text.toString()

            /*var dia = spDia.toString()
            var dia = date.toString()

            //var mes = spMes.toString()
            var mes = date.toString()

            //var anio = spAnio.toString()
            var year = date.toString()*/

            var aP = apellidoP[0].toString()
            var aM = apellidoM[0].toString() + apellidoM[1].toString()
            var nm = nombre[0].toString()
            var an1 = fecha[8]
            var an2 = fecha[9]
            var m = fecha [3]
            var m2 = fecha [4]
            var d = fecha [0]
            var d1 = fecha [1]
            val hmc1 = valores.random()
            val hmc2 = valores.random()
            val hmc3 = valores.random()

            var caracteres = aP + aM + nm + an1 + an2 + m +m2 + d + d1+ hmc1 + hmc2 + hmc3

            var rfcResult = findViewById<TextView>(R.id.txtRfc)
            rfcResult.text = caracteres

        }

        btnBorrar.setOnClickListener{
            name.setText("")
            apellidoPat.setText("")
            apellidoMat.setText("")
            date.setText("")
        }

    }
}
