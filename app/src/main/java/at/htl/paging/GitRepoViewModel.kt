package at.htl.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class GitRepoViewModel : ViewModel() {

    var gitRepoPagedList: LiveData<PagedList<GitRepo>>
    private var liveDatasource: LiveData<GitRepoDataSource>

    init {
        val itemDataSourceFactory = GitRepoDataSourceFactory()
        liveDatasource = itemDataSourceFactory.gitRepoLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(GitRepoDataSource.PAGE_SIZE)
            .build()

        gitRepoPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}


