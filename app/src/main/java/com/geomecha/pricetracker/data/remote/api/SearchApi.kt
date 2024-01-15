package com.geomecha.pricetracker.data.remote.api

import com.geomecha.pricetracker.core.utils.GOOGLE_SEARCH_API_KEY
import com.geomecha.pricetracker.core.utils.GOOGLE_SEARCH_ENGINE_IDENT
import com.geomecha.pricetracker.data.remote.entity.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("")
    suspend fun search(
        @Query("key") apiKey: String = GOOGLE_SEARCH_API_KEY,
        @Query("cx") ident: String = GOOGLE_SEARCH_ENGINE_IDENT,
        @Query("q") query: String
    ): SearchResponse
}