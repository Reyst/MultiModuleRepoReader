package reyst.gsihome.research.datasources.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Call<List<RepoDto>>

}