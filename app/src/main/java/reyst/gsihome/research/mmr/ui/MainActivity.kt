package reyst.gsihome.research.mmr.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import reyst.gsihome.research.mmr.R
import reyst.gsihome.research.mmr.ReaderApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SearchResultViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[SearchResultViewModel::class.java]
    }

    private val adapter = RepoAdapter()

    private val etName: EditText by lazy { findViewById<EditText>(R.id.name) }
    private val btn: Button by lazy { findViewById<Button>(R.id.button) }
    private val list: RecyclerView by lazy { findViewById<RecyclerView>(R.id.list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ReaderApp)
            .appComponent
            .inject(this)

        btn.setOnClickListener { viewModel.searchRepos(etName.text.toString()) }

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        viewModel.repoList.observe(
            this,
            Observer<List<reyst.gsihome.research.core.Repo>> { adapter.update(it) }
        )
    }
}
