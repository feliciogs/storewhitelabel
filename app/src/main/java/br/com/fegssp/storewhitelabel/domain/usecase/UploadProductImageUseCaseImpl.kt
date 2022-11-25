package br.com.fegssp.storewhitelabel.domain.usecase

import android.net.Uri
import br.com.fegssp.storewhitelabel.data.ProductRepository

class UploadProductImageUseCaseImpl(
    private val productRepository: ProductRepository
): UploadProductImageUseCase {

    override suspend fun invoke(imgURI: Uri): String {
        return productRepository.uploadProductImage(imgURI)
    }

}