package ru.android.academy.movies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

    private var movieItem:ImageView? = null
    private var listener:FragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener){
            listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ):View? = inflater.inflate(R.layout.fragment_movies_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieItem = view.findViewById<ImageView>(R.id.movie_item).apply{
        setOnClickListener { listener?.changeFragment() }
        }
    }

    fun setOnClickListener(l:FragmentListener?){
        listener = l
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface FragmentListener{
        fun changeFragment()
    }


}