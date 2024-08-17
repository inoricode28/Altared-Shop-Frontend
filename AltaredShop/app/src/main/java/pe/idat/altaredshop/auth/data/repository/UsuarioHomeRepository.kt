package pe.idat.altaredshop.auth.data.repository

import androidx.lifecycle.LiveData
import pe.idat.altaredshop.core.bd.UsuarioDao
import pe.idat.altaredshop.core.bd.UsuarioEntity
import javax.inject.Inject

class UsuarioHomeRepository @Inject constructor(
    private val usuarioDao: UsuarioDao
){
    suspend fun actualizarUsario(usuarioEntity: UsuarioEntity){
        usuarioDao.actualizarUsuario(usuarioEntity)
    }

    suspend fun eliminarUsuario(){
        usuarioDao.eliminarUsuario()
    }

    fun obtenerUsuario():LiveData<UsuarioEntity>{
        return usuarioDao.obtenerUsuario()
    }
}