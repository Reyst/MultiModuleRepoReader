package reyst.gsihome.research.repository.di

import dagger.Component
import reyst.gsihome.research.core.di.ApplicationProvider
import reyst.gsihome.research.core.di.GitHubRepoRepositoryProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class, LocalDataSourceModule::class, RemoteDataSourceModule::class],
    dependencies = [ApplicationProvider::class]
)
interface RepositoryComponent : GitHubRepoRepositoryProvider {

    class Initializer private constructor() {
        companion object {

            fun init(applicationProvider: ApplicationProvider): GitHubRepoRepositoryProvider {

                return DaggerRepositoryComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
            }
        }
    }
}