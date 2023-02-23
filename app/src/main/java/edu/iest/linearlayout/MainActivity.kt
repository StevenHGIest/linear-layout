package edu.iest.linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var bnMultiplicacion : Button? = null
    private var bnDivision : Button? = null
    private var etNumeroPrimero : EditText? = null
    private var etNumeroSegundo : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarVistas()
        asignarEventos()

    }

    /**
     * Asignar los botoners a las variables
     */
    private fun inicializarVistas() {
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        bnMultiplicacion = findViewById(R.id.bnMultiplicacion)
        bnDivision = findViewById(R.id.bnDivision)
        etNumeroPrimero = findViewById(R.id.etNumeroPrimero)
        etNumeroSegundo = findViewById(R.id.etSegdoNumero)
    }

    private fun asignarEventos() {
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
        bnMultiplicacion?.setOnClickListener(this)
        bnDivision?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        try {
            val primero = etNumeroPrimero?.text.toString().toFloat()
            val segundo = etNumeroSegundo?.text.toString().toFloat()
            val aritmetrica = Aritmetrica()

            when (p0?.id) {
                R.id.bnResta -> {

                    val resultado = aritmetrica.resta(primero, segundo)
                    val mensaje = Mensaje(resultado.toString(), this)
                    mensaje.mostrarTosat()
                }

                R.id.bnSuma -> {
                    //Toast.makeText(this, "Hice clickl en resta", Toast.LENGTH_LONG).show()

                    val resultado = aritmetrica.suma(primero, segundo)
                    val mensaje = Mensaje(resultado.toString(), this)
                    mensaje.mostrarSnackbar(p0)
                }

                R.id.bnMultiplicacion -> {
                    val resultado = aritmetrica.multiplicacion(primero, segundo)
                    val mensaje = Mensaje(resultado.toString(), this)
                    mensaje.mostrarSnackbar(p0)
                }

                R.id.bnDivision -> {

                    val resultado = aritmetrica.division(primero, segundo)
                    val mensaje = Mensaje(resultado.toString(), this)
                    mensaje.mostrarTosat()
                }
            }

        } catch (e: Exception) {
            if (p0 != null) {
                Snackbar.make(p0, "Introduce Numeros solamente", Snackbar.LENGTH_INDEFINITE).show()
            }
        }

    }
}

