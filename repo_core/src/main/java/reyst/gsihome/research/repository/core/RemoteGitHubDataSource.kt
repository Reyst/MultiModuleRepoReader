package reyst.gsihome.research.repository.core

interface RemoteGitHubDataSource {
    fun getRepoListByUsername(name: String): List<IRepoDto>
}
