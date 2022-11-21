package com.example.pokemonpoo

class Charmander(
    idPokemon:Int, nombre:String, tipoPrincipal:Tipo,
    tipoSecundario: Tipo?, salud:Int, capAtaque:Int,
    capDefensa:Int, peso:Double, altura:Double, nivel:Int,
    evoluciones:List<String>, descripcion:String, nivelDeLlama:String)
                : //indicamos la herencia ->
                Pokemon(idPokemon, nombre,tipoPrincipal,
                    tipoSecundario, salud,capAtaque,
                    capDefensa,peso,altura,nivel,
                    evoluciones,descripcion, imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/4.png")
{
    //comienza el cuerpo de la clase
     var nivelDeLlama:String = nivelDeLlama

    override fun evolucionar() {
        if (this.nivel<16){
            println("${this.nombre} todavia no está listo para evolucionar, necesita subir ${16-this.nivel} niveles más")
        }
        else if (this.nivel>=16){
            println("${this.nombre} está listo!")
            println("${this.nombre} está evolucionando a ${this.evoluciones[0]}")
        }
        else if(this.nivel>=36){
            println("${this.nombre} está listo!")
            println("${this.nombre} está evolucionando a ${this.evoluciones[1]}")
        }
    }

    override fun toString(): String {
        return "Soy un pokemon $nombre, mi id es #$idPokemon soy de tipo ${tipoPrincipal.nombreTipo}, y mi llama está $nivelDeLlama. Me encantaria llegar a evolucionar a ${evoluciones[1]}"
    }


}