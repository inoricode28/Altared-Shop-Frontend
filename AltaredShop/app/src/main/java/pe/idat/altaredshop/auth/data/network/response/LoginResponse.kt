package pe.idat.altaredshop.auth.data.network.response

data class LoginResponse (
    val id:Int,
    val nombre:String,
    val apellido:String,
    val correo:String,
    val celular:String,
    val user:String,
    val pass:String,
    var rpta: Boolean,
    var mensaje:String
)

