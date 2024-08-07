package pe.idat.altaredshop.core.ruta

sealed class RutaAltared(val path:String) {
    object loginScreen : RutaAltared("loginScreen")
    object registroScreen : RutaAltared("registroScreen")
    object catalogoScreen : RutaAltared("catalogoScreen")
}