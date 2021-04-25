package reyst.gsihome.research.mmr.ui

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.core.Repo
import javax.inject.Inject

class SearchResultViewModel @Inject constructor(
    private val repository: GitHubRepoRepository
): ViewModel() {

    private val _repoList: MutableLiveData<List<Repo>> = MutableLiveData()

    val repoList: LiveData<List<Repo>>
    get() = _repoList

    fun searchRepos1(name: String) = liveData {
        repository.getUserRepositories(name)
            .collect { emit(it) }
    }

    fun searchRepos2(name: String) {
        viewModelScope.launch {
            val data = async(Dispatchers.IO) { repository.getRepoListByUsername(name) }
            _repoList.value = data.await()
        }
    }

    fun searchRepos3(name: String) {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) { repository.getRepoListByUsername(name) }
            _repoList.value = data
        }
    }
}