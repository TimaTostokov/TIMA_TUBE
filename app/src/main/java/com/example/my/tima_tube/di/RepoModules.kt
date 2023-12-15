package com.example.my.tima_tube.di

import com.example.my.tima_tube.repository.Repository
import org.koin.dsl.module

val repoModules = module {
    single {
        Repository(get())
    }

}