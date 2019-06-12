package reyst.gsihome.research.repository.retrofit

import reyst.gsihome.research.repository.core.IRepoDto
import reyst.gsihome.research.repository.core.RemoteGitHubDataSource

class RetrofitDataSource(private val api: Api) : reyst.gsihome.research.repository.core.RemoteGitHubDataSource {

    //    private val api = retrofit.create(Api::class.java)

    override fun getRepoListByUsername(name: String): List<reyst.gsihome.research.repository.core.IRepoDto> {
        val response = api.getRepositories(name).execute()

        return if (response.isSuccessful) response.body() ?: emptyList<RepoDto>()
        else emptyList<RepoDto>()
    }

}