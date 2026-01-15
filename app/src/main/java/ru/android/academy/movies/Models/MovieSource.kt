package ru.android.academy.movies.Models

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.android.academy.movies.Data.loadMovies
import ru.android.academy.movies.Data.getMovieById


class MovieSource {

   suspend fun getMovies(context: Context): List<Movie> = withContext(Dispatchers.IO){
       loadMovies(context)
    }

    suspend fun getMovie(id:Int?, context:Context) : Movie = withContext(Dispatchers.IO){
        getMovieById(id, context)
    }
}