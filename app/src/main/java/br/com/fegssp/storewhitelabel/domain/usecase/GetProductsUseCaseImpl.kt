package br.com.fegssp.storewhitelabel.domain.usecase

import br.com.fegssp.storewhitelabel.data.ProductRepository
import br.com.fegssp.storewhitelabel.domain.model.Product
import javax.inject.Inject

class GetProductsUseCaseImpl @Inject constructor(
    val productRepository: ProductRepository
    ):GetProductsUseCase {

    override suspend fun invoke(): List<Product> {
        return productRepository.getProducts()
    }
}