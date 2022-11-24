package br.com.fegssp.storewhitelabel.data

import android.net.Uri
import br.com.fegssp.storewhitelabel.domain.model.Product

class ProductRepository(private val dataSource: ProductDataSource) {

    suspend fun getProducts() : List<Product> = dataSource.getProducts()

    suspend fun uploadProductImage(imgUri: Uri): String = dataSource.uploadProductImage(imgUri)

    suspend fun createProduct(product: Product): Product = dataSource.createProduct(product)

}