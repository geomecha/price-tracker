package com.geomecha.pricetracker

import android.app.Application
import com.geomecha.pricetracker.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PriceTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PriceTrackerApp)
            modules(
                appModule,
                localModule,
                networkModule,
                repositoryModule,
                viewModelsModule
            )
        }
    }
}