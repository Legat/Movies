package ru.android.academy.movies.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal class JsonActor(
    val id: Int,
    val name: String,
    @SerialName("profile_path")
    val profile_path: String
)