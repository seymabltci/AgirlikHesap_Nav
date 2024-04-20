package com.seyma.agirlikhesap_nav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.seyma.agirlikhesap_nav.databinding.FragmentKosebentBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


class KosebentFragment : Fragment() {

    lateinit var binding: FragmentKosebentBinding
    lateinit var materyalList: MateryalListesi
    lateinit var olcuListesi: OlcuListesi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentKosebentBinding.inflate(inflater, container, false)
        materyalList = MateryalListesi(requireContext())
        materyalList.yogunlukFonk( binding.spinnerIn)

        val kayitlarDao = kayitlardao(requireContext())

        olcuListesi = OlcuListesi(requireContext())
        olcuListesi.olcuFonk(binding.spinnerOlcu)
        var birim = "mm"
        olcuListesi.setOlcu(object : OlcuListesi.OnOlcuChangeListener{
            override fun onOlcuChanged(olcu: String) {
                binding.olcu1.text  = olcu
                binding.olcu2.text = olcu
                binding.olcu3.text  = olcu
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

                    val genislik = binding.GenislikGiris.text.toString().toDoubleOrNull()
                    val yukseklik = binding.YukseklikGiris.text.toString().toDoubleOrNull()
                    val uzunluk = binding.UzunlukGiris.text.toString().toDoubleOrNull()
                    val etKalinligi = binding.EtKalGiris.text.toString().toDoubleOrNull()
                    var adet = binding.adetGiris.text.toString().toIntOrNull()
                    var toplam: Double? = 0.0
                    var formattedValue2 : String? = ""
                    var formattedValue : String

                    if( uzunluk != null && genislik!= null && yukseklik!= null&& etKalinligi!=null) {

                        val alan = (genislik*etKalinligi)+((yukseklik-etKalinligi)*etKalinligi)

                        var agirlik: Double = alan * uzunluk * yogunluk


                        if (binding.spinnerOlcu.selectedItemPosition===0)
                        {
                            agirlik=agirlik/1000/1000
                        }
                        else {
                            agirlik= agirlik/1000
                        }

                        val df = DecimalFormat("#.##")
                        val symbols = DecimalFormatSymbols().apply {
                            decimalSeparator = ',' // Virgülü ayarla
                        }
                        df.decimalFormatSymbols = symbols
                        df.roundingMode = RoundingMode.CEILING
                        formattedValue = df.format(agirlik)

                        if(adet != null )  {
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
                                "Köşebent",
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

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Alanlar boş bırakılmaz.",
                            Toast.LENGTH_LONG).show()
                    }
                }
                binding.buttonReset.setOnClickListener {
                    binding.UzunlukGiris.setText("")
                    binding.GenislikGiris.setText("")
                    binding.EtKalGiris.setText("")
                    binding.adetGiris.setText("")
                    binding.textViewSonuc.isVisible = false
                    binding.buttonTeklif.isVisible = false
                    binding.textViewToplamSonuc.isVisible = false
                    binding.spinnerIn.setSelection(materyalList.veriAdaptoru.getPosition("Demir")) //resete tıklanınca spinner degeri demir olsun
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
