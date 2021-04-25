package reyst.gsihome.research.repository.di

import dagger.Component
import reyst.gsihome.research.core.di.ApplicationProvider
import reyst.gsihome.research.core.di.GitHubRepoRepositoryProvider
import reyst.gsihome.research.datasources.retrofit.di.RetrofitDataSourceComponent
import reyst.gsihome.research.datasources.room.di.RoomDataSourceComponent
import reyst.gsihome.research.repository.core.di.LocalDataSourceProvider
import reyst.gsihome.research.repository.core.di.RemoteDataSourceProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class],
    dependencies = [
        ApplicationProvider::class,
        LocalDataSourceProvider::class,
        RemoteDataSourceProvider::class
    ]
)
interface RepositoryComponent : GitHubRepoRepositoryProvider {

    class Initializer private constructor() {
        companion object {

            fun init(applicationProvider: ApplicationProvider): GitHubRepoRepositoryProvider {

                val app = applicationProvider.provideApplication()
                val dbName = applicationProvider.provideLocalStorageName()
                val localDataSourceProvider = RoomDataSourceComponent.Initializer.init(app, dbName)

                val remoteDataSourceProvider = RetrofitDataSourceComponent.Initializer.init()

                return DaggerRepositoryComponent.builder()
                    .applicationProvider(applicationProvider)
                    .localDataSourceProvider(localDataSourceProvider)
                    .remoteDataSourceProvider(remoteDataSourceProvider)
                    .build()
            }
        }
    }
}