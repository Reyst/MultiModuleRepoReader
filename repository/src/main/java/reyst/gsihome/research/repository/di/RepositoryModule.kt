package reyst.gsihome.research.repository.di

import dagger.Binds
import dagger.Module
import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.repository.DefaultGitHubRepoRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(repository: DefaultGitHubRepoRepository): GitHubRepoRepository
}