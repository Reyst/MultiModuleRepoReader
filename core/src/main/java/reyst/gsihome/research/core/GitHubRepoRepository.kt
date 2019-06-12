package reyst.gsihome.research.core

import androidx.annotation.WorkerThread

interface GitHubRepoRepository {

    @WorkerThread
    fun getRepoListByUsername(name: String) : List<Repo>

}