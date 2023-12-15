package com.example.my.tima_tube.di

import com.example.my.tima_tube.ui.detail.DetailViewModel
import com.example.my.tima_tube.ui.player.PlayerViewModel
import com.example.my.tima_tube.ui.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        PlaylistsViewModel(get())
    }
    viewModel {
        DetailViewModel(get())
    }
    viewModel {
        PlayerViewModel(get())
    }

}