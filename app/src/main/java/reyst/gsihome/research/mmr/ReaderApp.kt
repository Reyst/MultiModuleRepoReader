package reyst.gsihome.research.mmr

import android.app.Application
import reyst.gsihome.research.core.di.ApplicationProvider
import reyst.gsihome.research.mmr.di.AppComponent

class ReaderApp: Application(), ApplicationProvider {

    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this) }

    override fun provideApplication(): Application = this

    override fun provideLocalStorageName(): String = "github_repos_db"

}