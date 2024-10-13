package com.example.primeraaplicacion.logic

import com.example.primeraaplicacion.data.RepositoryClient
import kotlin.random.Random

class Controller {
    private var myListClient : MutableList<Client>

    private val repositoryClient = RepositoryClient()

    init {
        myListClient = repositoryClient.listClient.toMutableList();
    }
    fun clientAddController(id:Int, name: String, apellidos: String, tlf: Int): Boolean{
        var cli: Client = Client(id, name,apellidos, tlf )
        return myListClient.add(cli)
    }
    fun clienDeleteController(id: Int) : Boolean= myListClient.removeAll{it.id == id}

    fun clientUpdateController(id:Int, name: String, apellidos: String, tlf:Int): Boolean {
        val findClient : Client? = myListClient.find{it.id == id}
        return findClient?.let {
            it.name = name
            it.apellidos = apellidos
            it.tfn = tlf
            true
        }?: false
    }
    fun showData() = myListClient.toString()

    fun devIdRandom() : Int{//devuelve un id random
        return if (myListClient.size == 0){
            -1
        }else{
            val p = Random.nextInt(0, myListClient.size)
            myListClient[p].id
        }
    }
    /**
     * Creamos un numero de telefono random
     * */
    fun devTfnRandom() : Int{
        val tfn_random = Random.nextInt(1000000, 9999999)
        return  tfn_random
    }

}