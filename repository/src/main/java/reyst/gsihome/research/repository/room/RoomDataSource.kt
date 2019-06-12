package reyst.gsihome.research.repository.room

import reyst.gsihome.research.repository.IRepoDto
import reyst.gsihome.research.repository.LocalGitHubDataSource

class RoomDataSource(
    private val db: Database
): LocalGitHubDataSource {

    override fun getRepoListByUsername(name: String): List<IRepoDto> {
        return db.getRepoDao().getReposByUser(name)
    }

    override fun saveRepoList(name: String, items: List<IRepoDto>) {
        db.getRepoDao().insert(
            items.map {
                RepoDb(
                    name,
                    it.id,
                    it.name,
                    it.fullName
                )
            }
        )
    }
}