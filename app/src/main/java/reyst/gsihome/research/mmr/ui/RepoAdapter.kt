package reyst.gsihome.research.mmr.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import reyst.gsihome.research.mmr.R
import reyst.gsihome.research.mmr.domain.Repo

class RepoAdapter: RecyclerView.Adapter<RepoVH>() {

    private val items: MutableList<Repo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoVH {
        val inflater = LayoutInflater.from(parent.context)
        return RepoVH(inflater.inflate(R.layout.repo_item, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepoVH, position: Int) {
        holder.bind(items[position])
    }

    fun update(list: List<Repo>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}

class RepoVH(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val name = itemView.findViewById<TextView>(R.id.name)
    private val fullName = itemView.findViewById<TextView>(R.id.full_name)

    fun bind(item: Repo) {
        name.text = item.name
        fullName.text = item.fullName
    }
}