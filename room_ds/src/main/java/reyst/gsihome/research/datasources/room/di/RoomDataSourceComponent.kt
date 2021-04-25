package reyst.gsihome.research.datasources.room.di

import android.app.Application
import dagger.Component
import reyst.gsihome.research.repository.core.di.LocalDataSourceProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [LocalDataSourceModule::class])
interface RoomDataSourceComponent: LocalDataSourceProvider {

    class Initializer private constructor() {
        companion object {

            fun init(app: Application, dbName: String): LocalDataSourceProvider {
                return DaggerRoomDataSourceComponent.builder()
                    .localDataSourceModule(LocalDataSourceModule(app, dbName))
                    .build()

            }
        }
    }
}