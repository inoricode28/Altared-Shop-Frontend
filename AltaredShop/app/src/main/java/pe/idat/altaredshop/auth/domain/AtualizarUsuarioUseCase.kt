package pe.idat.altaredshop.auth.domain

import pe.idat.altaredshop.auth.data.repository.UsuarioHomeRepository
import pe.idat.altaredshop.core.bd.UsuarioEntity
import javax.inject.Inject

class AtualizarUsuarioUseCase @Inject constructor(
    private val repository: UsuarioHomeRepository
) {
    suspend operator fun invoke(usuarioEntity: UsuarioEntity){
        return repository.actualizarUsario(usuarioEntity)
    }
}