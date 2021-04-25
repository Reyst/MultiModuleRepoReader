package reyst.gsihome.research.mmr.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import reyst.gsihome.research.mmr.R
import reyst.gsihome.research.mmr.ReaderApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SearchResultViewModel by lazy { ViewModelProvider(this, viewModelFactory)[SearchResultViewModel::class.java] }

    private val adapter = RepoAdapter()

    private val etName: EditText by lazy { findViewById(R.id.name) }
    private val btn: Button by lazy { findViewById(R.id.button) }
    private val list: RecyclerView by lazy { findViewById(R.id.list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ReaderApp)
            .appComponent
            .inject(this)

        btn.setOnClickListener { updateList() }

        list.adapter = adapter

//        viewModel.repoList.observe(this, adapter::update)
    }

    private fun updateList() {
        viewModel.searchRepos1(etName.text.toString())
            .observe(this, adapter::update)
    }
}
