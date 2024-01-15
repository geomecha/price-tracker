package com.geomecha.pricetracker.di

import com.geomecha.pricetracker.data.remote.api.SearchApi
import com.geomecha.pricetracker.data.remote.api.api
import com.geomecha.pricetracker.data.remote.api.httpClient
import com.geomecha.pricetracker.data.remote.api.retrofit
import com.google.gson.Gson
import org.koin.dsl.module

val networkModule = module {
    single { Gson() }
    single { api<SearchApi>(retrofit(get(), httpClient(get()))) }

}