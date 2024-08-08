package pe.idat.altaredshop.core.util

open class Evento<out T>(private val contenido: T) {

    var hasBeenHandle = false
        private set

    fun obtenerContenidoSinCambios(): T?{
        return if(hasBeenHandle){
            null
        }else{
            hasBeenHandle = true
            contenido
        }
    }

    fun  obtenerContenido(): T = contenido
}