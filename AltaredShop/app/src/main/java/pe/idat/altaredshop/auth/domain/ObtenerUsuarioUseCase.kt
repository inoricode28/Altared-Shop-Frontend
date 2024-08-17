package pe.idat.altaredshop.auth.domain

import androidx.lifecycle.LiveData
import pe.idat.altaredshop.auth.data.repository.UsuarioHomeRepository
import pe.idat.altaredshop.core.bd.UsuarioEntity
import javax.inject.Inject

class ObtenerUsuarioUseCase @Inject constructor(
    private val repository: UsuarioHomeRepository
){
    operator fun invoke(): LiveData<UsuarioEntity>{
        return repository.obtenerUsuario()
    }
}