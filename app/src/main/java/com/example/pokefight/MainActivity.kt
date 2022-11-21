package com.example.pokefight

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pokefight.datastorage.DataStore
import com.example.pokefight.entities.User
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    val dataStore:DataStore = DataStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgNfts = findViewById<ImageView>(R.id.imgNfts)
        Picasso.get().load("https://prod-static-wkt.s3.amazonaws.com/static/Clone_X_X_Takashi_Murakami_d827500193.jpg").into(imgNfts)


        val optClonx: RadioButton = findViewById<RadioButton>(R.id.optClonx)
        val optDgApe:RadioButton = findViewById<RadioButton>(R.id.optDgApeClub)
        val optMilo:RadioButton = findViewById<RadioButton>(R.id.optMiloVerso)

        optClonx.setOnClickListener() {
            Picasso.get().load("https://prod-static-wkt.s3.amazonaws.com/static/Clone_X_X_Takashi_Murakami_d827500193.jpg").into(imgNfts)
        }
        optDgApe.setOnClickListener() {
            Picasso.get().load("https://everipedia-storage.s3.amazonaws.com/ProfilePicture/lang_en/degenerate-ape-academy/mainphoto.jpeg").into(imgNfts)
        }
        optMilo.setOnClickListener() {
            Picasso.get().load("https://s3.cointelegraph.com/storage/uploads/view/2fe853edc8dbbf5cf9c79798976885af.PNG").into(imgNfts)
        }

        val btnComenzar = findViewById<Button>(R.id.btnComenzar)
        btnComenzar.setOnClickListener(){
            sendData(optClonx.id,optDgApe.id,optMilo.id)
        }

    }


   fun sendData(idClonx:Int, idDgApe:Int, idMilo:Int){
       val  radioGroup: RadioGroup = findViewById<RadioGroup>(R.id.radioGroupAvatars)
       val nick: String = findViewById<EditText>(R.id.txtNickname).text.toString()
       val selectedId: Int = radioGroup.getCheckedRadioButtonId()

       //definir avatar según selección
       var selectedAvatar= dataStore.getClonxAvatar()
       when(selectedId){
           idClonx->{selectedAvatar  = dataStore.getClonxAvatar()}
           idDgApe->{selectedAvatar = dataStore.getApeAvatar()}
           idMilo->{selectedAvatar = dataStore.getMiloAvatar()}
           else->{selectedAvatar}
       }


        if(nick.trim().isNotEmpty()){

            val usuario : User = User(1,nick,selectedAvatar)

            var intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("usuario",usuario)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Debe ingresar un nickname",Toast.LENGTH_LONG).show()
        }

    }
}