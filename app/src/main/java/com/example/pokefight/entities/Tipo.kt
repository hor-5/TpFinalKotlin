package com.example.pokemonpoo

class Tipo(idTipo:Int,nombreTipo: String) {

    var idTipo:Int = idTipo
    var nombreTipo:String = nombreTipo
    //establecemos la efectividad contra x tipos de pokemon según el tipo de pokemon invocando al metodo set
    var efectividad:List<String> = setEfectividad()

    //establecemos las debilidad contra X tipos de pokemon según el tipo de pokemon llamando al metodo set
    var debilidad:List<String> = setDebilidad()


    private fun setEfectividad():List<String>{

        var aEfectividad : List<String>

        when(this.nombreTipo){
            "agua" -> {aEfectividad = listOf("tierra","fuego","roca")}
            "fuego" -> {aEfectividad = listOf("bicho","planta","acero","hielo")}
            "planta" -> {aEfectividad = listOf("tierra","roca","agua")}
            "electrico" ->{aEfectividad = listOf("volador","agua")}
            "veneno"-> {aEfectividad = listOf("planta","hada")}
            else -> {aEfectividad = listOf("")}
        }
        return aEfectividad
    }

    private fun setDebilidad():List<String>{
        var aDebilidades: List<String>

        when(this.nombreTipo){
            "agua" -> { aDebilidades = listOf("electrico","planta")}
            "fuego" -> {aDebilidades = listOf("agua","roca","tierra")}
            "planta" -> {aDebilidades = listOf("bicho","fuego","volador","veneno","hielo")}
            "electrico" ->{aDebilidades = listOf("tierra")}
            "veneno"-> {aDebilidades = listOf("psiquico","tierra")}
            else -> {aDebilidades = listOf("")}
        }
        return aDebilidades
    }

    fun esEfectivoContra(nombreTipo:String):Boolean{
        return efectividad.contains(nombreTipo)
    }

    fun esDebilContra(nombreTipo:String):Boolean{
        return debilidad.contains(nombreTipo)
    }


}