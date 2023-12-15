package com.example.my.tima_tube.dataremote

import com.example.my.tima_tube.core.network.BaseDataSource
import com.example.my.tima_tube.dataremote.model.PlayLists
import com.example.my.tima_tube.dataremote.model.PlaylistItem
import com.example.my.tima_tube.result.Resource
import com.example.my.tima_tube.utils.Const
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {


    suspend fun getPlayLists(): Resource<PlayLists> {
        return getResult {
            apiService.getPlayLists(
                "\"AIzaSyCDv972OguVFpCzKWuu6JD_sinMhqJbbpg\"", Const.part, Const.channelId
            )
        }
    }

    suspend fun getDetail(playlistId: String): Resource<PlaylistItem> {
        return getResult {
            apiService.playlistItems(
                "\"AIzaSyCDv972OguVFpCzKWuu6JD_sinMhqJbbpg\"", Const.part, playlistId, 20
            )
        }
    }

    suspend fun getVideo(id: String?) = getResult {
        apiService.getVideo(
            "\"AIzaSyCDv972OguVFpCzKWuu6JD_sinMhqJbbpg\"",
            Const.part,
            id!!
        )
    }

}