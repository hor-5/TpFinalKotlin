package com.example.pokefight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.*
import com.example.pokefight.datastorage.DataStore
import com.example.pokefight.entities.User
import com.example.pokemonpoo.EntrenadorPokemon
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {
    val dataStore:DataStore = DataStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val entrenadorSeleccionado:EntrenadorPokemon = getUserData()
        val imgEntrenador : ImageView = findViewById<ImageView>(R.id.imgEntrenador)
        Picasso.get().load(entrenadorSeleccionado.imgUrl).into(imgEntrenador)


        val radioButton1 = findViewById<RadioButton>(R.id.optPokemon1)
        radioButton1.text = entrenadorSeleccionado.aPokemones[0].nombre
        val radioButton2 = findViewById<RadioButton>(R.id.optPokemon2)
        radioButton2.text = entrenadorSeleccionado.aPokemones[1].nombre

        val btnCampoBatalla = findViewById<Button>(R.id.btnCampoBatalla)

        establecerSeleccionPokemon()

        radioButton1.setOnClickListener {
            establecerSeleccionPokemon()
        }
        radioButton2.setOnClickListener {
            establecerSeleccionPokemon()
        }

        btnCampoBatalla.setOnClickListener {
            toNextActivity()
        }


    }

    fun getUserData():EntrenadorPokemon{
        var currentUser: User? = intent.getParcelableExtra<User>("usuario")
        var nombreEntrenador : String? = intent.getStringExtra("entrenador")

        val txtNombreUsuario2 = findViewById<TextView>(R.id.txtNombreUsuario2)
        //picasso avatar image
        val imgAvatar2 = findViewById<ImageView>(R.id.imgAvatar2)

        Picasso.get().load(currentUser!!.imgUrl.toString()).into(imgAvatar2)

        txtNombreUsuario2.text = currentUser!!.nickname
        val entrenadorSeleccionado:EntrenadorPokemon = when(nombreEntrenador){
            "ash"->{dataStore.getAsh()}
            "sonia"->{dataStore.getSonia()}
            else->{dataStore.getAsh()}
        }

        return entrenadorSeleccionado
    }

    fun establecerSeleccionPokemon(){

        val radioGroupPokemon = findViewById<RadioGroup>(R.id.radioGroupPokemones)

        val radioButtonSelected :RadioButton = findViewById( radioGroupPokemon.checkedRadioButtonId )
        val imgPokemon = findViewById<ImageView>(R.id.imgPokemon)
        var nombrePokemon:String = radioButtonSelected.text as String
        when(nombrePokemon){
            "pikachu"->{Picasso.get().load(dataStore.getPikachu().imgUrl).into(imgPokemon)}
            "charmander"->{Picasso.get().load(dataStore.getCharmander().imgUrl).into(imgPokemon)}
            "bulbasaur"->{Picasso.get().load(dataStore.getBulbasaur().imgUrl).into(imgPokemon)}
            "squirtle"->{Picasso.get().load(dataStore.getSquirtle().imgUrl).into(imgPokemon)}
        }


    }

    fun toNextActivity(){
        val radioGroupPokemon = findViewById<RadioGroup>(R.id.radioGroupPokemones)
        val radioButtonSelected :RadioButton = findViewById( radioGroupPokemon.checkedRadioButtonId )
        var nombrePokemon:String = radioButtonSelected.text.toString()
        var currentUser: User? = intent.getParcelableExtra<User>("usuario")
        var entrenadorSeleccionado: String? = intent.getStringExtra("entrenador")

        var intentNew = Intent(this, ThirdActivity::class.java)
        intentNew.putExtra("usuario",currentUser)
        intentNew.putExtra("entrenador",entrenadorSeleccionado)
        intentNew.putExtra("pokemon",nombrePokemon)
        startActivity(intentNew)
    }
}