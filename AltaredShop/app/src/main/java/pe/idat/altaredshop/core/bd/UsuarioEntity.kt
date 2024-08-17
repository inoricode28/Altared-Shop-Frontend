package pe.idat.altaredshop.core.bd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey
    var id: Int,
    var nombre:String,
    var apellido:String,
    val correo:String,
    var celular:String,
    val user:String,
    val pass:String
)
