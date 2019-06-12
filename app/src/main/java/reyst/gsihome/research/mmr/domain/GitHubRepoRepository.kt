package reyst.gsihome.research.mmr.domain

interface GitHubRepoRepository {

    suspend fun getRepoListByUsername(name: String) : List<Repo>

}