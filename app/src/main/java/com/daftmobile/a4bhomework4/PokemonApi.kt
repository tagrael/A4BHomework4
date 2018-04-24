package com.daftmobile.a4bhomework4

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApi {

    @GET("/api/pokemon/{number}/peek")
    fun pokedex(@Path("number") number: String): Call<PokemonItem>

}