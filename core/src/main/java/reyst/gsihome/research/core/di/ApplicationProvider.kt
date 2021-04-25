package reyst.gsihome.research.core.di

import android.app.Application

interface ApplicationProvider {
    fun provideApplication(): Application

    fun provideLocalStorageName(): String
}