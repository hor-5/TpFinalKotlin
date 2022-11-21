package com.example.pokefight.entities.DTOs

import com.example.pokefight.datastorage.DataStore
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("pokemon/{id}")
    fun getPokemon(@Path(value="id") id:Int): Call<PokemonDTO>
}