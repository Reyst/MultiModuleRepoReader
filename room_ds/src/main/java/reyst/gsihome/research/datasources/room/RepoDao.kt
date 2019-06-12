package reyst.gsihome.research.datasources.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {

    @Query("select * from repo_table where user_name = :username")
    fun getReposByUser(username: String): List<RepoDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Iterable<RepoDb>)

}