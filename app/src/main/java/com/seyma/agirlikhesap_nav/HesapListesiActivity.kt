package com.seyma.agirlikhesap_nav

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.database.getDoubleOrNull
import androidx.core.database.getIntOrNull
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.seyma.agirlikhesap_nav.databinding.ActivityHesapListesiBinding
import com.seyma.agirlikhesap_nav.databinding.RecyclerViewKayitBinding


class HesapListesiActivity : AppCompatActivity() {

    lateinit var binding: ActivityHesapListesiBinding
    lateinit var kayitListesi: ArrayList<Kayitlar>
    lateinit var KayitAdapter: KayitAdapter


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)


        binding = ActivityHesapListesiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        kayitListesi = ArrayList<Kayitlar>()

        KayitAdapter = KayitAdapter(this,kayitListesi)

        binding.RecyclerViewHesap.layoutManager = LinearLayoutManager(this)

        binding.RecyclerViewHesap.adapter = KayitAdapter

        binding.toolbar2.title = ("     Hesaplama Listesi")
        binding.toolbar2.setTitleTextColor(ContextCompat.getColor(this, R.color.white))



        if(kayitlardao(this).isTableEmpty()) {

            binding.btnTeklif.isVisible = false
        }
        else{
            binding.btnTeklif.isVisible = true
        }


        binding.btnBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        try {

            val database = this.openOrCreateDatabase("Agirlik", Context.MODE_PRIVATE, null)
            val cursor = database.rawQuery("SELECT * FROM records", null)
            val idIx = cursor.getColumnIndex("id")
            val malzemeIx = cursor.getColumnIndex("malzeme")
            val materyalIx = cursor.getColumnIndex("materyal")
            val birimIx = cursor.getColumnIndex("birim")
            val birimAgirlikIx = cursor.getColumnIndex("birimAgirlik")
            val toplamAgirlikIx = cursor.getColumnIndex("toplamAgirlik")
            val adetIx = cursor.getColumnIndex("adet")
            val uzunlukIx = cursor.getColumnIndex("uzunluk")
            val etKalinligiIx = cursor.getColumnIndex("etKalinligi")
            val capIx = cursor.getColumnIndex("cap")
            val enIx = cursor.getColumnIndex("en")
            val yukseklikIx = cursor.getColumnIndex("yukseklik")


            while (cursor.moveToNext()) {
                val id = cursor.getInt(idIx)
                val malzeme = cursor.getString(malzemeIx)
                val materyal = cursor.getString(materyalIx)
                val birim = cursor.getString(birimIx)
                val birimAgirlik = cursor.getDouble(birimAgirlikIx)
                val toplamAgirlik = cursor.getDoubleOrNull(toplamAgirlikIx)
                val adet = cursor.getIntOrNull(adetIx)
                val uzunluk = cursor.getDouble(uzunlukIx)
                val etKalinligi = cursor.getDoubleOrNull(etKalinligiIx)
                val cap = cursor.getDoubleOrNull(capIx)
                val en = cursor.getDoubleOrNull(enIx)
                val yukseklik = cursor.getDoubleOrNull(yukseklikIx)


                val kayit = Kayitlar(id, malzeme, materyal,birim,birimAgirlik, toplamAgirlik, adet, uzunluk, etKalinligi, cap,en, yukseklik )
                kayitListesi.add(kayit)

            }
            KayitAdapter.notifyDataSetChanged() //veri seti değişti db haber et



            cursor.close()
        }



        catch (e: Exception){
            e.printStackTrace()
        }

        binding.btnTeklif.setOnClickListener {
            val tasarim = LayoutInflater.from(this).inflate(R.layout.alert_tasarim, null)
            val editTextPhone = tasarim.findViewById(R.id.editTextPhone) as EditText
            val editTextName = tasarim.findViewById(R.id.editTextName) as EditText
            val editTextCompany = tasarim.findViewById(R.id.editTextCompany) as EditText
            val ad = AlertDialog.Builder(this)
            ad.setTitle("İletişim Bilgilerinizi Giriniz.")
            ad.setIcon(R.drawable.contact)
            ad.setView(tasarim)

            ad.setPositiveButton("Gönder") { dialogInterface, i ->

                if (editTextCompany.text.toString().isBlank() ||
                    editTextName.text.toString().isBlank() ||
                    editTextPhone.text.toString().isBlank()
                ) {
                    Toast.makeText(
                        this,
                        "Alanlar boş bırakılamaz.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (editTextPhone.text.toString().length != 10) {
                    Toast.makeText(
                        this,
                        "İletişim numaranız 10 haneden oluşmalıdır.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val mesajBuilder = StringBuilder()
                    for (kayit in kayitListesi) {
                        mesajBuilder.append(kayit.malzeme)
                        mesajBuilder.append(kayit.materyal)
                        mesajBuilder.append(kayit.birim)
                        mesajBuilder.append(kayit.birimAgirlik.toString().toDouble())
                        mesajBuilder.append(kayit.toplamAgirlik.toString().toDouble())
                        mesajBuilder.append(kayit.yukseklik.toString().toDouble())
                        mesajBuilder.append(kayit.uzunluk.toString().toDouble())
                        mesajBuilder.append(kayit.en.toString().toDouble())
                        mesajBuilder.append(kayit.birim)
                        mesajBuilder.append(kayit.cap.toString().toDouble())
                        mesajBuilder.append(kayit.adet.toString().toInt())
                        mesajBuilder.append(kayit.etKalinligi.toString().toDouble())


                        mesajBuilder.append("\n") // Her kayıt arasına bir boşluk ekleyin
                    }
                    val mesaj = mesajBuilder.toString()

                    val sonucHoler = KayitAdapter.KayitlarHoler(
                        RecyclerViewKayitBinding.inflate(layoutInflater)
                    )

                    sonucHoler.sendMail(
                        mesaj,
                        editTextPhone.text.toString(),
                        editTextName.text.toString(),
                        editTextCompany.text.toString()
                    )

                    Toast.makeText(
                        this,
                        "Teklif talebiniz mail olarak iletilmiştir.",
                        Toast.LENGTH_LONG
                    ).show()
                    //snackbar da kullanabilirsin bölüm14. 197.ders

                }
            }

            ad.setNegativeButton("İptal") { dialogInterface, i ->
                Toast.makeText(this, "İptal edildi", Toast.LENGTH_SHORT).show()
            }
            ad.show()
        }
    }
}

