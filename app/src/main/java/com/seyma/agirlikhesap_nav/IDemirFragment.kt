package com.seyma.agirlikhesap_nav

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.seyma.agirlikhesap_nav.databinding.FragmentIDemirBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


class IDemirFragment : Fragment() {

    lateinit var binding: FragmentIDemirBinding

    lateinit var iDemirListesi: spinnerIdemir
    lateinit var idetayListesi: spinnerIdetay
    lateinit var ipedemir: String
        @SuppressLint("SetTextI18n")
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

    binding = FragmentIDemirBinding.inflate(inflater, container, false)



    val kayitlarDao = kayitlardao(requireContext())




    iDemirListesi = spinnerIdemir(requireContext())
    iDemirListesi.idemirFonk(binding.spinnerIDemir)
    var idemir = "I/H Demir Seçiniz"




    iDemirListesi.setIDemir(object : spinnerIdemir.OnIDemirChangeListener{
    override fun onIDemirChanged(idemirturu: String) {
    idemir = idemirturu

        binding.TVidemir.text = idemir


        if (idemir == "I/H Demir Seçiniz") {
            binding.spinnerIPE.isVisible = false
        }
        else{
            binding.spinnerIPE.isVisible = true
        }

        idetayListesi = spinnerIdetay(requireContext())
        idetayListesi.idetayFonk(binding.spinnerIPE)

        idetayListesi.setIdetayDemir(object : spinnerIdetay.OnIdetayChangeListener{
            override fun onIdetayChanged(idetayturu: String) {
                ipedemir = idetayturu

            } })




        when (idemir) {
            "IPE" -> {
                idetayListesi.ekleIpeListesi()
            }
            "IPN" -> {
                idetayListesi.ekleIpnListesi()
            }
            "HE A" -> {
                idetayListesi.ekleHeaListesi()
            }
            "HE B" -> {
                idetayListesi.ekleHebListesi()
            }
            "HE M" -> {
                idetayListesi.ekleHemListesi()
            }

        }



    }})





        binding.buttonHesapla.setOnClickListener {

            var yukseklik = 0
            var genislik = 0
            var toplam: Double? = 0.0
            val formattedValue2: String?
            val formattedValue: String
            var etKalinligit = 0.0
            var etKalinligis = 0.0
            var yaricap =0.0
            var agirlik=0.0

            val uzunluk = binding.profilUzunlukGiris.text.toString().toDoubleOrNull()
            val adet = binding.adetGiris.text.toString().toIntOrNull()



            val properties = getIDemirProperties(ipedemir)

            properties?.let { ip ->
                yukseklik = ip.height
                genislik = ip.width
                etKalinligit = ip.thicknessT
                etKalinligis = ip.thicknessS
                yaricap = ip.radius
                agirlik = ip.agirlik
            }



            if (uzunluk != null) {
                agirlik = agirlik * uzunluk
                /*
                                val alan =
                                    ((2 * (genislik * etKalinligis)) + ((yukseklik - (2 * etKalinligis)) * etKalinligit)+ (yaricap*yaricap))




                                if (binding.spinnerOlcu.selectedItemPosition === 0) {
                                    agirlik = agirlik / 1000 / 1000
                                } else {
                                    agirlik /= 1000
                                }*/

                val df = DecimalFormat("#.###")
                val symbols = DecimalFormatSymbols().apply {
                    decimalSeparator = ',' // Virgülü ayarla
                }
                df.decimalFormatSymbols = symbols
                df.roundingMode = RoundingMode.CEILING
                formattedValue = df.format(agirlik)

                if (adet != null) {
                    toplam = agirlik * adet
                    formattedValue2 = df.format(toplam)
                    binding.textViewToplamSonuc.text =
                        "Toplam Ağırlık: $formattedValue2 Kg"
                    binding.textViewToplamSonuc.isVisible = true

                }

                binding.textViewSonuc.text = "Birim Ağırlık: $formattedValue Kg"



                binding.textViewSonuc.isVisible = true
                binding.buttonTeklif.isVisible = true



                binding.buttonTeklif.setOnClickListener {
                    Toast.makeText(requireContext(), "Eklendi.", Toast.LENGTH_SHORT)
                        .show()

                    if(idemir=="HE A"){
                        // Veritabanına kayıt ekleme işlemi gerçekleştiriliyor
                        kayitlarDao.ekle(
                            "$idemir ${genislik}",
                            "Çelik",
                            "mm",
                            agirlik,
                            toplam ?: 0.0,
                            adet ?: 0,
                            uzunluk,
                            etKalinligit,
                            0.0,
                            genislik.toDouble(),
                            yukseklik.toDouble()
                        )
                    }
                    else{
                        kayitlarDao.ekle(
                            "$idemir ${yukseklik}",
                            "Çelik",
                            "mm",
                            agirlik,
                            toplam ?: 0.0,
                            adet ?: 0,
                            uzunluk,
                            etKalinligit,
                            0.0,
                            genislik.toDouble(),
                            yukseklik.toDouble()
                        )
                    }




                }


            } else {
                Toast.makeText(
                    requireContext(),
                    "Alanlar boş bırakılmaz.",
                    Toast.LENGTH_LONG
                ).show()
            }


        }


        binding.buttonReset.setOnClickListener {
            binding.profilUzunlukGiris.setText("")
            binding.adetGiris.setText("")
            binding.textViewSonuc.isVisible = false
            binding.buttonTeklif.isVisible = false
            binding.textViewToplamSonuc.isVisible = false
            binding.spinnerIDemir.setSelection(
                iDemirListesi.veriAdaptoru.getPosition(
                    "I/H Demir Seçiniz"
                )
            )
            binding.spinnerIPE.setSelection(idetayListesi.veriAdaptoru.getPosition("IPE 80 (80X46)"))
          //  binding.spinnerIPN.setSelection(ipnListesi.veriAdaptoru.getPosition("IPN 80 (80X42)"))
        }
        binding.buttonBack.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java)) //back butonuna basınca gidecegi sayfayı gösterir
        }





    return binding.root
}
}
