package at.htl.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class GitRepoAdapter : PagedListAdapter<GitRepo, GitRepoAdapter.RepoViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoAdapter.RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitRepoAdapter.RepoViewHolder, position: Int) {
        val repo = getItem(position)

        repo?.let {
            holder.setData(repo)
        }
    }

    class RepoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(gitRepo: GitRepo) {
            with(view) {
                repo_name.text = gitRepo.fullName
                repo_description.text = gitRepo.description
                repo_language.text = gitRepo.language
                repo_stars.text = gitRepo.stars.toString()
                repo_forks.text = gitRepo.forks.toString()
            }
        }

    }

    companion object {

        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<GitRepo>() {
            override fun areItemsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean =
                oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean =
                oldItem == newItem
        }

    }
}

