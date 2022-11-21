package com.example.pokefight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.pokefight.datastorage.DataStore
import com.example.pokefight.entities.User
import com.example.pokemonpoo.CampoDeBatalla
import com.example.pokemonpoo.EntrenadorPokemon
import com.example.pokemonpoo.Pokemon
import com.squareup.picasso.Picasso
import java.util.*

class ThirdActivity : AppCompatActivity() {
    val dataStore: DataStore = DataStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        getUserData()
        val btnBatallar = findViewById<Button>(R.id.btnIniciarBatalla)

        btnBatallar.setOnClickListener {
            val aPokemones :ArrayList<Pokemon> = getPokemonesSeleccionados()
            getPokemonesSeleccionados()
            val campoDeBatalla:CampoDeBatalla = dataStore.getCampoBatalla(aPokemones[0],aPokemones[1])
            val txtLogs:TextView = findViewById<TextView>(R.id.txtLogs)

            var logs :String = campoDeBatalla.comenzarBatalla()
            txtLogs.text = logs
        }

        val btnPokedex = findViewById<Button>(R.id.btnPokedex)
        btnPokedex.setOnClickListener {
            var intentPokedex = Intent(this, PokedexActivity::class.java)
            startActivity(intentPokedex)
        }

    }
    fun getPokemonesSeleccionados():ArrayList<Pokemon>{

        val txtNombrePokSel = findViewById<TextView>(R.id.txtNombrePokSel)
        val txtNombrePokMaquina = findViewById<TextView>(R.id.txtNombrePokMaq)
        val txtLogs:TextView = findViewById<TextView>(R.id.txtLogs)

        val pokemonSeleccionado:Pokemon=chequearPokemon(txtNombrePokSel.text.toString())
        val pokemonMaquina:Pokemon = chequearPokemon(txtNombrePokMaquina.text.toString())

        var aPokemones: ArrayList<Pokemon> = arrayListOf(pokemonSeleccionado,pokemonMaquina)

        return aPokemones
    }
    fun chequearPokemon(nombrePokemon:String):Pokemon{
        var pokemonSeleccionado: Pokemon? = null

        when(nombrePokemon){
            "pikachu"->{
                pokemonSeleccionado= dataStore.getPikachu()

            }
            "charmander"->{
                pokemonSeleccionado= dataStore.getCharmander()

            }
            "bulbasaur"->{
                pokemonSeleccionado= dataStore.getBulbasaur()

            }
            "squirtle"->{
                pokemonSeleccionado= dataStore.getSquirtle()

            }

        }
        return pokemonSeleccionado!!

    }

    fun entrenadorMaquinaDataSet(entrenador:EntrenadorPokemon){
        val imgPokemonMaquina:ImageView = findViewById<ImageView>(R.id.imgPokMaq)
        val imgEntrenadorMaquina:ImageView = findViewById<ImageView>(R.id.imgEntrenadorMaquina)
        val txtNombreEntrenadorMaq = findViewById<TextView>(R.id.txtNombreEntrenadorMaq)
        val txtNombrePokMaq = findViewById<TextView>(R.id.txtNombrePokMaq)
        val txtNombreTipoPokMaq = findViewById<TextView>(R.id.txtTipoPokMaq)
        Picasso.get().load(entrenador.imgUrl).into(imgEntrenadorMaquina)
        txtNombreEntrenadorMaq.text = "${entrenador.nombre} ${entrenador.apellido}"


        var randomIndex: Int = dataStore.rand(0,1) //entre 0 y 1
        val pokemonMaquina =  entrenador.aPokemones[randomIndex]
        Picasso.get().load(pokemonMaquina.imgUrl).into(imgPokemonMaquina)

        txtNombrePokMaq.text = pokemonMaquina.nombre
        txtNombreTipoPokMaq.text = "Tipo ${pokemonMaquina.tipoPrincipal.nombreTipo}"
    }

    fun entrenadorSeleccionadoDataSet(entrenadorSeleccionado:EntrenadorPokemon){
        val imgEntrenador:ImageView = findViewById<ImageView>(R.id.imgEntrenadorSelBatalla)
        val txtNombreEntrenadorSel = findViewById<TextView>(R.id.txtNombreEntrenadorSel)
        Picasso.get().load(entrenadorSeleccionado.imgUrl).into(imgEntrenador)
        txtNombreEntrenadorSel.text = "${entrenadorSeleccionado.nombre} ${entrenadorSeleccionado.apellido}"
    }


    fun pokemonSeleccionadoDataSet(pokemon:Pokemon){
        val imgPokemon:ImageView = findViewById<ImageView>(R.id.imgPokSelBatalla)
        val txtNombrePokSel = findViewById<TextView>(R.id.txtNombrePokSel)
        val txtNombreTipoPokSel = findViewById<TextView>(R.id.txtTipoPokSel)
        Picasso.get().load(pokemon.imgUrl).into(imgPokemon)
        txtNombrePokSel.text = pokemon.nombre
        txtNombreTipoPokSel.text = "Tipo ${pokemon.tipoPrincipal.nombreTipo}"
    }

    fun getUserData(){
        var currentUser: User? = intent.getParcelableExtra<User>("usuario")
        var nombreEntrenador : String? = intent.getStringExtra("entrenador")
        var nombrePokemon : String? = intent.getStringExtra("pokemon")

        val txtNombreUsuario3 = findViewById<TextView>(R.id.txtUsuarioBatalla)
        //picasso avatar image
        val imgAvatar3 = findViewById<ImageView>(R.id.imgAvatarBatalla)



        Picasso.get().load(currentUser!!.imgUrl.toString()).into(imgAvatar3)

        txtNombreUsuario3.text = currentUser!!.nickname
        var entrenadorSeleccionado: EntrenadorPokemon? = null
        var entrenadorMaquina: EntrenadorPokemon? = null
        var pokemonesEnBatalla :ArrayList<Pokemon>? = null
        when(nombreEntrenador){
            "ash"->{
                entrenadorSeleccionado = dataStore.getAsh()
                entrenadorSeleccionadoDataSet(entrenadorSeleccionado)

                entrenadorMaquina= dataStore.getSonia()
                entrenadorMaquinaDataSet(entrenadorMaquina)
            }
            "sonia"->{
                entrenadorSeleccionado = dataStore.getSonia()
                entrenadorSeleccionadoDataSet(entrenadorSeleccionado)

                entrenadorMaquina = dataStore.getAsh()
                entrenadorMaquinaDataSet(entrenadorMaquina)
            }

        }



        var pokemonSeleccionado: Pokemon = dataStore.getPikachu()

            when(nombrePokemon){
            "pikachu"->{
                pokemonSeleccionado= dataStore.getPikachu()
                pokemonSeleccionadoDataSet(pokemonSeleccionado)
            }
            "charmander"->{
                pokemonSeleccionado= dataStore.getCharmander()
                pokemonSeleccionadoDataSet(pokemonSeleccionado)
            }
            "bulbasaur"->{
                pokemonSeleccionado= dataStore.getBulbasaur()
                pokemonSeleccionadoDataSet(pokemonSeleccionado)
            }
            "squirtle"->{
                pokemonSeleccionado= dataStore.getSquirtle()
                pokemonSeleccionadoDataSet(pokemonSeleccionado)
            }

        }

    }
}