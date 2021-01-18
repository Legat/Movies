package ru.android.academy.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.android.academy.movies.Adapters.OnClickItemListener
import ru.android.academy.movies.Models.Movie


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

    override fun openMoviesDetailsScreen(movie:Movie) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMoviesDetails.newInstance(movie))
            .addToBackStack(null)
            .commit()
    }


}
