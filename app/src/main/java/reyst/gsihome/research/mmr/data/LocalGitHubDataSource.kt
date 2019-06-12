package reyst.gsihome.research.mmr.data

interface LocalGitHubDataSource {

    fun getRepoListByUsername(name: String): List<IRepoDto>

    fun saveRepoList(name: String, items: List<IRepoDto>)

}
