package reyst.gsihome.research.mmr.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [RepoDb::class],
    exportSchema = false
)
abstract class Database: RoomDatabase() {
    abstract fun getRepoDao(): RepoDao
}