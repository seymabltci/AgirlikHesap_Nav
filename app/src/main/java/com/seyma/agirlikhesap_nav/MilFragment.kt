package com.seyma.agirlikhesap_nav

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.seyma.agirlikhesap_nav.databinding.FragmentMilBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MilFragment : Fragment() {
    lateinit var binding: FragmentMilBinding //ViewBinding kullanılarak oluşturulmuş bir FragmentMilBinding nesnesini temsil eder. layout dosyasına erişmek için
    lateinit var materyalList: MateryalListesi //Malzeme sınıfından bir nesne
    //lateinit bu nesnelerin gec başlayacagını bildirir. lateinit tanımlanan değişkenin ilk degeri olmayabilir.
    //kullanmadan önce başaltılması gerekir. (uygulama direkt düşüyorsa lateinitler başlatılmamış olabilir!!!
    //hata ismi "UninitializedPropertyAccessException"


    //her seferinde yeniden nesnesi oluşturmaması için nesneler override dısına oluşturulur

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentMilBinding.inflate(inflater, container, false)
        materyalList = MateryalListesi(requireContext())

        //MateryalListesi sınıfını oluştur ve bağlamını ayarlaparametresini gir
        // lateinit var materyalList: başlatılmış olur
        // "requireContext()" fragmentler için kullanılan contexttir
        materyalList.yogunlukFonk( binding.spinnerIn)

        materyalList.setYogunluk(object : MateryalListesi.OnYogunlukChangeListener{
            //Yogunluk değişikliğini dinleyen bir listener tanımlandı
            override fun onYogunlukChanged(yogunluk: Double){
                //yogunluk değiştiginde yapılacak işlemler



        binding.buttonHesapla.setOnClickListener {
            val pi = 3.14159
            val cap = binding.milCapGiris.text.toString().toDouble()
            val yariCap: Double = cap / 2
            val uzunluk = binding.milUzunlukGiris.text.toString().toDouble()


            val daireAlan = pi * yariCap * yariCap
            Log.e("deger1", yogunluk.toString())
            val agirlik: Double = daireAlan * uzunluk * yogunluk / 1000 / 1000

            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.CEILING
            binding.textViewSonuc.text = "${df.format(agirlik)} Kg"
            binding.textViewSonuc.isVisible = true
            binding.buttonTeklif.isVisible = true


        }
        binding.buttonReset.setOnClickListener {
            binding.milCapGiris.setText("")
            binding.milUzunlukGiris.setText("")
            binding.textViewSonuc.isVisible = false
            binding.buttonTeklif.isVisible = false
            binding.spinnerIn.setSelection(materyalList.veriAdaptoru.getPosition("Demir")) //resete tıklanınca spinner degeri demir olsun

        }
        binding.buttonBack.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java)) //back butonuna basınca gidecegi sayfayı gösterir

        }



        binding.buttonTeklif.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.alert_tasarim, null)
            val editTextAlert = tasarim.findViewById(R.id.editTextPhone) as EditText
            val ad = AlertDialog.Builder(requireContext())
            ad.setTitle("İletişim Numaranızı Giriniz.")
            ad.setIcon(R.drawable.contact)
            ad.setView(tasarim)

            ad.setPositiveButton("Gönder") { dialogInterface, i ->
                val girilenNumara = editTextAlert.text.toString()
                Toast.makeText(
                    requireContext(),
                    "$girilenNumara Numaranız gönderildi.",
                    Toast.LENGTH_SHORT).show()
        //snackbar da kullanabilirsin bölüm14. 197.ders
            }
            ad.setNegativeButton("İptal") { dialogInterface, i ->
                Toast.makeText(requireContext(), "İptal edildi", Toast.LENGTH_SHORT).show()
            }
            ad.show()
        }
            }
        })

        return binding.root
    }

}







