package pe.idat.altaredshop.auth.domain

import pe.idat.altaredshop.auth.data.network.request.RegistroRequest
import pe.idat.altaredshop.auth.data.network.response.RegistroResponse
import pe.idat.altaredshop.auth.data.repository.AuthRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(
    private val repository: AuthRepository) {

    suspend operator fun invoke(registroRequest: RegistroRequest):
            RegistroResponse{
        return repository.registro(registroRequest)
    }
}