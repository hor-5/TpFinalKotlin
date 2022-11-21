package com.example.pokemonpoo

class Pokedex(idPokedex: Int,pokemonesRegistrados:ArrayList<Pokemon>) {
    var idPokedex:Int=idPokedex
    var pokemonesRegistrados:ArrayList<Pokemon> = pokemonesRegistrados


    fun mostrarInfoPokemon(pokemon : Pokemon){
        pokemon.setImagenASCII(pokemon)
        println(pokemon.getImagenASCII())
        println("información sobre ${pokemon.nombre} :")
        println("\n ${pokemon.descripcion}\n")
    }

    fun registrarPokemon(pokemon:Pokemon){
        println("\nBuscando a ${pokemon.nombre.capitalize()} en la pokedex")
        mostrarInfoPokemon(pokemon)
        pokemonesRegistrados.add(pokemon)
        println("${pokemon.nombre} registrado!")


    }






}