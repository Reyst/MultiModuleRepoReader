package reyst.gsihome.research.datasources.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import reyst.gsihome.research.repository.core.IRepoDto

@Entity(tableName = "repo_table", primaryKeys = ["user_name", "id"])
data class RepoDb(

    @ColumnInfo(name = "user_name")
    val user: String,

    override val id: Int,

    override val name: String,

    @ColumnInfo(name = "full_name")
    override val fullName: String

): IRepoDto