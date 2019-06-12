package reyst.gsihome.research.mmr.data.retrofit

import reyst.gsihome.research.mmr.data.IRepoDto
import reyst.gsihome.research.mmr.data.RemoteGitHubDataSource

class RetrofitDataSource(private val api: Api) : RemoteGitHubDataSource {

    //    private val api = retrofit.create(Api::class.java)

    override fun getRepoListByUsername(name: String): List<IRepoDto> {
        val response = api.getRepositories(name).execute()

        return if (response.isSuccessful) response.body() ?: emptyList<RepoDto>()
        else emptyList<RepoDto>()
    }

}