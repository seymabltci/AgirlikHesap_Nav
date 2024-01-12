package com.seyma.agirlikhesap_nav
/*
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class MalzemelerAdapter (private val mcontext:Context, private val  malzemeListesi:List<Malzemeler>):RecyclerView.Adapter<MalzemelerAdapter.CardTasarimNesneleriTutucu>() {

    inner class CardTasarimNesneleriTutucu(view:View):RecyclerView.ViewHolder(view){

        var imageViewMil: ImageView
        var buttonMil: Button

        init {
            imageViewMil = view.findViewById(R.id.imageViewMil)
            buttonMil = view.findViewById(R.id.buttonMil)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimNesneleriTutucu {
        val tasarim = LayoutInflater.from(mcontext).inflate(R.layout.fragment_anasayfa,parent,false)
        return CardTasarimNesneleriTutucu(tasarim)
    }

    override fun getItemCount(): Int { //kactane malzeme göstericegini soruyor
        return malzemeListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriTutucu, position: Int) { //
        val malzeme = malzemeListesi[position]

        holder.imageViewMil.setImageResource(mcontext.resources.getIdentifier(malzeme.malzeme_resim,"drawable", mcontext.packageName))

        holder.buttonMil.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.anasayfaToMil)
        }
    }


} */