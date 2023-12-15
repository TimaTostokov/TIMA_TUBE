package com.example.my.tima_tube.dataremote


import com.example.my.tima_tube.dataremote.model.PlayLists
import com.example.my.tima_tube.dataremote.model.PlaylistItem
import com.example.my.tima_tube.dataremote.model.Videos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlayLists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<PlayLists>

    @GET("playlistItems")
    suspend fun playlistItems(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("playlistId") channelId: String,
        @Query("maxResults") maxResults: Int
    ): Response<PlaylistItem>

    @GET("videos")
    suspend fun getVideo(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("id") id: String
    ): Response<Videos>

}