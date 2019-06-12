package reyst.gsihome.research.repository.core

import reyst.gsihome.research.repository.core.IRepoDto

interface LocalGitHubDataSource {

    fun getRepoListByUsername(name: String): List<reyst.gsihome.research.repository.core.IRepoDto>

    fun saveRepoList(name: String, items: List<reyst.gsihome.research.repository.core.IRepoDto>)

}
