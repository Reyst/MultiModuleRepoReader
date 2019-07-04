package reyst.gsihome.research.mmr.ui

import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import reyst.gsihome.research.core.GitHubRepoRepository
import reyst.gsihome.research.core.Repo
import reyst.gsihome.research.repository.GitHubRepo
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

@ExperimentalCoroutinesApi
class SearchResultViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        // provide the scope explicitly, in this example using a constructor parameter
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }


    @Test
    fun `should call repository and get list with two elements 1`() {

        val response = listOf(
            GitHubRepo(1, "Repo 1", "Repository 1"),
            GitHubRepo(2, "Repo 2", "Repository 2")
        )

        val repository = mock<GitHubRepoRepository> { on { getRepoListByUsername(any()) } doReturn response }

        val observer = Observer<List<Repo>> {
            Assert.assertEquals(2, it.size)
            Assert.assertArrayEquals(response.toTypedArray(), it.toTypedArray())
        }

        val vm = SearchResultViewModel(repository)

        vm.repoList.observeForever(observer)

        vm.searchRepos1("test")
    }

    @Test
    fun `should call repository and get list with two elements 2`() = runBlocking {

        val response = listOf(
            GitHubRepo(1, "Repo 1", "Repository 1"),
            GitHubRepo(2, "Repo 2", "Repository 2")
        )

        val repository = mock<GitHubRepoRepository> { on { getRepoListByUsername(any()) } doReturn response }

        val observer = Observer<List<Repo>> {
            Assert.assertEquals(2, it.size)
            Assert.assertArrayEquals(response.toTypedArray(), it.toTypedArray())
        }

        val vm = SearchResultViewModel(repository)

        vm.repoList.observeForever(observer)

        vm.searchRepos2("test")

    }

    @Test
    fun `should call repository and get list with two elements 3`() = runBlocking {

        val response = listOf(
            GitHubRepo(1, "Repo 1", "Repository 1"),
            GitHubRepo(2, "Repo 2", "Repository 2")
        )

        val repository = mock<GitHubRepoRepository> { on { getRepoListByUsername(any()) } doReturn response }

        val observer = Observer<List<Repo>> {
            Assert.assertEquals(2, it.size)
            Assert.assertArrayEquals(response.toTypedArray(), it.toTypedArray())
        }

        val vm = SearchResultViewModel(repository)

        vm.repoList.observeForever(observer)

        vm.searchRepos3("test")
    }
}