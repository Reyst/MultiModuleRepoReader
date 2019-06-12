package reyst.gsihome.research.repository

import reyst.gsihome.research.repository.IRepoDto

interface LocalGitHubDataSource {

    fun getRepoListByUsername(name: String): List<IRepoDto>

    fun saveRepoList(name: String, items: List<IRepoDto>)

}
