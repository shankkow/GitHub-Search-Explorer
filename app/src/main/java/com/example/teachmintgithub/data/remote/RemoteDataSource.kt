package com.example.assignmenttrial1.data.remote

import com.example.assignmenttrial1.data.local.AppDatabase
import com.example.assignmenttrial1.data.local.ContributorEntity
import com.example.assignmenttrial1.domain.model.Contributor
import retrofit2.HttpException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase
) {
    suspend fun fetchContributors(owner: String, repo: String): List<ContributorEntity> {
        return try {
            val response = apiService.getContributors(owner, repo)
            response.body()?.map {
                ContributorEntity(it.login, it.avatar_url, it.contributions, it.html_url)
            } ?: emptyList()
        } catch (e: HttpException) {
            // Handle the error response
            emptyList()
        } catch (e: Exception) {
            // Handle other exceptions
            emptyList()
        }
    }
}
