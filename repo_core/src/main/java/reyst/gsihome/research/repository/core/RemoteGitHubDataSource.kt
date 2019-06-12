package reyst.gsihome.research.repository.core

import reyst.gsihome.research.repository.core.IRepoDto

interface RemoteGitHubDataSource {
    fun getRepoListByUsername(name: String): List<reyst.gsihome.research.repository.core.IRepoDto>
}
