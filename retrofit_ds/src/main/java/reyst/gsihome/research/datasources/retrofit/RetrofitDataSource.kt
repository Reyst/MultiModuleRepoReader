package reyst.gsihome.research.datasources.retrofit

import reyst.gsihome.research.repository.core.IRepoDto
import reyst.gsihome.research.repository.core.RemoteGitHubDataSource

class RetrofitDataSource(private val api: Api) : RemoteGitHubDataSource {

    override fun getRepoListByUsername(name: String): List<IRepoDto> {
        val response = api.getRepositories(name).execute()

        return if (response.isSuccessful) response.body() ?: emptyList<RepoDto>()
        else emptyList<RepoDto>()
    }
}