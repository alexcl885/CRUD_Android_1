package com.example.aplicacioncrud.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacioncrud.R

import com.example.primeraaplicacion.logic.Controller
import com.example.primeraaplicacion.logic.interfaces.OperationInterface


class MainActivity : AppCompatActivity() , OperationInterface {

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
            ClienAdd(id, name, apellidos,tfn) }
            ,{
                id, name, apellidos, tfn ->
                ClienUpdate(id,name, apellidos, tfn)
            },{
                id ->
                ClienDel(id)
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

     override fun ClienAdd(id: Int, name: String, apellidos: String, tlf: Int) {
         var msg = ""
        val anadir = controller.clientAddController(id,name, apellidos, tlf)

         msg = if (anadir)
             "El cliente con id = $id, ha sido añadido correctamente"
         else
             "El cliente con id = $id, no ha sido encontrado para añadir"

         Log.d(TAG_ADD, msg)//se muestra en el log lo que esta pasando
         showConsoleData(msg)
     }

     override fun ClienDel(id: Int) {
         var msg = ""
         val controller = Controller()
         val delete = controller.clienDeleteController(id)  //borramos

         msg = if (delete)
             "El cliente con id = $id, ha sido eliminado correctamente"
         else
             "El cliente con id = $id, no ha sido encontrado para eliminar"

         Log. d(TAG_DELETE, msg)
         showConsoleData(msg)
     }

     override fun ClienUpdate(id: Int, name: String, apellidos: String, tlf: Int) {
         var msg =  ""
         val controller = Controller()
         val update = controller.clientUpdateController(id, name, apellidos, tlf)  //borramos el 2.

         msg = if (update)
             "El cliente con id = $id, ha sido actualizado correctamente"
         else
             "El cliente con id = $id, no ha sido encontrado para actualizar"

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
