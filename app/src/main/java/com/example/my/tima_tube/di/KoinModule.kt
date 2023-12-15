package com.example.my.tima_tube.di

import com.example.my.tima_tube.core.network.networkModule
import com.example.my.tima_tube.dataremote.remoteDataSource

val koinModules = listOf(
    repoModules,
    viewModule,
    remoteDataSource,
    networkModule
)