package br.com.fegssp.storewhitelabel.domain.usecase

import br.com.fegssp.storewhitelabel.domain.model.Product

interface GetProductsUseCase {

    suspend operator fun invoke(): List<Product>
}