package com.devrahuls.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.devrahuls.dogs.R
import com.devrahuls.dogs.model.DogBreed
import com.devrahuls.dogs.util.getProgressDrawable
import com.devrahuls.dogs.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter(val dogList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {


    fun updateDogList(newDogList: List<DogBreed>) {
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.name?.text = dogList[position].dogBreed
        holder.lifeSpan?.text = dogList[position].lifeSpan
        holder.imageView?.loadImage(dogList[position].imageUrl, getProgressDrawable(holder.imageView?.context))
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view){
       val name: TextView? = view.name
       val lifeSpan: TextView? = view.lifeSpan
       val imageView: ImageView? = view.imageView
    }
}