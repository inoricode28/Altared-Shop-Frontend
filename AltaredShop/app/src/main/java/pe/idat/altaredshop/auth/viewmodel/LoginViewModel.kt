package pe.idat.altaredshop.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.altaredshop.auth.data.network.request.LoginRequest
import pe.idat.altaredshop.auth.data.network.response.LoginResponse
import pe.idat.altaredshop.auth.domain.LoginUseCase
import pe.idat.altaredshop.auth.domain.RegistroUsuarioUseCase
import pe.idat.altaredshop.core.bd.UsuarioEntity
import pe.idat.altaredshop.core.util.Evento
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registroUsuarioUseCase: RegistroUsuarioUseCase) : ViewModel(){

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> = _usuario

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _botonLoginHabilitado = MutableLiveData<Boolean>()
    val botonLoginHabilitado : LiveData<Boolean> = _botonLoginHabilitado
    private val _loginResponse = MutableLiveData<Evento<LoginResponse>>()
    val loginResponse: LiveData<Evento<LoginResponse>> = _loginResponse


    fun onValueChange(usuario: String, password:String){
        _usuario.value = usuario
        _password.value = password
        _botonLoginHabilitado.value = habilitarBotonLogin(usuario,password)
    }

    fun loginUsuarioPassword(){
        viewModelScope.launch {
            val response = loginUseCase(
                LoginRequest(usuario.value!!, password.value!!)
            )
            _loginResponse.value = Evento(response)

            registroUsuarioUseCase(UsuarioEntity(
                response.id.toInt(),
                response.nombre,
                response.apellido,
                response.correo,
                response.celular,
                response.user,
                response.pass
            ))


        }

    }


    fun habilitarBotonLogin(usuario: String,password: String) = usuario.length > 2
            && password.length >2

}