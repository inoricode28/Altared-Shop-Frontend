package pe.idat.altaredshop.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.altaredshop.auth.data.network.response.ProductoResponse
import pe.idat.altaredshop.auth.domain.ProductoUseCase
import javax.inject.Inject


@HiltViewModel
class ProductoViewModel @Inject constructor(
    private val productoUseCase: ProductoUseCase
): ViewModel(){
    private val _productoResponse = MutableLiveData<List<ProductoResponse>>()
    val ProductoResponse: LiveData<List<ProductoResponse>> = _productoResponse

    init {
        listarProducto()
    }

    fun listarProducto(){
        viewModelScope.launch {
            val response = productoUseCase()
            _productoResponse.value = response
        }
    }

}