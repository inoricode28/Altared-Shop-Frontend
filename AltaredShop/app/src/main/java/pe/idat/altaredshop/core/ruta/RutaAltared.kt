package pe.idat.altaredshop.core.ruta

sealed class RutaAltared(val path:String) {
    object loginScreen : RutaAltared("loginScreen")
    object registroScreen : RutaAltared("registroScreen")
    object homeScreen : RutaAltared("homeScreen")
    object productoScreen : RutaAltared("productoScreen")
    object splashScreen : RutaAltared("splashScreen")
    object getstartedScreen : RutaAltared("getStartedScreen")
    object perfilScreen : RutaAltared("perfilScreen")
    object pagoScreen : RutaAltared("pagoScreen")
    object ErroneaScreen : RutaAltared("ErroneaScreen")
    object ExitosaScreen : RutaAltared("ExitosaScreen")
    object bienvenidaScreen : RutaAltared("bienvenidaScreen")
    object selectLogScreen : RutaAltared("selectLogScreen")

}