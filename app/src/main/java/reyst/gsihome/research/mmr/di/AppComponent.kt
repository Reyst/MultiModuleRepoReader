package reyst.gsihome.research.mmr.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import reyst.gsihome.research.repository.DefaultGitHubRepoRepository
import reyst.gsihome.research.repository.LocalGitHubDataSource
import reyst.gsihome.research.repository.RemoteGitHubDataSource
import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.mmr.ui.MainActivity
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application = app


    @Singleton
    @Provides
    fun provideGitHubRepository(remote: RemoteGitHubDataSource, local: LocalGitHubDataSource): GitHubRepoRepository =
        DefaultGitHubRepoRepository(remote, local)
}

@Singleton
@Component(modules = [AppModule::class, UIModule::class, RemoteDataSourceModule::class, LocalDataSourceModule::class])
interface AppComponent {

    class Initializer private constructor() {
        companion object {

            fun init(app: Application): AppComponent {
                return DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
            }
        }
    }

    fun inject(activity: MainActivity)
}