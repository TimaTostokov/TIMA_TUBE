package com.example.my.tima_tube.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.my.tima_tube.dataremote.RemoteDataSource
import com.example.my.tima_tube.dataremote.model.PlayLists
import com.example.my.tima_tube.dataremote.model.PlaylistItem
import com.example.my.tima_tube.dataremote.model.Videos
import com.example.my.tima_tube.result.Resource
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {

    fun getPlaylists(): LiveData<Resource<PlayLists>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getPlayLists()
            emit(response)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun getPlaylistItem(playlistId: String): LiveData<Resource<PlaylistItem>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getDetail(playlistId)

            val list = ArrayList<String>()

            response.data?.items?.forEach { item ->
                val items = dataSource.getVideo(item?.contentDetails?.videoId)
                items.data?.items?.get(0)?.contentDetails?.let {
                    list.add(it.duration)
                }

                list.forEachIndexed { index, s ->
                    response.data.items[index]?.date = s
                }
            }
            emit(response)
        }
    }

    fun getVideo(id: String): LiveData<Resource<Videos>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getVideo(id)
            emit(response)
        }
    }

}