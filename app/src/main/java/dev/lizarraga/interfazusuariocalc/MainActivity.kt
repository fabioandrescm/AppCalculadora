package dev.lizarraga.interfazusuariocalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import dev.lizarraga.interfazusuariocalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var num1 = 0
    var num2 = 0
    var res = 0
    var operacion = 0
    var resultado = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.igual.setOnClickListener {
            if (operacion != 0) {
                num2 = binding.resultado.text.toString().toInt()    //obtiene el valor del text
                if (operacion == 1) {
                    resultado = num1 + num2
                    binding.resultado.text = "${resultado}"
                } else if (operacion == 2) {
                    resultado = num1 - num2
                    binding.resultado.text = "${resultado}"
                } else if (operacion == 3) {
                    resultado = num1 * num2
                    binding.resultado.text = "${resultado}"
                } else if (operacion == 4) {
                    resultado = num1 / num2
                    binding.resultado.text = "${resultado}"
                } else if (operacion == 0) {
                    binding.resultado.text = null                     //limpia el valor
                }//comprueba que operacion hacer
            }//Comprueba que haya una operacion
            else {
                binding.resultado.text = "0"
            }
        }

    }

    fun numero(v: View) {
        val valorNumerico = findViewById<TextView>(v.id)
        val textNumerico = valorNumerico.text.toString()
        val resultado = "${binding.resultado.text.toString()}${textNumerico}"
        binding.resultado.text = resultado
    }

    fun btnborrar(v: View) {
        val cadena = binding.resultado.text.toString()
        if (cadena.length > 0) {
            binding.resultado.text = "${cadena.substring(1)}"
        }
    }

    override fun onBackPressed() {
        val cadena = binding.resultado.text.toString()
        if (cadena.length > 0) {
            binding.resultado.text = "${cadena.substring(1)}"
        } else {
            super.onBackPressed()
        }

    }

    fun calcular(v: View) {
        if (binding.resultado.text.toString().toInt() > 0) {
            val valorDeOperacion = findViewById<TextView>(v.id)
            if (valorDeOperacion.text.toString() == "+") {
                operacion = 1
            } else if (valorDeOperacion.text.toString() == "-") {
                operacion = 2
            } else if (valorDeOperacion.text.toString() == "X") {
                operacion = 3
            } else if (valorDeOperacion.text.toString() == "/") {
                operacion = 4
            }
        } else {
            operacion = 0  //No hace nada
        }
        num1 = binding.resultado.text.toString().toInt()    //obtiene el valor del text
        binding.resultado.text = null                         //limpia el valor
    }//comprueba que no este a nulo
}

