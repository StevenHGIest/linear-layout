package edu.iest.linearlayout


class Aritmetrica {
     fun suma(n1: Float, n2: Float): Float {
        return n1 + n2
    }

    fun resta(n1: Float, n2: Float): Float {
        return n1 - n2
    }

    fun multiplicacion(n1: Float, n2: Float): Float {
        return n1 * n2
    }

    fun division(n1: Float, n2: Float): Float {
        if (n1 == 0F && n2 == 0F) {
            return 0.0F
        }
        return n1 / n2
    }


}