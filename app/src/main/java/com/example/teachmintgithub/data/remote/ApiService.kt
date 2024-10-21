package com.example.assignmenttrial1.data.remote

import com.example.assignmenttrial1.domain.model.Contributor
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("repos/{owner}/{repo}/contributors")
    suspend fun getContributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<List<Contributor>>
}
