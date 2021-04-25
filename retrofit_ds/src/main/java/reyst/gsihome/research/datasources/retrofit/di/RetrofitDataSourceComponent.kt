package reyst.gsihome.research.datasources.retrofit.di

import dagger.Component
import reyst.gsihome.research.repository.core.di.RemoteDataSourceProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitDataSourceModule::class])
interface RetrofitDataSourceComponent: RemoteDataSourceProvider {
    class Initializer private constructor() {
        companion object {
            fun init(): RemoteDataSourceProvider {
                return DaggerRetrofitDataSourceComponent.create()
            }
        }
    }
}