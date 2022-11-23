package br.com.fegssp.storewhitelabel.domain.usecase

import android.net.Uri
import br.com.fegssp.storewhitelabel.domain.model.Product

interface CreateProductUseCase {

    suspend operator fun invoke(description: String, price: Double, imgUri: Uri): Product
}