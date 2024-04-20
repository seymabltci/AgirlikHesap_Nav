package com.seyma.agirlikhesap_nav

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.seyma.agirlikhesap_nav.databinding.FragmentIletisimBinding

class IletisimFragment : Fragment(){
    private lateinit var binding: FragmentIletisimBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentIletisimBinding.inflate(inflater, container, false)

        binding.toolbar3.title = ("     İletişim Bilgileri")
        binding.toolbar3.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        val tabLayout  = binding.tabLayout


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Seçilen tabı kontrol edin
                val position = tab?.position

                // Hangi tabın seçildiğine bağlı olarak farklı işlemler yapabilirsiniz
                when (position) {
                    0 -> {
                        binding.tvTelefon.text = "+90 (312) 814 40 04"
                        binding.tvAdres.text =   "Dağyaka Mah. 2002 Sk. No:5, Kahramankazan/Ankara"
                        binding.tvFax.text =     "+90 (312) 815 40 08"
                    }
                    1 -> {
                        binding.tvTelefon.text = "+90 (312) 395 40 04"
                        binding.tvAdres.text =   "Arı San. Sit. 1473 Sk. No:75, İvedik OSB/Ankara"
                        binding.tvFax.text =     "+90 (312) 815 40 06"
                    }
                    2 -> {
                        binding.tvTelefon.text = "+90 (312) 350 51 95"
                        binding.tvAdres.text =   "Altınevler mah. Turgut Özal 2 Blv. No: 140, Mamak/Ankara"
                        binding.tvFax.text =     "+90 (312) 350 06 78"
                    }
                    3 -> {
                        binding.tvTelefon.text = "+90 (312) 815 16 36"
                        binding.tvAdres.text =   "Saray Mah. Keresteciler San. Sit. 4 sk. No:24,Kahramankazan/Ankara"
                        binding.tvFax.text =     "+90 (312) 815 15 27"
                    }
                    // Diğer tablar için gerekli işlemler buraya eklenebilir
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Tab değiştirildiğinde yapılacak işlemler (opsiyonel)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Zaten seçili olan bir taba tekrar tıklandığında yapılacak işlemler (opsiyonel)
            }
        })





        binding.btnBack.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java)) //back butonuna basınca gidecegi sayfayı gösterir
        }

        return binding.root
    }

}