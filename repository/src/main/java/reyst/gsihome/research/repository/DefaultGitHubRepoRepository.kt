package reyst.gsihome.research.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.core.Repo
import reyst.gsihome.research.repository.core.LocalGitHubDataSource
import reyst.gsihome.research.repository.core.RemoteGitHubDataSource
import javax.inject.Inject

class DefaultGitHubRepoRepository
@Inject constructor(
    private val remote: RemoteGitHubDataSource,
    private val local: LocalGitHubDataSource
) : GitHubRepoRepository {

    override fun getRepoListByUsername(name: String): List<Repo> {

        val list = try {
            remote.getRepoListByUsername(name)
                .also { local.saveRepoList(name, it) }
        } catch (e: Exception) {
            local.getRepoListByUsername(name)
        }

        return list.toDomain()
    }

    override suspend fun getUserRepositories(name: String): Flow<List<Repo>> {
        withContext(Dispatchers.IO) {
            try {
                remote.getRepoListByUsername(name)
                    .also { local.saveRepoList(name, it) }
            } catch (e: Exception) {
            }
        }

        return local.getUserRepositories(name).map { it.toDomain() }
    }

//    fun getUserRepositories1(name: String) = flow<List<Repo>> {
//
//        try {
//            remote.getRepoListByUsername(name)
//                .also { local.saveRepoList(name, it) }
//        } catch (e: Exception) {
//        }
//
//        emit(emptyList())
//
//        local.getUserRepositories(name)
//            .map { it.toDomain() }
//            .collect { emit(it) }
//    }
}
