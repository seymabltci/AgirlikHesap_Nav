package com.seyma.agirlikhesap_nav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.seyma.agirlikhesap_nav.databinding.FragmentProfilBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
class ProfilFragment : Fragment() {
    lateinit var binding: FragmentProfilBinding
    lateinit var materyalList: MateryalListesi
    lateinit var olcuListesi: OlcuListesi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentProfilBinding.inflate(inflater, container, false)
        materyalList = MateryalListesi(requireContext())
        materyalList.yogunlukFonk( binding.spinnerIn)

        val kayitlarDao = kayitlardao(requireContext())

        olcuListesi = OlcuListesi(requireContext())
        olcuListesi.olcuFonk(binding.spinnerOlcu)
        var birim = "mm"
        olcuListesi.setOlcu(object : OlcuListesi.OnOlcuChangeListener{
            override fun onOlcuChanged(olcu: String) {
                binding.olcu1.text = olcu
                binding.olcu2.text  = olcu
                binding.olcu3.text = olcu
                binding.olcu4.text  = olcu
                birim = olcu

            }
        })
        materyalList.setYogunluk(object : MateryalListesi.OnYogunlukChangeListener{

            override fun onYogunlukChanged(yogunluk: Double){
                binding.TextViewMateryal.text="$yogunluk   g/cm3"
                var  materyal = materyalList.secilenOge
                binding.TVMateryalAd.text = materyal

                binding.buttonHesapla.setOnClickListener {

                    val yukseklik = binding.profilYukseklikGiris.text.toString().toDoubleOrNull()
                    val genislik = binding.profilGenisligiGiris.text.toString().toDoubleOrNull()
                    val uzunluk = binding.profilUzunlukGiris.text.toString().toDoubleOrNull()
                    val etKalinligi = binding.profilEtKGiris.text.toString().toDoubleOrNull()
                    var adet = binding.adetGiris.text.toString().toIntOrNull()
                    var toplam: Double? = 0.0
                    var formattedValue2 : String? = ""
                    var formattedValue : String

                    if(yukseklik != null && uzunluk != null && genislik!= null && etKalinligi!=null) {

                        val alan = (yukseklik*genislik)-((yukseklik-(2*etKalinligi))*(genislik-(2*etKalinligi)))
                        var agirlik: Double = alan * uzunluk * yogunluk

                        if (binding.spinnerOlcu.selectedItemPosition===0) {
                            agirlik=agirlik/1000/1000
                        }
                        else {
                            agirlik= agirlik/1000
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
                            binding.textViewToplamSonuc.text = "Toplam Ağırlık: $formattedValue2 Kg"
                            binding.textViewToplamSonuc.isVisible = true

                        }

                        binding.textViewSonuc.text = "Birim Ağırlık: $formattedValue Kg"
                        binding.textViewSonuc.isVisible = true
                        binding.buttonTeklif.isVisible = true



                        binding.buttonTeklif.setOnClickListener {
                            Toast.makeText(requireContext(), "Eklendi.", Toast.LENGTH_SHORT).show()



                            // Veritabanına kayıt ekleme işlemi gerçekleştiriliyor
                            kayitlarDao.ekle(
                                "Profil",
                                materyal,
                                birim,
                                agirlik,
                                toplam ?: 0.0,
                                adet ?: 0,
                                uzunluk,
                                etKalinligi,
                                0.0,
                                genislik,
                                yukseklik
                            )
                        }



                    }
                    else {
                        Toast.makeText(
                            requireContext(),
                            "Alanlar boş bırakılmaz.",
                            Toast.LENGTH_LONG).show()
                    }
                }
                binding.buttonReset.setOnClickListener {
                    binding.profilUzunlukGiris.setText("")
                    binding.profilYukseklikGiris.setText("")
                    binding.profilGenisligiGiris.setText("")
                    binding.profilEtKGiris.setText("")
                    binding.adetGiris.setText("")
                    binding.textViewSonuc.isVisible = false
                    binding.buttonTeklif.isVisible = false
                    binding.textViewToplamSonuc.isVisible = false
                    binding.spinnerIn.setSelection(materyalList.veriAdaptoru.getPosition("Demir"))
                    binding.spinnerOlcu.setSelection(olcuListesi.veriAdaptoru.getPosition("mm"))
                }
                binding.buttonBack.setOnClickListener {
                    startActivity(Intent(requireContext(), MainActivity::class.java)) //back butonuna basınca gidecegi sayfayı gösterir
                }

            }
        })

        return binding.root
    }
}
