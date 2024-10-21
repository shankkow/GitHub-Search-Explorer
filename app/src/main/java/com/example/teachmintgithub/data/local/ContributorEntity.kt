package com.example.teachmintgithub.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.assignmenttrial1.domain.model.Contributor

@Entity(tableName = "contributors")
data class ContributorEntity(
    @PrimaryKey val login: String,
    val avatar_url: String,
    val contributions: Int,
    val html_url: String
) {
    fun toDomainModel() = Contributor(login, avatar_url, contributions, html_url)
}
