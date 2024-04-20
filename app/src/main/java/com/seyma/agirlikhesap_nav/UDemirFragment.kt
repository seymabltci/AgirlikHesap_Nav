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
import com.seyma.agirlikhesap_nav.databinding.FragmentUDemirBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


class UDemirFragment : Fragment() {
    lateinit var binding: FragmentUDemirBinding
    lateinit var uDemirListesi: spinnerUdemir
    lateinit var udetayListesi: spinnerUdetay
    lateinit var upedemir: String
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentUDemirBinding.inflate(inflater, container, false)



        val kayitlarDao = kayitlardao(requireContext())


        uDemirListesi = spinnerUdemir(requireContext())
        uDemirListesi.udemirFonk(binding.spinnerUDemir)
        var udemir = "I/H Demir Seçiniz"




        uDemirListesi.setUDemir(object : spinnerUdemir.OnUDemirChangeListener{
            override fun onUDemirChanged(udemirturu: String) {
                udemir = udemirturu

                binding.TVidemir.text = udemir


                if (udemir == "U Demir Seçiniz") {
                    binding.spinnerUPE.isVisible = false
                }
                else{
                    binding.spinnerUPE.isVisible = true
                }

                udetayListesi = spinnerUdetay(requireContext())
                udetayListesi.UdetayFonk(binding.spinnerUPE)

                udetayListesi.setUdetayDemir(object : spinnerUdetay.OnUdetayChangeListener{
                    override fun onUdetayChanged(udetayturu: String) {
                        upedemir = udetayturu

                    } })




                when (udemir) {
                    "UPE" -> {
                        udetayListesi.ekleUpeListesi()
                    }
                    "UPN" -> {
                        udetayListesi.ekleUpnListesi()
                    }


                }



            }})

        binding.buttonHesapla.setOnClickListener {

            var yukseklik = 0.0
            var genislik = 0.0
            var toplam: Double? = 0.0
            val formattedValue2: String?
            val formattedValue: String
            var etKalinligit = 0.0
            var etKalinligis = 0.0
            var yaricap =0.0
            var agirlik=0.0

            val uzunluk = binding.profilUzunlukGiris.text.toString().toDoubleOrNull()
            val adet = binding.adetGiris.text.toString().toIntOrNull()



            val properties = getUDemirProperties(upedemir)

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


                    // Veritabanına kayıt ekleme işlemi gerçekleştiriliyor
                    kayitlarDao.ekle(
                        udemir,
                        "Çelik",
                        "mm",
                        agirlik,
                        toplam ?: 0.0,
                        adet ?: 0,
                        uzunluk,
                        etKalinligit,
                        0.0,
                        genislik,
                        yukseklik
                    )


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
            binding.spinnerUDemir.setSelection(
                uDemirListesi.veriAdaptoru.getPosition(
                    "I/H Demir Seçiniz"
                )
            )
            binding.spinnerUPE.setSelection(udetayListesi.veriAdaptoru.getPosition("IPE 80 (80X46)"))
            //  binding.spinnerIPN.setSelection(ipnListesi.veriAdaptoru.getPosition("IPN 80 (80X42)"))
        }
        binding.buttonBack.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java)) //back butonuna basınca gidecegi sayfayı gösterir
        }





        return binding.root
    }
}