package reyst.gsihome.research.mmr.data

import reyst.gsihome.research.mmr.domain.GitHubRepoRepository
import reyst.gsihome.research.mmr.domain.Repo

class DefaultGitHubRepoRepository(
    private val remote: RemoteGitHubDataSource,
    private val local: LocalGitHubDataSource
) : GitHubRepoRepository {


    override suspend fun getRepoListByUsername(name: String): List<Repo> {

        val dtoList: List<IRepoDto> =
            try {
                val tmp = remote.getRepoListByUsername(name)
                local.saveRepoList(name, tmp)
                tmp
            } catch (e: Exception) {
                local.getRepoListByUsername(name)
            }

        return dtoList.toDomain()
    }


}