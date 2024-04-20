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
import com.seyma.agirlikhesap_nav.databinding.FragmentBoruBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols



class BoruFragment : Fragment() {

    lateinit var binding: FragmentBoruBinding
    lateinit var materyalList: MateryalListesi
    lateinit var olcuListesi: OlcuListesi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {


        binding = FragmentBoruBinding.inflate(inflater, container, false)
        materyalList = MateryalListesi(requireContext())
        materyalList.yogunlukFonk( binding.spinnerIn)

        val kayitlarDao = kayitlardao(requireContext()) // Dao sınıfı nesnesi oluşturuluyor

        olcuListesi = OlcuListesi(requireContext())
        olcuListesi.olcuFonk(binding.spinnerOlcu)
        var birim ="mm"
        olcuListesi.setOlcu(object : OlcuListesi.OnOlcuChangeListener{
            override fun onOlcuChanged(olcu: String) {
                binding.olcu1.text = olcu
                binding.olcu2.text  = olcu
                binding.olcu3.text  = olcu
                birim = olcu
            }
        })

    materyalList.setYogunluk(object : MateryalListesi.OnYogunlukChangeListener{

    @SuppressLint("SetTextI18n")
    override fun onYogunlukChanged(yogunluk: Double) {

        binding.TextViewMateryal.text = "$yogunluk  g/cm3"
        var  materyal = materyalList.secilenOge
        binding.TVMateryalAd.text = materyal

        binding.buttonHesapla.setOnClickListener {
             val pi = 3.14159
             val cap = binding.boruCapGiris.text.toString().toDoubleOrNull()
             val etKalinligi = binding.boruEtKGiris.text.toString().toDoubleOrNull()
             val uzunluk = binding.boruUzunlukGiris.text.toString().toDoubleOrNull()
             var adet = binding.adetGiris.text.toString().toIntOrNull()
             var toplam: Double? = 0.0
             var formattedValue2 : String? = ""
             var formattedValue : String

             if (cap != null && uzunluk != null && etKalinligi != null) {

                val icCap = cap - (etKalinligi * 2)
                val boruAlan = pi * ((cap / 2) * (cap / 2) - ((icCap / 2) * (icCap / 2)))
                var agirlik = boruAlan * uzunluk * yogunluk


                if (binding.spinnerOlcu.selectedItemPosition === 0) {
                    agirlik = agirlik / 1000 / 1000
                } else {
                    agirlik = agirlik / 1000
                }

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
                    binding.textViewToplamSonuc.text = "Toplam Ağırlık: $formattedValue2 Kg "
                    binding.textViewToplamSonuc.isVisible = true

                    }

                    binding.textViewSonuc.text = "Birim Ağırlık: $formattedValue Kg "
                    binding.textViewSonuc.isVisible = true
                    binding.buttonTeklif.isVisible = true


                 binding.buttonTeklif.setOnClickListener {
                     Toast.makeText(requireContext(), "Eklendi.", Toast.LENGTH_SHORT).show()


                     // Veritabanına kayıt ekleme işlemi gerçekleştiriliyor
                     kayitlarDao.ekle(
                         "Boru",
                         materyal,
                         birim,
                         agirlik,
                         toplam ?: 0.0,
                         adet ?: 0,
                         uzunluk,
                         etKalinligi,
                         cap,
                         0.0,
                         0.0
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
                    binding.boruCapGiris.setText("")
                    binding.boruUzunlukGiris.setText("")
                    binding.boruEtKGiris.setText("")
                    binding.adetGiris.setText("")
                    binding.textViewSonuc.isVisible = false
                    binding.buttonTeklif.isVisible = false
                    binding.textViewToplamSonuc.isVisible = false
                    binding.spinnerIn.setSelection(materyalList.veriAdaptoru.getPosition("Demir"))
                    binding.spinnerOlcu.setSelection(olcuListesi.veriAdaptoru.getPosition("mm"))
                }
                binding.buttonBack.setOnClickListener {
                    startActivity(Intent(requireContext(), MainActivity::class.java))

                }


                }


        })
        return binding.root
    }
}