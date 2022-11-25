package br.com.fegssp.storewhitelabel.ui.products.addproduct

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fegssp.storewhitelabel.R
import br.com.fegssp.storewhitelabel.domain.usecase.CreateProductUseCase
import br.com.fegssp.storewhitelabel.util.fromCurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val createProductUseCase: CreateProductUseCase
) : ViewModel() {
    private val _imageUriErrorResId = MutableLiveData<Int>()
    val imageUriErrorResId : LiveData<Int> = _imageUriErrorResId

    private val _descriptionErrorResId = MutableLiveData<Int?>()
    val descriptionErrorResId : LiveData<Int?> = _descriptionErrorResId

    private val _priceErrorResId = MutableLiveData<Int>()
    val priceErrorResId : LiveData<Int> = _priceErrorResId

    private var isFormValid = false;

    fun createProduct(description: String, price: String, imgURI: Uri?) = viewModelScope.launch {
        isFormValid = true

        validateValues(description, price, imgURI)

        if(isFormValid){
            try {
                val product = createProductUseCase(description, price.fromCurrency(), imgURI!!)
            }catch (e: java.lang.Exception){
                Log.d("CreateProduct", e.toString())
            }
        }
    }

    private fun getErrorStringResIdIfEmpty(value: String): Int?{
        return if(value.isEmpty()){
            isFormValid = false
            R.string.add_product_field_error
        }else null
    }

    private fun getDrawlableResIdIfEmpty(value: Uri?): Int{
        return if(value == null){
            isFormValid = false
            R.drawable.background_product_image_error
        }else R.drawable.background_product_image
    }

    private fun validateValues(description: String, price: String, imgURI: Uri?){
        _imageUriErrorResId.value = getDrawlableResIdIfEmpty(imgURI)
        _descriptionErrorResId.value = getErrorStringResIdIfEmpty(description)
        _priceErrorResId.value = getErrorStringResIdIfEmpty(price)
    }
}