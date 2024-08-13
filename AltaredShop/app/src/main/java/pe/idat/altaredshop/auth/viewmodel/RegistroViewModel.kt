package pe.idat.altaredshop.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.altaredshop.auth.data.network.request.RegistroRequest
import pe.idat.altaredshop.auth.data.network.response.RegistroResponse
import pe.idat.altaredshop.auth.domain.RegistroUseCase
import pe.idat.altaredshop.core.util.Evento
import javax.inject.Inject

@HiltViewModel
class RegistroViewModel @Inject constructor(
    private val registroUseCase: RegistroUseCase): ViewModel() {

        private  val _nombre = MutableLiveData<String>()
        val nombre : MutableLiveData<String> = _nombre

        private  val _apellido = MutableLiveData<String>()
        val apellido : MutableLiveData<String> = _apellido

        private  val _correo = MutableLiveData<String>()
        val correo : MutableLiveData<String> = _correo

        private  val _celular = MutableLiveData<String>()
        val celular : MutableLiveData<String> = _celular

        private  val _user = MutableLiveData<String>()
        val user : MutableLiveData<String> = _user

        private  val _pass = MutableLiveData<String>()
        val pass : MutableLiveData<String> = _pass


        private val _registroResponse = MutableLiveData<Evento<RegistroResponse>>()
        val registroResponse: LiveData<Evento<RegistroResponse>> = _registroResponse

        fun onRegistroChanged(
             nombre:String,
             apellido:String,
             correo:String,
             celular:String,
             user:String,
             pass:String
        ){
            _nombre.value = nombre
            _apellido.value = apellido
            _correo.value = correo
            _celular.value = celular
            _user.value = user
            _pass.value = pass

        }
    fun setearFormularioRegistro(){
        _nombre.value = ""
        _apellido.value = ""
        _correo.value = ""
        _celular.value = ""
        _user.value = ""
        _pass.value = ""
    }

    fun registrarUsuario(){
       viewModelScope.launch {
           val response = registroUseCase(
               RegistroRequest(
                   nombre.value!!,
                   apellido.value!!,
                   correo.value!!,
                   celular.value!!,
                   user.value!!,
                   pass.value!!
                   )
           )
           _registroResponse.value =Evento(response)
       }
    }


}


