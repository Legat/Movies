package ru.android.academy.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.android.academy.movies.details.FragmentMoviesDetails
import ru.android.academy.movies.movie.FragmentMoviesList


class MainActivity : AppCompatActivity(), FragmentMoviesList.FragmentListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentMoviesList())
            .addToBackStack(null)
            .commit()
        }
    }

    override fun openMoviesDetailsScreen(id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMoviesDetails.newInstance(id))
            .addToBackStack(null)
            .commit()
    }


}
