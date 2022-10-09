package com.miempresa.demowhatsapp

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Elementos>()
        for (i in 1 until 10){
            llenarLista.add(Elementos("Contacto "+i,
            "Contancto"+i+": Mensaje "+i,
            BitmapFactory.decodeResource(resources,R.drawable.imagen2)))
        }
        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.getItemId()
        if (id == R.id.ajustes){
            val llamaractividad = Intent(applicationContext,Ajustes::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.acerca){
            //Toast.makeText(this,"Elegiste menu informacion",Toast.LENGTH_SHORT).show();
            val llamaractividad = Intent(applicationContext,Acerca::class.java)
            startActivity(llamaractividad)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}