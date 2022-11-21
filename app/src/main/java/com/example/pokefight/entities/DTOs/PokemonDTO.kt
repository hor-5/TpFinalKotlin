package com.example.pokefight.entities.DTOs

class PokemonDTO(id:Int,name:String,height:Int,weight:Int,sprites:Sprites,types:List<Types>) {

    var id:Int =id
    var name:String = name
    var height:Int = height
    var weight:Int = weight
    var sprites:Sprites = sprites
    var types:List<Types> = types
}