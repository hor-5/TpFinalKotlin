package com.example.pokefight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pokefight.datastorage.DataStore
import com.example.pokefight.entities.User
import com.example.pokemonpoo.EntrenadorPokemon
import com.squareup.picasso.Picasso

class FirstActivity : AppCompatActivity() {
    val datastore:DataStore = DataStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        getUserData()
        //elementos de la vista

        val optAsh:RadioButton = findViewById<RadioButton>(R.id.optAsh)
        val optSonia:RadioButton  = findViewById<RadioButton>(R.id.optSonia)
        val imgEntrenador:ImageView = findViewById<ImageView>(R.id.imgEntrenadorSeleccionado)
        val confirmarEntrenador:Button = findViewById<Button>(R.id.btnConfirmarEntrenador)
        //entrenadores
        val ash:EntrenadorPokemon = datastore.getAsh()
        val sonia:EntrenadorPokemon  = datastore.getSonia()

        //setear imagen de ash por defecto, el radio viene checked
        Picasso.get().load(ash.imgUrl).into(imgEntrenador)

        optAsh.setOnClickListener(){
            Picasso.get().load(ash.imgUrl).into(imgEntrenador)
        }
        optSonia.setOnClickListener(){
            Picasso.get().load(sonia.imgUrl).into(imgEntrenador)
        }

        confirmarEntrenador.setOnClickListener() {
            startNextActivity(optAsh.id,optSonia.id)
            Toast.makeText(this,"entrenador seleccionado",Toast.LENGTH_LONG)
                .show()
        }
    }

    fun entrenadorSeleccionado(idOptAsh:Int ,idOptSonia:Int):String{
        val radioGroup:RadioGroup = findViewById<RadioGroup>(R.id.radioGroupEntrenadores)
        val idSeleccionado = radioGroup.getCheckedRadioButtonId()
        var nombreEntrenador:String ="ash"
        when(idSeleccionado){
            idOptAsh->{nombreEntrenador="ash"}
            idOptSonia->{nombreEntrenador="sonia"}
        }
        return nombreEntrenador
    }

    fun getUserData(){
        var currentUser: User? = intent.getParcelableExtra<User>("usuario")

        val txtNombreUsuario = findViewById<TextView>(R.id.txtNombreUsuario)
        //picasso avatar image
        val imgAvatar = findViewById<ImageView>(R.id.imgAvatar)

        Picasso.get().load(currentUser!!.imgUrl.toString()).into(imgAvatar)

        txtNombreUsuario.text = currentUser!!.nickname

    }

    fun startNextActivity(idOptAsh: Int, idOptSonia: Int){
        var currentUser: User? = intent.getParcelableExtra<User>("usuario")
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("usuario",currentUser)
        intent.putExtra("entrenador",entrenadorSeleccionado(idOptAsh,idOptSonia))
        startActivity(intent)
    }

}