package reyst.gsihome.research.repository

import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.core.Repo
import javax.inject.Inject

class DefaultGitHubRepoRepository
@Inject constructor(
    private val remote: RemoteGitHubDataSource,
    private val local: LocalGitHubDataSource
) : GitHubRepoRepository {

    override fun getRepoListByUsername(name: String): List<Repo> =
        try {
            remote.getRepoListByUsername(name).also { local.saveRepoList(name, it) }
        } catch (e: Exception) {
            local.getRepoListByUsername(name)
        }
}
