package ru.android.academy.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


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

    override fun openMoviesDetailsScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMoviesDetails())
            .addToBackStack(null)
            .commit()
    }


}
