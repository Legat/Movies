package ru.android.academy.movies.Data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.android.academy.movies.Models.Actor
import ru.android.academy.movies.Models.Genre
import ru.android.academy.movies.Models.Movie
import java.io.IOException

private val gson = Gson()

@Suppress("unused")
internal suspend fun loadMovies(context: Context): List<Movie> = withContext(Dispatchers.IO) {
    val genresMap = loadGenres(context)
    val actorsMap = loadActors(context)

    val data = readAssetFileToString(context, "data.json")
    parseMovies(data, genresMap, actorsMap)
}

private suspend fun loadGenres(context: Context): List<Genre> = withContext(Dispatchers.IO) {

    val data = getJsonDataFromAsset(context, "genres.json")
    parseGenres(data)
}

private fun readAssetFileToString(context: Context, fileName: String): String {
    val stream = context.assets.open(fileName)
    return stream.bufferedReader().readText()
}

internal fun parseGenres(jsonString: String?): List<Genre> {
    val genre = object : TypeToken<List<Genre>>() {}.type
    return gson.fromJson(jsonString, genre)
}

private suspend fun loadActors(context: Context): List<Actor> = withContext(Dispatchers.IO) {
    val data = getJsonDataFromAsset(context, "people.json")
    parseActors(data)
}

internal fun parseActors(jsonString: String?): List<Actor> {
    val listPersonType = object : TypeToken<List<Actor>>() {}.type
    return  gson.fromJson(jsonString, listPersonType)
}

internal fun parseMovies(
    jsonString: String,
    genreData: List<Genre>,
    actors: List<Actor>
): List<Movie> {
    val genresMap = genreData.associateBy(Genre::id)
    val actorsMap = actors.associateBy(Actor::id)


    val jsonMovietype = object : TypeToken<List<JsonMovie>>() {}.type


    val jsonMovie: List<JsonMovie> = gson.fromJson(jsonString, jsonMovietype)


    return jsonMovie.map(fun(jsonMovie: JsonMovie): Movie {
        return (@Suppress("unused")
        Movie(
            id = jsonMovie.id,
            title = jsonMovie.title,
            storyLine = jsonMovie.overview,
            imageUrl = jsonMovie.poster_path,
            detailImageUrl = jsonMovie.backdrop_path,
            rating = (jsonMovie.vote_average / 2).toInt(),
            reviewCount = jsonMovie.vote_count,
            pgAge = if (jsonMovie.adult) 16 else 13,
            runningTime = jsonMovie.runtime,
            genres = jsonMovie.genre_ids.map { id ->
                genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
            },
            actors = jsonMovie.actors.map { id ->
                actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
            },
            isLiked = false
        ))
    })
}

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

internal suspend fun getMovieById(id: Int?, context: Context) : Movie = withContext(Dispatchers.IO){
     val movies:List<Movie> = loadMovies(context)
     filterId(id,movies)
}

private fun filterId(id:Int?, movies:List<Movie>):Movie{
    val filterMovie = movies.filter {
        it.id == id
    }
    return filterMovie[0]
}

private fun <T : Any> T?.orThrow(createThrowable: () -> Throwable): T {
    return this ?: throw createThrowable()
}