package com.example.my.tima_tube.ui.detail

import androidx.lifecycle.LiveData
import com.example.my.tima_tube.core.ui.BaseViewModel
import com.example.my.tima_tube.dataremote.model.PlaylistItem
import com.example.my.tima_tube.repository.Repository
import com.example.my.tima_tube.result.Resource

class DetailViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlaylistItem(playlistId: String?): LiveData<Resource<PlaylistItem>> {
        return repository.getPlaylistItem(playlistId!!)
    }

}