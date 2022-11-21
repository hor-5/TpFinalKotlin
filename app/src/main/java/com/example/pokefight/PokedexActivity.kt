package com.example.pokefight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pokefight.datastorage.DataStore
import com.example.pokefight.entities.DTOs.ApiService
import com.example.pokefight.entities.DTOs.PokemonDTO
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokedexActivity : AppCompatActivity() {
    //private val datastore:DataStore = DataStore()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)


        val btnTraerPokemon = findViewById<Button>(R.id.btnTraerPokemon)

        btnTraerPokemon.setOnClickListener {
            if((findViewById<EditText>(R.id.editTextId).text).toString().trim().isNotEmpty()){
                getData()
            }else{
                val txtCode = findViewById<TextView>(R.id.txtCode)
                txtCode.text = "Debe ingresar un ID del pokemon"
            }
        }
    }

    fun getData(){
        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtIdPokemon = findViewById<TextView>(R.id.txtIdPokemon)
        val txtPeso = findViewById<TextView>(R.id.txtPeso)
        val txtAltura = findViewById<TextView>(R.id.txtAltura)
        val txtCode = findViewById<TextView>(R.id.txtCode)
        val txtTipoPokemon = findViewById<TextView>(R.id.txtTipoPokemon)
        val imgPokedex = findViewById<ImageView>(R.id.imgPokedex)

        val EditTextValue = (findViewById<EditText>(R.id.editTextId).text).toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val services: ApiService = retrofit.create(ApiService::class.java)

        val id = EditTextValue.toInt()
        //val id=datastore.rand(1,150)

        var call: Call<PokemonDTO> = services.getPokemon(id)
        call.enqueue(object: Callback<PokemonDTO> {
            override fun onResponse(call : Call<PokemonDTO>, response: Response<PokemonDTO>){
                if(!response.isSuccessful){
                    txtCode.setText("Codigo: ${response.code()}\n No existe ningún pokemon id #${id}" )
                    return
                }
                var pokemon: PokemonDTO? = response.body()
                if (pokemon != null) {
                    txtCode.text=""
                    txtNombre.text = pokemon.name.toUpperCase()
                    txtIdPokemon.text = "#${pokemon.id.toString()}"
                    txtTipoPokemon.text = "Tipo principal (EN): ${pokemon.types[0].type.name.toUpperCase()} "
                    var pesoEnKg :Double  = ((pokemon.weight).toDouble()) /10
                    var alturaEnMetros:Double =  ((pokemon.height).toDouble()) /10
                    txtAltura.text = "Peso: ${pesoEnKg }kg "
                    txtPeso.text = "Altura: ${alturaEnMetros}m "


                    Picasso.get().load(pokemon.sprites.other.home.front_default).into(imgPokedex)

                }
            }

            override fun onFailure(call: Call<PokemonDTO>, t: Throwable) {
                txtCode.setText(t.message)
            }

        })


    }
}