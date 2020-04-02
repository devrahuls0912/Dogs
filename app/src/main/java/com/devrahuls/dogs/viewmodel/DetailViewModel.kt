package com.devrahuls.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devrahuls.dogs.model.DogBreed

class DetailViewModel : ViewModel() {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog = DogBreed("1", "Dalmatian", "10", "Breed Group", "Bred For", "Temperament", "")
        dogLiveData.value = dog
    }

}