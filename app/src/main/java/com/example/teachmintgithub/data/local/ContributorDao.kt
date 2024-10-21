package com.example.teachmintgithub.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignmenttrial1.domain.model.Contributor

@Dao
interface ContributorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contributor: ContributorEntity)

    @Query("SELECT * FROM contributors LIMIT :limit OFFSET :offset")
    suspend fun getContributors(limit: Int, offset: Int): List<ContributorEntity>
}
