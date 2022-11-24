package br.com.fegssp.storewhitelabel.data

import android.net.Uri
import br.com.fegssp.storewhitelabel.domain.model.Product

interface ProductDataSource {

    suspend fun getProducts() : List<Product>
    suspend fun uploadProductImage(imgUri: Uri): String
    suspend fun createProduct(product: Product):Product
}