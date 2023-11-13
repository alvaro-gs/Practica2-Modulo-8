package com.ags.proyectofinal.ui

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ags.proyectofinal.R
import com.ags.proyectofinal.databinding.ActivityMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.Manifest
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback

class MapActivity : AppCompatActivity(),OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding

    private lateinit var map: GoogleMap

    private var latitud = 0.0
    private var longitud = 0.0
    private var nombre = ""
    private var categoria = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("EXTRA_BUNDLE")
        bundle.let {
            if (it != null) {
                latitud = it.getDouble("latitud",0.0)
                longitud = it.getDouble("longitud",0.0)
                nombre = it.getString("nombre","")
                categoria = it.getString("categoria","")
            }
        }

        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker(LatLng(latitud, longitud))
        map.setOnMapLongClickListener { position ->
            val marker = MarkerOptions()
                .position(position)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cake))
            map.addMarker(marker)
        }
    }

    private fun createMarker(coordinates: LatLng){
        val marker = MarkerOptions()
            .position(coordinates)
            .title(nombre)
            .snippet(categoria)
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.cake))

        map.addMarker(marker)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 18f))

    }

    override fun onRestart() {
        super.onRestart()
        if(!::map.isInitialized) return
    }

}