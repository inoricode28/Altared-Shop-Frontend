package pe.idat.altaredshop.auth.data.network.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.idat.altaredshop.auth.data.network.request.LoginRequest
import pe.idat.altaredshop.auth.data.network.request.RegistroRequest
import pe.idat.altaredshop.auth.data.network.response.LoginResponse
import pe.idat.altaredshop.auth.data.network.response.ProductoResponse
import pe.idat.altaredshop.auth.data.network.response.RegistroResponse
import pe.idat.altaredshop.core.retrofit.AltaredClient

import javax.inject.Inject

class AuthService @Inject
        constructor(private val altaredClient: AltaredClient){

    suspend fun login(loginRequest: LoginRequest): LoginResponse{
        return withContext(Dispatchers.IO){
            val response = altaredClient.login(loginRequest)
            response.body()!!
        }
    }

    suspend fun registro(request: RegistroRequest): RegistroResponse{
        return withContext(Dispatchers.IO){
            val response = altaredClient.registro(request)
            response.body()!!
        }
    }

    suspend fun listarProducto(): List<ProductoResponse>{
        return withContext(Dispatchers.IO){
            val response= altaredClient.listarProduto()
            response.body()!!
        }
    }
}

