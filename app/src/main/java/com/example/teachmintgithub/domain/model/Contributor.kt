package com.example.teachmintgithub.domain.model

data class Contributor(
    val login: String,
    val avatar_url: String,
    val contributions: Int,
    val html_url: String
)
