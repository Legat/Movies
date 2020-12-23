package ru.android.academy.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.android.academy.movies.Adapters.ActorAdapter
import ru.android.academy.movies.Models.Movie

class FragmentMoviesDetails : Fragment() {

    private var ageText:TextView? = null
    private var nameText:TextView? = null
    private var genreText:TextView? = null
    private var ratingRating:RatingBar? = null
    private var reviewsText:TextView? = null

    private var recyclerView:RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie:Movie? = arguments?.getSerializable(fragmentDetailsTag) as Movie
        fillData(movie, view)

        recyclerView = view.findViewById(R.id.actors_list)
        recyclerView?.adapter = ActorAdapter(movie?.actors!!)
        recyclerView?.layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
    }


    private fun fillData(movie: Movie?, view:View){
        nameText = view.findViewById(R.id.name)
        nameText?.text = movie?.name
        ageText = view.findViewById(R.id.age_limit)
        ageText?.text = movie?.age
        genreText = view.findViewById(R.id.genre)
        genreText?.text = movie?.genre
        ratingRating = view.findViewById(R.id.ratingBar)
        ratingRating?.rating = movie?.rating!!
        reviewsText = view.findViewById(R.id.reviews)
        reviewsText?.text = movie.reviews
    }


    companion object{
        fun newInstance(movie:Movie) : FragmentMoviesDetails{
            val args = Bundle()
            args.putSerializable(fragmentDetailsTag, movie)
            val fragmentMoviesDetails = FragmentMoviesDetails()
            fragmentMoviesDetails.arguments = args
            return fragmentMoviesDetails
        }

        const val fragmentDetailsTag:String = "MOVIE_DETAILS"
    }



}
