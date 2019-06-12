package reyst.gsihome.research.mmr.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import reyst.gsihome.research.mmr.ui.SearchResultViewModel
import javax.inject.Singleton

@Module
abstract class UIModule {

    @Singleton
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchResultViewModel::class)
    internal abstract fun getSearchResultViewModel(viewModel: SearchResultViewModel): ViewModel

}