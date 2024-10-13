package com.example.aplicacioncrud.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacioncrud.R
import com.example.primeraaplicacion.logic.Client

import com.example.primeraaplicacion.logic.Controller



class MainActivity : AppCompatActivity() {

    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDelete: ImageView
    private lateinit var myDialog : Dialog
    private  var controller: Controller = Controller()

     companion object{
         const val NORMAL_TAG = "---SALIDA---"
         const val TAG_ADD = "---PERSONA ANADIDA---"
         const val TAG_UPDATE = "---PERSONA ACTUALIZADA---"
         const val TAG_DELETE = "---PERSONA ELIMINADA---"
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() barra superior transparent. App de borde a borde
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        start()
    }
    private fun start(){
        myButtonAdd = findViewById(R.id.iv_add)
        myButtonUpdate = findViewById(R.id.iv_edit)
        myButtonDelete = findViewById(R.id.iv_delete)
        myDialog = Dialog(controller, {
                id, name, apellidos, tfn ->
            anadirCliente(id, name, apellidos,tfn) }
            ,{
                id, name, apellidos, tfn ->
                actualizarCliente(id,name, apellidos, tfn)
            },{
                id ->
                borrarCliente(id)
            })



        myButtonAdd.setOnClickListener{

            myDialog.show(0)
        }

        myButtonUpdate.setOnClickListener{
            myDialog.show(1)

        }

        myButtonDelete.setOnClickListener {
            myDialog.show(2)

        }
    }
//    EN VEZ DE UTILIZAR LA INTERFAZ, CREAMOS FUNCIONES PARA AÑADIR, ACTUALIZAR O BORRAR EL CLIENTE
    fun anadirCliente(id: Int, name: String, apellidos: String, tfn: Int){

        controller.clientAddController(id, name, apellidos, tfn)
        var msg =  "El cliente con id = $id, ha sido insertado correctamente"

        Log.d(TAG_ADD, msg)
        showConsoleData(msg)
    }

    fun borrarCliente(id: Int) {
        var msg = ""
        val delete = controller.clienDeleteController(id)  //borramos

        if (delete)
            msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG_DELETE, msg)
        showConsoleData(msg)

    }



    fun actualizarCliente(id: Int, name: String, apellidos:String, tfn: Int) {
        var msg = ""
        val update = controller.clientUpdateController(id, name, apellidos, tfn)  //borramos el 2.

        if (update)
            msg =  "El cliente con id = $id, ha sido actualizado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para actualizar"

        Log. d(TAG_UPDATE, msg)
        showConsoleData(msg)

    }


     fun showConsoleData(msg:String){
         val controller = Controller()

         val msg = controller.showData()
         Thread.sleep(2000)
         Log. d(NORMAL_TAG, msg)
     }
 }
