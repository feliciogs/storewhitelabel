package br.com.fegssp.storewhitelabel.data.di


import br.com.fegssp.storewhitelabel.data.FirebaseProductDataSource
import br.com.fegssp.storewhitelabel.data.ProductDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindCProductDataSource(dataSource: FirebaseProductDataSource): ProductDataSource
}