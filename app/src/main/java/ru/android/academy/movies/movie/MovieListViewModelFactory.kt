package ru.android.academy.movies.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        ListMovieViewModel::class.java -> ListMovieViewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}
