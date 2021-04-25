package reyst.gsihome.research.core

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

interface GitHubRepoRepository {

    @WorkerThread
    fun getRepoListByUsername(name: String) : List<Repo>
    suspend fun getUserRepositories(name: String): Flow<List<Repo>>

}