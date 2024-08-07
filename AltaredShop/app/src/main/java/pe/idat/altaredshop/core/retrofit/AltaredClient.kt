package pe.idat.altaredshop.core.retrofit

import pe.idat.altaredshop.auth.data.network.request.LoginRequest
import pe.idat.altaredshop.auth.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface AltaredClient {

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest):
            Response<LoginResponse>

}