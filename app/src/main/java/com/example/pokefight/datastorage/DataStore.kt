package com.example.pokefight.datastorage

import com.example.pokemonpoo.*

class DataStore {

    private var tipoPlanta: Tipo = Tipo(3, "planta")
    private var tipoAgua: Tipo = Tipo(2, "agua")
    private var tipoFuego: Tipo = Tipo(1, "fuego")
    private var tipoVeneno: Tipo = Tipo(8, "veneno")
    private var tipoElectrico: Tipo = Tipo(5, "electrico")

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (Math.random() * (end - start + 1)).toInt() + start
    }
    private fun getRandomItem(options:List<String>):String{
        var selected:String = options[rand(0,(options.size)-1)]
        return selected
    }

    fun getClonxAvatar():String{
        val options: List<String> = listOf("https://i.redd.it/9n4cb810pc981.png",
                            "https://i.pinimg.com/originals/e7/8c/76/e78c76f3654b426e72cfc55b7570f20a.png",
                            "https://nitter.net/pic/media%2FFGfaU_gX0AMGcD7.jpg%3Fname%3Dsmall",
                            "https://img.seadn.io/files/89b7ae23d82f89e85bc3961b4b201287.png?fit=max&w=1000",
                            "https://i.redd.it/91snayz2pc981.png",
                            "https://i.pinimg.com/474x/c0/09/e6/c009e634e7994a1606d6b587ebd7d165.jpg",
                            "https://pbs.twimg.com/media/FGHVXSwXEAQF9IW.jpg",
                            "https://user-dashboard.s3.us-east-2.amazonaws.com/nft-metadata/0x49cf6f5d44e70224e2e23fdcdd2c053f30ada28b/18028.png",
                            "https://i.ibb.co/FWZ5zXy/unnamed.png",
                            "https://mintspace-media.fra1.digitaloceanspaces.com/wp-content/uploads/2022/01/06195242/8b0896fd-9f3d-450e-bb26-98b6bbb4859f.jpeg",
                            "https://i.pinimg.com/736x/42/82/88/42828873b10a1d7d10173265aaac60d7.jpg",
                            "https://www.nftpilot.io/wp-content/uploads/2022/04/unnamed-4.jpg",
                            "https://i.redd.it/estmuyz2pc981.png",
                            "https://cdn.galleriesnow.net/wp-content/uploads/2022/05/Clone-x-Murakami.jpg",
                            "https://openingrealm.b-cdn.net/wp-content/uploads/2021/10/CloneX-5603.png",
                            "https://pbs.twimg.com/media/FG_VY3KWQAkO8kx.png",
                            "https://img.seadn.io/files/bbefba536cb4156606a4e01953bfecab.png",
                            "https://pbs.twimg.com/media/FXeLWzhWQAARF59?format=jpg")

        var selectedImg:String = getRandomItem(options)
        return selectedImg
    }

    fun getApeAvatar():String{
        val options: List<String> = listOf("https://media.howrare.is/images/degenapes/25beb0c27ff6ae54ad952683c000a01b.jpg",
            "https://pbs.twimg.com/media/E8-9bPCXsAMmT7m.jpg",
            "https://pbs.twimg.com/media/E8dany2UUAEei5X.jpg",
            "https://pbs.twimg.com/media/E8YRfNvVcBE5UdB.jpg",
            "https://pbs.twimg.com/media/E8-9bOXWYA83wVQ.jpg",
            "https://pbs.twimg.com/profile_images/1529162577820979203/569xjk6B_400x400.jpg",
            "https://media.howrare.is/images/degenapes/d3862f125b1282418a20e0b05c0854fd.jpg",
            "https://media.howrare.is/images/degenapes/f643e482d1ede376a76dafd7c4c3dad1.jpg",
            "https://pbs.twimg.com/media/E8TDXvoUUAQhp88.jpg",
            "https://i.pinimg.com/236x/ea/2a/8c/ea2a8cabfd53173b1baad3aab6951a1e.jpg",
            "https://media.howrare.is/images/degenapes/6f1e8007c35eaa818e8e3cf7652b5f57.jpg",
            "https://media.howrare.is/images/degenapes/241e23545fffb03b9fba7dff8fb9000a.jpg",
            "https://media.howrare.is/images/degenapes/2a61b00f029f466bc9366f7f986acf99.jpg",
            "https://media.howrare.is/images/degenapes/546a6001a244182157c167cfee0bd33b.jpg")

        var selectedImg:String = getRandomItem(options)
        return selectedImg
    }
    fun getMiloAvatar():String{
        val options: List<String> = listOf("https://www.cronista.com/files/image/463/463379/6294ebcb711d4.png",
            "https://www.cronista.com/files/image/463/463388/6294f39a450f5_934_934!.png",
            "https://www.revistadeck.com/sitio/wp-content/uploads/Miloverso-2.jpg",
            "https://v2.cimg.co/news/82214/208585/10.jpg",
            "https://i2.wp.com/contarte.com.ar/wp-content/uploads/2022/05/nft-16.jpg",
            "https://www.clarin.com/img/2022/06/21/Fxa3LCvik_720x0__1.jpg",
            "https://media.ambito.com/p/a77b4952d32ae7e114887595a56d728d/adjuntos/239/imagenes/040/084/0040084604/730x0/smart/elefante-verde-fluopng.png",
            "https://www.clarin.com/img/2022/06/21/milo-lockett-lanzo-el-miloverso___55ZCvS30s_2000x1500__1.jpg",
            "https://miloverso.io/img/nft-02.jpg",
            "https://i0.wp.com/elplanetaurbano.com/wp-content/uploads/2022/08/Milo-Lockett-18-copia.jpg?resize=640%2C640&ssl=1",
            "https://i0.wp.com/elplanetaurbano.com/wp-content/uploads/2022/08/Milo-Lockett-21-copia.jpg",)

        var selectedImg:String = getRandomItem(options)
        return selectedImg
    }
    fun getTipos(): List<Tipo> {
        var tipos:List<Tipo> = listOf<Tipo>(tipoPlanta,tipoAgua,tipoFuego,tipoVeneno,tipoElectrico)
        return tipos
    }

    fun getBulbasaur():Bulbasaur{
        var bulbasaur: Bulbasaur = Bulbasaur(1,"bulbasaur",tipoPlanta,tipoVeneno,
            318,49,49,6.9,0.7,5,
            listOf("ivysaur","venasaur"),
            "A Bulbasaur es fácil verle echándose una siesta al sol. " +
                    "La semilla que tiene en el lomo va creciendo cada vez más a medida que absorbe " +
                    "los rayos del sol."
            ,2)
        return bulbasaur
    }
    fun getCharmander():Charmander{
        var charmander: Charmander = Charmander(4,"charmander",tipoFuego,null,309,52,43,8.5,0.6,10,
            listOf("charmeleon","charizard"),"La llama que tiene en la punta de la cola arde según sus sentimientos. " +
                    "Llamea levemente cuando está alegre y arde vigorosamente cuando está enfadado.","normal")
        return charmander
    }

    fun getPikachu():Pikachu{
        var pikachu: Pikachu = Pikachu(25,"pikachu",tipoElectrico,null,320,55,40,6.0,0.4,20,
            listOf("raichu"),"Cada vez que un Pikachu se encuentra con algo nuevo, le lanza una descarga eléctrica. Cuando " +
                    "se ve alguna baya chamuscada, es muy probable que sea obra de un Pikachu, ya que a veces no controlan la intensidad de la descarga.","alta")
        return pikachu
    }

    fun getSquirtle():Squirtle{
        var squirtle: Squirtle = Squirtle(7,"squirtle",tipoAgua,null,314,48,65,9.0,0.5,8,
            listOf("wartortle","blastoise"),"\tEl caparazón de Squirtle no le sirve de protección únicamente. Su forma " +
                    "redondeada y las hendiduras que tiene le ayudan a deslizarse en el agua y le permiten nadar a gran velocidad.","media")
        return squirtle
    }

    fun getAsh():EntrenadorPokemon{
        var ash: EntrenadorPokemon = EntrenadorPokemon(24,"Ash","Ketchum","https://nintendosoup.com/wp-content/uploads/2019/04/Mewtwo-Strikes-Back-Evolution-Ash.jpg")
        ash.aPokemones= arrayListOf(getPikachu(),getBulbasaur())
        return ash
    }

    fun getSonia():EntrenadorPokemon{
        var pokedexSonia = Pokedex(4,arrayListOf(getCharmander(),getSquirtle()))
        var sonia:EntrenadorPokemon = EntrenadorPokemon(15,"Sonia","Daysutke","https://http2.mlstatic.com/D_NQ_NP_745758-MLM29706906187_032019-O.jpg", pokedexSonia,arrayListOf(getCharmander(),getSquirtle()))

        return sonia
    }

    fun getCampoBatalla(pokemon1:Pokemon, pokemon2:Pokemon):CampoDeBatalla{
        var campoDeBatalla :CampoDeBatalla = CampoDeBatalla(45,"Liga naranja","Meseta Añil",
            arrayListOf(pokemon1,pokemon2))
        return campoDeBatalla
    }



}