package ru.android.academy.movies.Data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class JsonMovie(
    val id: Int,
    val title: String,
    @SerialName("poster_path")
    val poster_path: String,
    @SerialName("backdrop_path")
    val backdrop_path: String,
    val runtime: Int,
    @SerialName("genre_ids")
    val genre_ids: List<Int>,
    val actors: List<Int>,
    @SerialName("vote_average")
    val vote_average: Float,
    @SerialName("vote_count")
    val vote_count: Int,
    val overview: String,
    val adult: Boolean
)