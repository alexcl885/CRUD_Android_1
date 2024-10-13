package com.example.primeraaplicacion.logic.interfaces

interface OperationInterface {

    fun ClienAdd (id:Int, name: String, apellidos: String, tlf: Int)
    fun ClienDel (id :Int)
    fun ClienUpdate (id :Int, name: String, apellidos: String, tfn: Int)
}