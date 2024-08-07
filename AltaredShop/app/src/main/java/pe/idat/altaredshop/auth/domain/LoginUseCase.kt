package pe.idat.altaredshop.auth.domain

import pe.idat.altaredshop.auth.data.network.request.LoginRequest
import pe.idat.altaredshop.auth.data.network.response.LoginResponse
import pe.idat.altaredshop.auth.data.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
        private val authRepository: AuthRepository) {

        suspend operator fun invoke(loginRequest: LoginRequest)
                    : LoginResponse{
            return authRepository.login(loginRequest)
        }
}