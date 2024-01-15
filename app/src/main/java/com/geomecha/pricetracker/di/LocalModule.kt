package com.geomecha.pricetracker.di

import com.geomecha.pricetracker.data.local.database.LocalDataStore
import org.koin.dsl.module

val localModule = module {
    single { LocalDataStore(get()) }
}