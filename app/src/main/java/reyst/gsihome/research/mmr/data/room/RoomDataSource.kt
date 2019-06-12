package reyst.gsihome.research.mmr.data.room

import reyst.gsihome.research.mmr.data.IRepoDto
import reyst.gsihome.research.mmr.data.LocalGitHubDataSource

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