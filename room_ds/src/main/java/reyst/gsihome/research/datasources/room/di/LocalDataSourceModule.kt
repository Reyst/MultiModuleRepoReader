package reyst.gsihome.research.datasources.room.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import reyst.gsihome.research.datasources.room.Database
import reyst.gsihome.research.datasources.room.RoomDataSource
import reyst.gsihome.research.repository.core.LocalGitHubDataSource
import javax.inject.Singleton

@Module
class LocalDataSourceModule(
    private val application: Application,
    private val dbName: String
) {

    @Singleton
    @Provides
    fun provideDatabase(): Database {
        return Room.databaseBuilder(application, Database::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRoomDataSource(db: Database): LocalGitHubDataSource = RoomDataSource(db)
}