package reyst.gsihome.research.mmr.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import reyst.gsihome.research.core.di.ApplicationProvider
import reyst.gsihome.research.core.di.GitHubRepoRepositoryProvider
import reyst.gsihome.research.mmr.ui.MainActivity
import reyst.gsihome.research.repository.di.RepositoryComponent
import javax.inject.Singleton

@Module
class AppModule(private val appProvider: ApplicationProvider) {

    @Singleton
    @Provides
    fun provideApplication(): Application = appProvider.provideApplication()

}

@Singleton
@Component(
    modules = [AppModule::class, UIModule::class],
    dependencies = [GitHubRepoRepositoryProvider::class]

)
interface AppComponent {

    class Initializer private constructor() {
        companion object {

            fun init(app: ApplicationProvider): AppComponent {

                val repoProvider = RepositoryComponent.Initializer.init(app)

                return DaggerAppComponent.builder()
                    .gitHubRepoRepositoryProvider(repoProvider)
                    .build()
            }
        }
    }

    fun inject(activity: MainActivity)
}