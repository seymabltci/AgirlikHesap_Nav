package com.seyma.agirlikhesap_nav

import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class spinnerUdetay(mcontext: Context) {
    val udetayListesi: ArrayList<String> = ArrayList()
    var veriAdaptoru: ArrayAdapter<String>
    var udetaydemir:String=""
    lateinit var secilenOge: String

    init {
        udetayListesi.add("SEÇİNİZ")

        veriAdaptoru = ArrayAdapter(
            mcontext,
            R.layout.simple_list_item_1,
            R.id.text1,
            udetayListesi)
    }






    interface OnUdetayChangeListener {
        fun onUdetayChanged(udetayturu: String)
    }

    private var udetayList: OnUdetayChangeListener? = null
    fun setUdetayDemir(listener: OnUdetayChangeListener) {
        udetayList = listener
    }

    fun UdetayFonk(spinnerUDemir: Spinner) {
        spinnerUDemir.adapter = veriAdaptoru
        spinnerUDemir.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Spinner'ın seçili öğe değiştikçe tetiklenecek olan dinleyiciyi ayarlanması

            override fun onItemSelected( //spinnerdan veri secildiğinde tetiklenecek işlemler
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {


                secilenOge = udetayListesi[position]
                udetaydemir =
                    when (secilenOge) {

                        "UPE 80 (80X50)" 	 ->	"UPE 80 (80X50)"
                            "UPE 100 (100X55)" 	 ->	"UPE 100 (100X55)"
                            "UPE 120 (120X60)" 	 ->	"UPE 120 (120X60)"
                            "UPE 140 (140X65)" 	 ->	"UPE 140 (140X65)"
                            "UPE 160 (160X70)" 	 ->	"UPE 160 (160X70)"
                            "UPE 180 (180X75)"	 ->	"UPE 180 (180X75)"
                            "UPE 200 (200X80)" 	 ->	"UPE 200 (200X80)"
                            "UPE 220 (220X85)" 	 -> "UPE 220 (220X85)"
                            "UPE 240 (240X90)" 	 ->	"UPE 240 (240X90)"
                            "UPE 270 (270X95)" 	 ->	"UPE 270 (270X95)"
                            "UPE 300 (300X100)"  ->	"UPE 300 (300X100)"
                            "UPE 330 (330X105)"  ->	"UPE 330 (330X105)"
                            "UPE 360 (360X110)"  ->	"UPE 360 (360X110)"
                            "UPE 400 (400X115)"  ->	"UPE 400 (400X115)"

                              "UPN 80 (80X45)" 	 ->	"UPN 80 (80X45)"
                            "UPN 100 (100X50)" 	 ->	"UPN 100 (100X50)"
                            "UPN 120 (120X55)" 	 ->	"UPN 120 (120X55)"
                            "UPN 140 (140X60)" 	 ->	"UPN 140 (140X60)"
                            "UPN 160 (160X65)" 	 ->	"UPN 160 (160X65)"
                            "UPN 180 (180X70)" 	 ->	"UPN 180 (180X70)"
                            "UPN 200 (200X75)" 	 ->	"UPN 200 (200X75)"
                            "UPN 220 (220X80)" 	 ->	"UPN 220 (220X80)"
                            "UPN 240 (240X85)" 	 ->	"UPN 240 (240X85)"
                            "UPN 260 (260X90)" 	 ->	"UPN 260 (260X90)"
                            "UPN 280 (280X95)" 	 ->	"UPN 280 (280X95)"
                            "UPN 300 (300X100)"  ->	"UPN 300 (300X100)"
                            "UPN 320 (320X100)"  ->	"UPN 320 (320X100)"
                            "UPN 350 (350X100)"  ->	"UPN 350 (350X100)"
                            "UPN 380 (380X102)"  ->	"UPN 380 (380X102)"
                            "UPN 400 (400X110)"  ->	"UPN 400 (400X110)"


                        else -> "seçim yok"
                    }
                udetayList?.onUdetayChanged(udetaydemir)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

                udetaydemir = "UPE"

                udetayList?.onUdetayChanged(udetaydemir)

            }
        }
    }
    fun ekleUpeListesi() {
        udetayListesi.add("UPE 80 (80X50)")
        udetayListesi.add("UPE 100 (100X55)")
        udetayListesi.add("UPE 120 (120X60)")
        udetayListesi.add("UPE 140 (140X65)")
        udetayListesi.add("UPE 160 (160X70)")
        udetayListesi.add("UPE 180 (180X75)")
        udetayListesi.add("UPE 200 (200X80)")
        udetayListesi.add("UPE 220 (220X85)")
        udetayListesi.add("UPE 240 (240X90)")
        udetayListesi.add("UPE 270 (270X95)")
        udetayListesi.add("UPE 300 (300X100)")
        udetayListesi.add("UPE 330 (330X105)")
        udetayListesi.add("UPE 360 (360X110)")
        udetayListesi.add("UPE 400 (400X115)")



    }
    fun ekleUpnListesi(){
        udetayListesi.add("UPN 80 (80X45)" )
        udetayListesi.add("UPN 100 (100X50)" )
        udetayListesi.add("UPN 120 (120X55)" )
        udetayListesi.add("UPN 140 (140X60)" )
        udetayListesi.add("UPN 160 (160X65)" )
        udetayListesi.add("UPN 180 (180X70)" )
        udetayListesi.add("UPN 200 (200X75)" )
        udetayListesi.add("UPN 220 (220X80)" )
        udetayListesi.add("UPN 240 (240X85)" )
        udetayListesi.add("UPN 260 (260X90)" )
        udetayListesi.add("UPN 280 (280X95)" )
        udetayListesi.add("UPN 300 (300X100)" )
        udetayListesi.add("UPN 320 (320X100)" )
        udetayListesi.add("UPN 350 (350X100)" )
        udetayListesi.add("UPN 380 (380X102)" )
        udetayListesi.add("UPN 400 (400X110)" )




    }

}