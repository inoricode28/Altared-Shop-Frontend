package pe.idat.altaredshop.auth.domain

import pe.idat.altaredshop.auth.data.repository.UsuarioAuthRepository
import pe.idat.altaredshop.core.bd.UsuarioEntity
import javax.inject.Inject

class RegistroUsuarioUseCase @Inject constructor(
    private val repository: UsuarioAuthRepository
){
    suspend operator fun invoke(usuarioEntity: UsuarioEntity){
        return repository.insertarUsuario(usuarioEntity)
    }
}