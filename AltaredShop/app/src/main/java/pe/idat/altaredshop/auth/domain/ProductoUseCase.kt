package pe.idat.altaredshop.auth.domain

import pe.idat.altaredshop.auth.data.network.response.ProductoResponse
import pe.idat.altaredshop.auth.data.repository.AuthRepository
import javax.inject.Inject

class ProductoUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): List<ProductoResponse>{
        return authRepository.listarProducto()
    }
}