package br.com.fegssp.storewhitelabel.domain.usecase

import android.net.Uri

interface UploadProductImageUseCase {

    suspend operator fun invoke(imgURI: Uri): String
}