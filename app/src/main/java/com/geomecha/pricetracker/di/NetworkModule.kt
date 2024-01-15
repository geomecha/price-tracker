package com.geomecha.pricetracker.di

import com.google.gson.Gson
import org.koin.dsl.module

val networkModule = module {
    single { Gson() }
}