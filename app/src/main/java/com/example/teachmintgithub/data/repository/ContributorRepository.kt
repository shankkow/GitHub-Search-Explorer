package com.example.teachmintgithub.data.repository

import com.example.assignmenttrial1.data.local.AppDatabase
import com.example.assignmenttrial1.data.remote.RemoteDataSource
import com.example.assignmenttrial1.data.local.ContributorEntity
import com.example.teachmintgithub.data.local.ContributorEntity
import javax.inject.Inject

class ContributorRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val database: AppDatabase
) {
    suspend fun getContributors(owner: String, repo: String, offset: Int = 0, limit: Int = 10): List<ContributorEntity> {
        // Fetch contributors from the network
        val contributorsFromNetwork = remoteDataSource.fetchContributors(owner, repo)
        contributorsFromNetwork.forEach { database.contributorDao().insert(it) } // Save to Room

        // Retrieve saved contributors from Room
        return database.contributorDao().getContributors(limit, offset)
    }
}
