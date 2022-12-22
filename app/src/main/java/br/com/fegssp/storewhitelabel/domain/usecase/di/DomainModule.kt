package br.com.fegssp.storewhitelabel.domain.usecase.di

import br.com.fegssp.storewhitelabel.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateProductUseCase(useCaseImpl: CreateProductUseCaseImpl): CreateProductUseCase

    @Binds
    fun bindGetProductUseCase(useCaseImpl: GetProductsUseCaseImpl): GetProductsUseCase

    @Binds
    fun bindUploadImageUseCase(useCaseImpl: UploadProductImageUseCaseImpl): UploadProductImageUseCase
}