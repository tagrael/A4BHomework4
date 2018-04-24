package com.daftmobile.a4bhomework4

import com.daftmobile.android4beginners5.log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokemonFetcher {

    private val client = OkHttpClient.Builder()
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://switter.int.daftcode.pl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val pokemonApi = retrofit.create(PokemonApi::class.java)

    fun fetch(index: String, onSuccess: (PokemonItem) -> Unit) {
        if(index.toInt() > 151 || index.toInt() < 1) throw InvalidIndexException()
        val call = pokemonApi.pokedex(index)
        call.enqueue(object : Callback<PokemonItem> {

            override fun onFailure(call: Call<PokemonItem>, t: Throwable) {
                log(t.message ?: "Unknown error")
            }

            override fun onResponse(call: Call<PokemonItem>, response: Response<PokemonItem>) {
                        onSuccess(response.body() ?: return)
            }
        })
    }
}