package com.example.pokemonpoo

class Pikachu(idPokemon:Int, nombre:String,tipoPrincipal:Tipo,
              tipoSecundario:Tipo?, salud:Int,capAtaque:Int,
              capDefensa:Int,peso:Double,altura:Double,nivel:Int,
              evoluciones:List<String>,descripcion:String,nivelDeEstabilidad:String)
            : //indicamos la herencia ->
            Pokemon(idPokemon, nombre,tipoPrincipal,
                tipoSecundario, salud,capAtaque,
                capDefensa,peso,altura,nivel,
                evoluciones,descripcion,imgUrl="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/25.png")
{
    //comienza el cuerpo de la clase
    var nivelDeEstabilidad:String = nivelDeEstabilidad

    override fun getEvoluciones() {
        println("la unica evolucion para $nombre es ${evoluciones[0]}")
    }

    override fun evolucionar(){
        if (this.nivel<30){
            println("${this.nombre} todavia no está listo para evolucionar, necesita subir ${30-this.nivel} niveles más")
        }
        else if(this.nivel>=30){
            println("${this.nombre} está listo!")
            println("${this.nombre} está evolucionando a ${this.evoluciones[0]}")
        }
    }

    override fun toString(): String {
        return "Soy un pokemon $nombre, mi id es #$idPokemon soy de tipo ${tipoPrincipal.nombreTipo}, y mi estabilidad ahora es $nivelDeEstabilidad"
    }

}