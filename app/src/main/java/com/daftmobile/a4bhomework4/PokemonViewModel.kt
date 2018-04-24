package com.daftmobile.a4bhomework4

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class PokemonViewModel: ViewModel() {

    private val pokemonLiveData = MutableLiveData<PokemonItem>()
    private val errorLiveData = MutableLiveData<String>()
    val fetcher = PokemonFetcher()

    fun newPokemon(): LiveData<PokemonItem> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun showPokemonInfo(index: String) {
       try {
           fetcher.fetch(index, {
               pokemonLiveData.postValue(it)
           })
       }
       catch(e:InvalidIndexException)
       {
           errorLiveData.postValue("The Pokedex only operates on indexes from 1 to 151")
       }
    }


}