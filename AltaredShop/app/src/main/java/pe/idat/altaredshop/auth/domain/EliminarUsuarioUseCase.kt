package pe.idat.altaredshop.auth.domain

import pe.idat.altaredshop.auth.data.repository.UsuarioHomeRepository
import javax.inject.Inject

class EliminarUsuarioUseCase @Inject constructor(
    private val repository: UsuarioHomeRepository
){
    suspend operator fun invoke(){
        return repository.eliminarUsuario()
    }
}