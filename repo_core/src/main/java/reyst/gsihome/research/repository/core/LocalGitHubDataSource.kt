package reyst.gsihome.research.repository.core

interface LocalGitHubDataSource {

    fun getRepoListByUsername(name: String): List<IRepoDto>

    fun saveRepoList(name: String, items: List<IRepoDto>)

}
