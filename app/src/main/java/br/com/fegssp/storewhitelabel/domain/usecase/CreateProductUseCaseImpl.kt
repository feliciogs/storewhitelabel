package br.com.fegssp.storewhitelabel.domain.usecase

import android.net.Uri
import br.com.fegssp.storewhitelabel.data.ProductRepository
import br.com.fegssp.storewhitelabel.domain.model.Product
import java.util.UUID

class CreateProductUseCaseImpl(
    private val uploadProductImageUseCase: UploadProductImageUseCase,
    private val productRepository: ProductRepository
    ) :CreateProductUseCase {

    override suspend fun invoke(description: String, price: Double, imgUri: Uri): Product {
       return try {
            val imgURL = uploadProductImageUseCase(imgUri)
            val product = Product(UUID.randomUUID().toString(),description,price,imgURL)
            productRepository.createProduct(product)
        }catch (e :Exception){
            throw e
        }
    }
}