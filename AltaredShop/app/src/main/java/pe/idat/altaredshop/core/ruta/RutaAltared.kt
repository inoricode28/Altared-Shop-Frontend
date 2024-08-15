package pe.idat.altaredshop.core.ruta

sealed class RutaAltared(val path:String) {
    object loginScreen : RutaAltared("loginScreen")
    object registroScreen : RutaAltared("registroScreen")
    object homeScreen : RutaAltared("homeScreen")
    object productoScreen : RutaAltared("productoScreen")
    object splashScreen : RutaAltared("splashScreen")
    object getstartedScreen : RutaAltared("getstartedScreen")
    object perfilScreen : RutaAltared("perfilScreen")
    object pagoScreen : RutaAltared("pagoScreen")
}