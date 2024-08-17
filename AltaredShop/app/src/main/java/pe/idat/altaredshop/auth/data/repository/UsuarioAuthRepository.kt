package pe.idat.altaredshop.auth.data.repository

import pe.idat.altaredshop.core.bd.UsuarioDao
import pe.idat.altaredshop.core.bd.UsuarioEntity
import javax.inject.Inject

class UsuarioAuthRepository @Inject constructor(
    private val usuarioDao: UsuarioDao
){
    suspend fun insertarUsuario(usuarioEntity: UsuarioEntity){
        usuarioDao.insertarUsuario(usuarioEntity)
    }
}