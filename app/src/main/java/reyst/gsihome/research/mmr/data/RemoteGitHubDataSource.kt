package reyst.gsihome.research.mmr.data

interface RemoteGitHubDataSource {
    fun getRepoListByUsername(name: String): List<IRepoDto>
}
