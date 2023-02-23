package edu.iest.linearlayout

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Mensaje (var mensaje: String, var context: Context){
    fun mostrarTosat() {
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
    }

    fun mostrarSnackbar(view: View) {
        Snackbar.make(view, mensaje, Snackbar.LENGTH_INDEFINITE).show()
    }
}