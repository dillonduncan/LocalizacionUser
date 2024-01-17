package com.example.localizacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.localizacion.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val locationService: LocationService = LocationService()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLocation.setOnClickListener {
            getLocationUser()
        }
    }

    fun getLocationUser() {
        lifecycleScope.launch {
            val result = locationService.getUserLocation(this@MainActivity)
            if (result!=null){
                binding.txtLocation.text="Latitud ${result.latitude} y longitud ${result.longitude}"
            }
        }
    }
}