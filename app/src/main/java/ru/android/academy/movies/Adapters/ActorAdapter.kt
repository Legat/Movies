package ru.android.academy.movies.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.android.academy.movies.Models.Actor
import ru.android.academy.movies.R

class ActorAdapter(private var actors: List<Actor>): RecyclerView.Adapter<ActorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent,false))
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
       holder.bind(actors[position])
    }

}

class ActorViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val actorImage:ImageView = view.findViewById(R.id.image_item)
    private val actorText:TextView = view.findViewById(R.id.actor_text)

    fun bind(actor: Actor){

        Picasso.get()
               .load(actor.profile_path)
               .placeholder(R.drawable.actor_placeholder)
               .error(R.drawable.actor_placeholder)
               .into(actorImage)

        actorText.text = actor.name
    }

}
