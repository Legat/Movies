package ru.android.academy.movies

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import ru.android.academy.movies.Adapters.MovieAdapter
import ru.android.academy.movies.Adapters.OnClickItemListener
import ru.android.academy.movies.Data.loadMovies
import ru.android.academy.movies.Models.Movie


class FragmentMoviesList : Fragment() {

    private var listener: FragmentListener? = null

    private var recycler: RecyclerView? = null

    private val scope = CoroutineScope(Dispatchers.Main)

    private val onClickItemListener = object : OnClickItemListener {
        override fun onClick(id: Int) {
            listener?.openMoviesDetailsScreen(id)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.list_movie)
        recycler?.adapter = MovieAdapter()

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recycler?.layoutManager = GridLayoutManager(context, 2)
        } else {
            recycler?.layoutManager = GridLayoutManager(context, 3)
        }

        setMovies()
    }

    private fun setMovies() {
        scope.launch {
            val movies: List<Movie> = loadMovies(requireContext())
            (recycler?.adapter as? MovieAdapter)?.apply {
                setData(movies)
                setItemListener(onClickItemListener)
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler = null
    }

    interface FragmentListener {
        fun openMoviesDetailsScreen(id: Int)
    }


}