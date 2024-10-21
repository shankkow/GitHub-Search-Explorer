package com.example.teachmintgithub.di

import android.content.Context
import com.example.assignmenttrial1.data.remote.ApiService
import com.example.assignmenttrial1.data.local.AppDatabase
import com.example.assignmenttrial1.data.remote.RemoteDataSource
import com.example.assignmenttrial1.data.repository.ContributorRepository
import com.example.teachmintgithub.data.repository.ContributorRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideDatabase(app: Context): AppDatabase {
        return AppDatabase.getDatabase()
    }

    @Provides
    fun provideContributorRepository(remoteDataSource: RemoteDataSource, database: AppDatabase): ContributorRepository {
        return ContributorRepository(remoteDataSource, database)
    }
}
