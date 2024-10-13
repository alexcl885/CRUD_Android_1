package com.example.aplicacioncrud.view

import com.example.primeraaplicacion.data.RepositoryClient
import com.example.primeraaplicacion.logic.Controller

class Dialog(
    var controller: Controller, var clientAdd: (Int, String, String, Int) -> Unit,
    var clientUpdate: (Int, String, String, Int) -> Unit,
    var clientDelete:(Int) ->Unit)
{


    private var action : Int = 0


    //muestra el dialogo
    fun show(typeAction : Int){
        var posibleCambio ="CAMBIADO"
        val posibleId = controller.devIdRandom()
        val posibleNumTfn = controller.devTfnRandom()
        when (typeAction){
            0 -> onAccept() //simulamos que ahora pulsamos el botón aceptar de un nuevo

            1 ->
                if (posibleId != -1)
                    onEdit(posibleId, "CAMBIADO","Apellido", posibleNumTfn)

            2 ->
                if (posibleId != -1)
                    onDelete(posibleId)
        }

    }

    private fun onDelete(id : Int) {
        clientDelete(id)
    }

    private fun onEdit(id: Int, name : String, apellidos: String, tfn: Int) {
        clientUpdate(id, name, apellidos, tfn)
    }

    //simula el pulsado del botón aceptar del dialogo. Este recoge los datos del usuario.
    private fun onAccept() {
        val repositoryClient = RepositoryClient()
       clientAdd(repositoryClient.incrementarPrimary(), "Creado","Creado",0)
    }




}