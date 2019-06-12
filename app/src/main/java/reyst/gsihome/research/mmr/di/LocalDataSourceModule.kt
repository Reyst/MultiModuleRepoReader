package reyst.gsihome.research.mmr.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import reyst.gsihome.research.repository.LocalGitHubDataSource
import reyst.gsihome.research.repository.room.Database
import reyst.gsihome.research.repository.room.RoomDataSource
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): Database {
        return Room.databaseBuilder(application, Database::class.java, "repo_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRoomDataSource(db: Database): LocalGitHubDataSource = RoomDataSource(db)
}