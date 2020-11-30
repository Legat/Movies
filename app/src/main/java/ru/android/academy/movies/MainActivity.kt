package ru.android.academy.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), FragmentMoviesList.FragmentListener {

    private val fragmentMoviesList = FragmentMoviesList()
        .apply{ setOnClickListener(this@MainActivity) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragmentMoviesList)
            .addToBackStack(null)
            .commit()
    }

    override fun changeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMoviesDetails())
            .addToBackStack(null)
            .commit()
    }


}
