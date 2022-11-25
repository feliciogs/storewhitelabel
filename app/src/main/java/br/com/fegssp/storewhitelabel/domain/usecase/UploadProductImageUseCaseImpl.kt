package br.com.fegssp.storewhitelabel.domain.usecase

import android.net.Uri
import br.com.fegssp.storewhitelabel.data.ProductRepository
import javax.inject.Inject

class UploadProductImageUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
): UploadProductImageUseCase {

    override suspend fun invoke(imgURI: Uri): String {
        return productRepository.uploadProductImage(imgURI)
    }

}