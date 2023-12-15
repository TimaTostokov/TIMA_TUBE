package com.example.my.tima_tube.ui.player

import androidx.lifecycle.LiveData
import com.example.my.tima_tube.core.ui.BaseViewModel
import com.example.my.tima_tube.dataremote.model.Videos
import com.example.my.tima_tube.repository.Repository
import com.example.my.tima_tube.result.Resource

class PlayerViewModel(private val repository: Repository) : BaseViewModel() {

    fun getVideo(id: String): LiveData<Resource<Videos>> {
        return repository.getVideo(id)
    }

}