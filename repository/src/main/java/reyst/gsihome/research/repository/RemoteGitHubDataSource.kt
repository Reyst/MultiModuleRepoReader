package reyst.gsihome.research.repository

import reyst.gsihome.research.repository.IRepoDto

interface RemoteGitHubDataSource {
    fun getRepoListByUsername(name: String): List<IRepoDto>
}
