package reyst.gsihome.research.mmr.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.core.Repo
import javax.inject.Inject

class SearchResultViewModel @Inject constructor(
    private val repository: GitHubRepoRepository
): ViewModel() {

    private val _repoList: MutableLiveData<List<Repo>> = MutableLiveData()

    val repoList: LiveData<List<Repo>>
    get() = _repoList

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun searchRepos1(name: String) {
        uiScope.launch(Dispatchers.IO) {
            val data = repository.getRepoListByUsername(name)
            _repoList.postValue(data)
        }
    }

    fun searchRepos2(name: String) {
        uiScope.launch {
            val data = async(Dispatchers.IO) { repository.getRepoListByUsername(name) }
            _repoList.value = data.await()
        }
    }

    fun searchRepos3(name: String) {
        uiScope.launch {
            val data = withContext(Dispatchers.IO) { repository.getRepoListByUsername(name) }
            _repoList.value = data
        }
    }

    override fun onCleared() {
        viewModelJob.cancel()
        super.onCleared()
    }
}