package com.geomecha.pricetracker.data.local.database

import android.content.Context

class LocalDataStore(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

}