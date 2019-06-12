package reyst.gsihome.research.mmr

import android.app.Application
import reyst.gsihome.research.mmr.di.AppComponent

class ReaderApp: Application() {

    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this) }

}