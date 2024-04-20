package com.seyma.agirlikhesap_nav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.seyma.agirlikhesap_nav.databinding.FragmentMilBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class MilFragment : Fragment() {
    lateinit var binding: FragmentMilBinding //ViewBinding kullanılarak oluşturulmuş bir FragmentMilBinding nesnesini temsil eder. layout dosyasına erişmek için
    lateinit var materyalList: MateryalListesi //Malzeme sınıfından bir nesne
    lateinit var olcuListesi: OlcuListesi

    //lateinit bu nesnelerin gec başlayacagını bildirir. lateinit tanımlanan değişkenin ilk degeri olmayabilir.
    //kullanmadan önce başaltılması gerekir. (uygulama direkt düşüyorsa lateinitler başlatılmamış olabilir!!!
    //hata ismi "UninitializedPropertyAccessException"

    //her seferinde yeniden nesnesi oluşturmaması için nesneler override dısına oluşturulur

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentMilBinding.inflate(inflater, container, false)
        materyalList = MateryalListesi(requireContext())
        olcuListesi = OlcuListesi(requireContext())

        //MateryalListesi sınıfını oluştur ve bağlamını ayarlaparametresini gir
        // lateinit var materyalList: başlatılmış olur
        // "requireContext()" fragmentler için kullanılan contexttir
        materyalList.yogunlukFonk( binding.spinnerIn)
        olcuListesi.olcuFonk(binding.spinnerOlcu)
        var birim= "seyma"

        val kayitlarDao = kayitlardao(requireContext())

       olcuListesi.setOlcu(object : OlcuListesi.OnOlcuChangeListener{
           override fun onOlcuChanged(olcu: String) {
               binding.olcu1.text = olcu
               binding.olcu2.text  = olcu
               birim = olcu
           }
       })
                materyalList.setYogunluk(object : MateryalListesi.OnYogunlukChangeListener{
                    //Yogunluk değişikliğini dinleyen bir listener tanımlandı

                override fun onYogunlukChanged(yogunluk: Double){
                        //yogunluk değiştiginde yapılacak işlemler
                    binding.TextViewMateryal.text = "$yogunluk  g/cm3"
                    var  materyal = materyalList.secilenOge
                    binding.TVMateryalAd.text = materyal


                binding.buttonHesapla.setOnClickListener {

                val pi = 3.14159
                var cap = binding.milCapGiris.text.toString().toDoubleOrNull()
                val uzunluk = binding.milUzunlukGiris.text.toString().toDoubleOrNull()
                var adet = binding.adetGiris.text.toString().toIntOrNull()
                var toplam: Double? = 0.0
                var formattedValue2 : String? =""
                var formattedValue : String

                if(cap != null && uzunluk != null) {

                var yariCap : Double = cap / 2
                val daireAlan = pi * yariCap * yariCap

                var agirlik: Double = daireAlan * uzunluk * yogunluk


                  if (binding.spinnerOlcu.selectedItemPosition===0)
                  {
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
                            "Mil",
                            materyal,
                            birim,
                            agirlik,
                            toplam ?: 0.0,
                            adet ?: 0,
                            uzunluk,
                            0.0,
                            cap,
                            0.0,
                            0.0
                        )
                    }

                }
                else{
                Toast.makeText(
                requireContext(),
                "Alanlar boş bırakılamaz.",
                Toast.LENGTH_LONG).show()
                    }
                }

                        binding.buttonReset.setOnClickListener {
                            binding.milCapGiris.setText("")
                            binding.milUzunlukGiris.setText("")
                            binding.adetGiris.setText("")
                            binding.textViewSonuc.isVisible = false
                            binding.buttonTeklif.isVisible = false
                            binding.textViewToplamSonuc.isVisible = false
                            binding.spinnerIn.setSelection(materyalList.veriAdaptoru.getPosition("Çelik")) //resete tıklanınca spinner degeri demir olsun
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

