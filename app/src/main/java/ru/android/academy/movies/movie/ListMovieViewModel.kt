package ru.android.academy.movies.movie

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.android.academy.movies.Models.Movie
import ru.android.academy.movies.Models.MovieSource

class ListMovieViewModel : ViewModel() {

    private val _mutableMovieList = MutableLiveData<List<Movie>>(emptyList())

    val movieList: LiveData<List<Movie>> get() = _mutableMovieList

    fun addMovies(context: Context) {
        viewModelScope.launch {
            val movies: List<Movie> = MovieSource().getMovies(context)
            _mutableMovieList.setValue(movies)
        }
    }
}