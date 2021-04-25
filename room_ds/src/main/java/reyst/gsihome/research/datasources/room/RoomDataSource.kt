package reyst.gsihome.research.datasources.room

import reyst.gsihome.research.repository.core.IRepoDto
import reyst.gsihome.research.repository.core.LocalGitHubDataSource

class RoomDataSource(
    private val db: Database
) : LocalGitHubDataSource {

    override fun getRepoListByUsername(name: String): List<IRepoDto> {
        return db.getRepoDao().getReposByUser(name)
    }

    override fun saveRepoList(name: String, items: List<IRepoDto>) {
        val entities = items.map { RepoDb(name, it.id, it.name, it.fullName) }
        db.getRepoDao().insert(entities)
    }
}