package ru.android.academy.movies.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.android.academy.movies.Adapters.ActorAdapter
import ru.android.academy.movies.Models.Movie
import ru.android.academy.movies.R

class FragmentMoviesDetails : Fragment() {

    private var ageText: TextView? = null
    private var nameText: TextView? = null
    private var genreText: TextView? = null
    private var ratingRating: RatingBar? = null
    private var reviewsText: TextView? = null
    private var detailImage: ImageView? = null
    private var detailDescription: TextView? = null
    private var recyclerView: RecyclerView? = null

    private val viewModel: MovieDetailsViewModel by viewModels { MovieDetailsModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        findViews(view)
        val id: Int? = arguments?.getInt(fragmentDetailsTag)

        viewModel.movieDetails.observe(this.viewLifecycleOwner, this::setMovie)

        viewModel.getMovie(id, requireContext())

    }


    private fun findViews(view: View) {
        detailImage = view.findViewById(R.id.movie_pic)
        nameText = view.findViewById(R.id.name)
        ageText = view.findViewById(R.id.age_limit)
        genreText = view.findViewById(R.id.genre)
        ratingRating = view.findViewById(R.id.ratingBar)
        reviewsText = view.findViewById(R.id.reviews)
        detailDescription = view.findViewById(R.id.description)
        recyclerView = view.findViewById(R.id.actors_list)
    }


    private fun setMovie(movie: Movie) {
        Picasso.get()
            .load(movie.detailImageUrl)
            .placeholder(R.drawable.actor_placeholder)
            .error(R.drawable.actor_placeholder)
            .into(detailImage)

        nameText?.text = movie.title
        ageText?.text = context?.getString(R.string.movie_age, movie.pgAge)
        genreText?.text = movie.genres.joinToString { it.name }
        ratingRating?.rating = movie.rating.toFloat()
        reviewsText?.text = context?.getString(R.string.movie_reviews, movie.reviewCount)
        detailDescription?.text = movie.storyLine
        recyclerView?.adapter = ActorAdapter(movie.actors)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }


    companion object {
        fun newInstance(id: Int): FragmentMoviesDetails {
            val args = Bundle()
            args.putInt(fragmentDetailsTag, id)
            val fragmentMoviesDetails = FragmentMoviesDetails()
            fragmentMoviesDetails.arguments = args
            return fragmentMoviesDetails
        }

        const val fragmentDetailsTag: String = "MOVIE_DETAILS"
    }


}
