package reyst.gsihome.research.repository.core

import kotlinx.coroutines.flow.Flow

interface LocalGitHubDataSource {

    fun getRepoListByUsername(name: String): List<IRepoDto>
    fun getUserRepositories(name: String): Flow<List<IRepoDto>>

    fun saveRepoList(name: String, items: List<IRepoDto>)

}
