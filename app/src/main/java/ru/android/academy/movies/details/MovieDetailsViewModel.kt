package ru.android.academy.movies.details

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.android.academy.movies.Models.Movie
import ru.android.academy.movies.Models.MovieSource

class MovieDetailsViewModel : ViewModel() {

    private val _mutableMovieDetails = MutableLiveData<Movie>()

    val movieDetails: LiveData<Movie> get() = _mutableMovieDetails

    fun getMovie(id: Int?, context: Context) {
        viewModelScope.launch {

            val movieSource = MovieSource()
            val movie: Movie = movieSource.getMovie(id, context)

            _mutableMovieDetails.setValue(movie)
        }

    }
}