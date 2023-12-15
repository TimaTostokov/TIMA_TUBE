package com.example.my.tima_tube.ui.playlists

import androidx.lifecycle.LiveData
import com.example.my.tima_tube.core.ui.BaseViewModel
import com.example.my.tima_tube.dataremote.model.PlayLists
import com.example.my.tima_tube.repository.Repository
import com.example.my.tima_tube.result.Resource

class PlaylistsViewModel(private val repository: Repository) : BaseViewModel() {

    fun playlists(): LiveData<Resource<PlayLists>> {
        return repository.getPlaylists()
    }

}