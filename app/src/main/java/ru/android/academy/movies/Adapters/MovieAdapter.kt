package ru.android.academy.movies.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.android.academy.movies.Models.Movie
import ru.android.academy.movies.R

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies = listOf<Movie>()

    private var onClickItemListener: OnClickItemListener? = null

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            onClickItemListener?.onClick(movies[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int =
        movies.size


    fun setData(newmovies:List<Movie>){
        movies = newmovies
        notifyDataSetChanged()
    }

    fun setItemListener(onClickListener:OnClickItemListener){
        onClickItemListener = onClickListener
    }
}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val movieImage:ImageView? = view.findViewById(R.id.movie_image)
    private val movieAge:TextView? = view.findViewById(R.id.movie_age)
    private val movieRating:RatingBar? = view.findViewById(R.id.movie_rating)
    private val movieReview:TextView? = view.findViewById(R.id.review)
    private val movieGenre:TextView? = view.findViewById(R.id.genre)
    private val movieName:TextView? = view.findViewById(R.id.movie_name)
    private val movieDuration:TextView? = view.findViewById(R.id.movie_min)
    private val movieFavorites:ImageView? = view.findViewById(R.id.movie_favorites)

    fun bind(movie: Movie){
        movieName?.text = movie.name
        movieAge?.text = movie.age
        movieRating?.rating = movie.rating
        movieReview?.text = movie.reviews
        movieGenre?.text = movie.genre
        movieDuration?.text = movie.duration
        movieImage?.setImageResource(movie.poster)
        if (movie.favorite)
            movieFavorites?.setImageResource(R.drawable.ic_like_positive)
        else
            movieFavorites?.setImageResource(R.drawable.ic_like)

    }

}

interface OnClickItemListener{
    fun onClick(movie:Movie)
}
