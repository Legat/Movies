package ru.android.academy.movies.Models


import java.io.Serializable

data class Actor(
    val id: Int,
    val name: String,
    val profile_path: String
    ) : Serializable