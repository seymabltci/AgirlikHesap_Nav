package com.seyma.agirlikhesap_nav

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.seyma.agirlikhesap_nav.databinding.FragmentAnasayfaBinding


class AnasayfaFragment: Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    lateinit var malzemeListesi: List<Malzemeler>
    class MalzemelerAdapter(
        private val mcontext: Context,
        var malzemeListesi: List<Malzemeler>):RecyclerView.Adapter<MalzemelerAdapter.CardTasarimNesneleriTutucu>() {
        inner class CardTasarimNesneleriTutucu(view: View) : RecyclerView.ViewHolder(view) {

            var imageViewMil: ImageView
            var buttonMil: Button

            init {
                imageViewMil = view.findViewById(R.id.imageViewMil)
                buttonMil = view.findViewById(R.id.buttonMil)
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CardTasarimNesneleriTutucu {
            val tasarim =
                LayoutInflater.from(mcontext).inflate(R.layout.fragment_anasayfa, parent, false)
            return CardTasarimNesneleriTutucu(tasarim)
        }

        override fun getItemCount(): Int { //kactane malzeme göstericegini soruyor
            return malzemeListesi.size
        }

        override fun onBindViewHolder(holder: CardTasarimNesneleriTutucu, position: Int) { //
            val malzeme = malzemeListesi[position]

            holder.imageViewMil.setImageResource(
                mcontext.resources.getIdentifier(
                    malzeme.malzeme_resim,
                    "drawable",
                    mcontext.packageName
                )
            )

            holder.buttonMil.setOnClickListener {

                Navigation.findNavController(it).navigate(R.id.anasayfaToMil)
            }
        }


    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)



        return binding.root
    }


    // MainActivity'e bir referans almak için bir yöntem ekle
    fun setMainActivityReference(mainActivity: MainActivity) {
        MalzemelerAdapter(mainActivity,malzemeListesi )


        // Burada MainActivity tarafından kullanılacak referansları saklayabilirsiniz
    }
}


        /* binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonMil.setOnClickListener { //bil butonuna tıklandıgındaa
            Navigation.findNavController(it).navigate(R.id.anasayfaToMil) //bu ID navigation klasöründeki main_activity_nav geçiş ID sidir.
        //Bu, it ifadesiyle belirtilen View üzerinden NavController'ı bulur.
        // NavController, fragment geçişleri ve navigasyon işlemlerini yöneten bir sınıftır.



        }
        return binding.root */

