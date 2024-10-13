package com.example.primeraaplicacion.data

import com.example.primeraaplicacion.logic.Client

class RepositoryClient {
    var primary = 100 //es el dni que inicializamos a 100

    val listClient : List<Client> = listOf(
        Client (incrementarPrimary(), "Alejandro", "Copado Lopez", 7777777),
        Client (incrementarPrimary(), "Marcos", "Arjona", 888888),
        Client (incrementarPrimary(), "Santi", "Rodenas Herraiz", 111111),
        Client (incrementarPrimary(), "Daniel", "Cornejo", 333333)
    )
    fun incrementarPrimary() = primary ++ // funcion que incrementa el id sucesivamente al crear un cliente

}