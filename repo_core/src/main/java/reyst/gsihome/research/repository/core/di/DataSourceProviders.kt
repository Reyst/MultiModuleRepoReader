package reyst.gsihome.research.repository.core.di

import reyst.gsihome.research.repository.core.LocalGitHubDataSource
import reyst.gsihome.research.repository.core.RemoteGitHubDataSource

interface LocalDataSourceProvider {
    fun provideLocalGitHubDataSource(): LocalGitHubDataSource
}

interface RemoteDataSourceProvider {
    fun provideRemoteGitHubDataSource(): RemoteGitHubDataSource
}