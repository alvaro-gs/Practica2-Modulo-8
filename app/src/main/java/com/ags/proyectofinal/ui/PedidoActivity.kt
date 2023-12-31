package com.ags.proyectofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ags.proyectofinal.R
import com.ags.proyectofinal.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fgContainerView, ListaPedidosFragment())
                .commit()
        }


        binding.bottomNavigationView.setOnItemReselectedListener{menu ->
            when(menu.itemId){


            }
        }

    }
}