package com.seyma.agirlikhesap_nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.seyma.agirlikhesap_nav.databinding.FragmentAnasayfaBinding


class AnasayfaFragment: Fragment() , RecyclerViewItemClickListener {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var malzemelerList : ArrayList<Malzemeler>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)



        malzemelerList = ArrayList<Malzemeler>()

        val boru = Malzemeler("BORU",R.drawable.boru_icon)
        val mil = Malzemeler("MİL",R.drawable.mil_icon)
        val profil = Malzemeler("PROFİL", R.drawable.profil_icon)
        val kare = Malzemeler("KARE DEMİR", R.drawable.kare_demir)
        val silme = Malzemeler("SİLME/LAMA", R.drawable.silme_lama_demir)
        val kosebent = Malzemeler("KÖŞEBENT", R.drawable.kosebent)
        val sac = Malzemeler("SAC", R.drawable.sac)
        val tdemir = Malzemeler("T DEMİR", R.drawable.tdemir)
        val idemir = Malzemeler("I/H DEMİR", R.drawable.idemir)
        val udemir = Malzemeler("U DEMİR", R.drawable.udemir)

        malzemelerList.add(boru)
        malzemelerList.add(mil)
        malzemelerList.add(profil)
        malzemelerList.add(kare)
        malzemelerList.add(silme)
        malzemelerList.add(kosebent)
        malzemelerList.add(sac)
        malzemelerList.add(tdemir)
        malzemelerList.add(idemir)
        malzemelerList.add(udemir)

        binding.RecyclerView.layoutManager = LinearLayoutManager(context)


        val malzemelerAdapter = RecyclerAdapter(malzemelerList, this)
        binding.RecyclerView.adapter = malzemelerAdapter

        return binding.root
    }


        override fun onItemClicked(position: Int) {
            // Tıklanan öğenin pozisyonuna göre farklı sayfalara yönlendirme
            when (position) {
                0 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToBoru)
                }

                1 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToMil)
                }
                2 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToProfil)
                }
                3 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToKare)
                }
                4 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToSilme)
                }
                5 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToKosebent)
                }
                6 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToSac)
                }
                7 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToT)
                }
                8 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToI)
                }
                9 -> {
                    val navController = requireActivity().findNavController(R.id.navfragment)
                    navController.navigate(R.id.anasayfaToU)
                }

                else -> { println("secim yapılmadı") }

            }
        }
}
