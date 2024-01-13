package com.seyma.agirlikhesap_nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.seyma.agirlikhesap_nav.databinding.FragmentAnasayfaBinding


class AnasayfaFragment: Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonMil.setOnClickListener { //bil butonuna tıklandıgındaa
            Navigation.findNavController(it)
                .navigate(R.id.anasayfaToMil) //bu ID navigation klasöründeki main_activity_nav geçiş ID sidir.
            //Bu, it ifadesiyle belirtilen View üzerinden NavController'ı bulur.
            // NavController, fragment geçişleri ve navigasyon işlemlerini yöneten bir sınıftır.
        }
        return binding.root
    }
}