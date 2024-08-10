package pe.idat.altaredshop.auth.data.network.request

data class RegistroRequest(
    var nombre:String,
    var apellido:String,
    val correo:String,
    var celular:String,
    val user:String,
    val pass:String
)
