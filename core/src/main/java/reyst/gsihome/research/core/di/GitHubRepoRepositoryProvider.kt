package reyst.gsihome.research.core.di

import reyst.gsihome.research.core.GitHubRepoRepository

interface GitHubRepoRepositoryProvider {
    fun provideGitHubRepoRepository(): GitHubRepoRepository
}