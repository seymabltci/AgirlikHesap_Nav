package com.seyma.agirlikhesap_nav

//noinspection SuspiciousImport
import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class spinnerIdetay (mcontext: Context){
    val idetayListesi: ArrayList<String> = ArrayList()
    var veriAdaptoru: ArrayAdapter<String>
    var idetaydemir:String=""
    lateinit var secilenOge: String

    init {
        idetayListesi.add("SEÇİNİZ")

        veriAdaptoru = ArrayAdapter(
            mcontext,
            R.layout.simple_list_item_1,
            R.id.text1,
            idetayListesi)
    }






    interface OnIdetayChangeListener {
        fun onIdetayChanged(idetayturu: String)
    }

    private var idetayList: OnIdetayChangeListener? = null
    fun setIdetayDemir(listener: OnIdetayChangeListener) {
        idetayList = listener
    }

    fun idetayFonk(spinnerIDemir: Spinner) {
        spinnerIDemir.adapter = veriAdaptoru
        spinnerIDemir.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Spinner'ın seçili öğe değiştikçe tetiklenecek olan dinleyiciyi ayarlanması

            override fun onItemSelected( //spinnerdan veri secildiğinde tetiklenecek işlemler
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {


                secilenOge = idetayListesi[position]
                idetaydemir =
                    when (secilenOge) {

                        "IPE 80 (80X46)" -> "IPE 80 (80X46)"
                        "IPE 100 (100X55)" -> "IPE 100 (100X55)"
                        "IPE 120 (120X64)" -> "IPE 120 (120X64)"
                        "IPE 140 (140X73)" -> "IPE 140 (140X73)"
                        "IPE 160 (160X82)" -> "IPE 160 (160X82)"
                        "IPE 180 (180X91)" -> "IPE 180 (180X91)"
                        "IPE 200 (200X100)" -> "IPE 200 (200X100)"
                        "IPE 220 (220X110)" -> "IPE 220 (220X110)"
                        "IPE 240 (240X120)" -> "IPE 240 (240X120)"
                        "IPE 270 (270X135)" -> "IPE 270 (270X135)"
                        "IPE 300 (300X150)" -> "IPE 300 (300X150)"
                        "IPE 330 (330X160)" -> "IPE 330 (330X160)"
                        "IPE 360 (360X170)" -> "IPE 360 (360X170)"
                        "IPE 400 (400X180)" -> "IPE 400 (400X180)"
                        "IPE 450 (450X190)" -> "IPE 450 (450X190)"
                        "IPE 500 (500X200)" -> "IPE 500 (500X200)"
                        "IPE 550 (550X210)" -> "IPE 550 (550X210)"
                        "IPE 600 (600X220)" -> "IPE 600 (600X220)"
                        "IPN 80 (80X42)"   -> "IPN 80 (80X42)"
                        "IPN 100 (100X50)" -> "IPN 100 (100X50)"
                        "IPN 120 (120X58)" -> "IPN 120 (120X58)"
                        "IPN 140 (140X66)" -> "IPN 140 (140X66)"
                        "IPN 160 (160X74)" -> "IPN 160 (160X74)"
                        "IPN 180 (180X82)" -> "IPN 180 (180X82)"
                        "IPN 200 (200X90)" -> "IPN 200 (200X90)"
                        "IPN 220 (220X98)" -> "IPN 220 (220X98)"
                        "IPN 240 (240X106)" -> "IPN 240 (240X106)"
                        "IPN 260 (260X113)" -> "IPN 260 (260X113)"
                        "IPN 280 (260X119)" -> "IPN 280 (260X119)"
                        "IPN 300 (300X125)" -> "IPN 300 (300X125)"
                        "IPN 330 (320X131)" -> "IPN 330 (320X131)"
                        "IPN 340 (340X137)" -> "IPN 340 (340X137)"
                        "IPN 360 (360X143)" -> "IPN 360 (360X143)"
                        "IPN 380 (380X149)" -> "IPN 380 (380X149)"
                        "IPN 400 (400X155)" -> "IPN 400 (400X155)"
                        "IPN 450 (450X1170)" -> "IPN 450 (450X170)"
                        "IPN 500 (500X185)" -> "IPN 500 (500X185)"
                        "IPN 550 (550X200)" -> "IPN 550 (550X200)"
                        "IPN 600 (600X215)" ->"IPN 600 (600X215)"
                        "HE A 100 (100X96)" ->"HE A 100 (100X96)"
                        "HE A 120 (120X114)" ->"HE A 120 (120X114)"
                        "HE A 140 (140X133)" ->"HE A 140 (140X133)"
                        "HE A 160 (160X152)" ->"HE A 160 (160X152)"
                        "HE A 180 (180X171)" ->"HE A 180 (180X171)"
                        "HE A 200 (200X190)" ->"HE A 200 (200X190)"
                        "HE A 220 (220X210)" ->"HE A 220 (220X210)"
                        "HE A 240 (240X230)" ->"HE A 240 (240X230)"
                        "HE A 260 (260X250)" ->"HE A 260 (260X250)"
                        "HE A 280 (280X270)" ->"HE A 280 (280X270)"
                        "HE A 300 (300X290)" ->"HE A 300 (300X290)"
                        "HE A 320 (300X310)" ->"HE A 320 (300X310)"
                        "HE A 340 (300X330)" ->"HE A 340 (300X330)"
                        "HE A 360 (300X350)" ->"HE A 360 (300X350)"
                        "HE A 400 (300X390)" ->"HE A 400 (300X390)"
                        "HE A 450 (300X440)" ->"HE A 450 (300X440)"
                        "HE A 500 (300X490)" ->"HE A 500 (300X490)"
                        "HE A 550 (300X540)" ->"HE A 550 (300X540)"
                        "HE A 600 (300X590)" ->"HE A 600 (300X590)"
                        "HE A 650 (300X640)" ->"HE A 650 (300X640)"
                        "HE A 700 (300X690)" ->"HE A 700 (300X690)"
                        "HE A 800 (300X790)" ->"HE A 800 (300X790)"
                        "HE A 900 (300X890)" ->"HE A 900 (300X890)"
                        "HE A 1000 (300X990)"->"HE A 1000 (300X990)"
                        "HE B  100 (100X100)"->"HE B  100 (100X100)"
                        "HE B  120 (120X120)"->"HE B  120 (120X120)"
                        "HE B  140 (140X140)"->"HE B  140 (140X140)"
                        "HE B  160 (160X160)"->"HE B  160 (160X160)"
                        "HE B  180 (180X180)"->"HE B  180 (180X180)"
                        "HE B  200 (200X200)"->"HE B  200 (200X200)"
                        "HE B  220 (220X220)"->"HE B  220 (220X220)"
                        "HE B  240 (240X240)"->"HE B  240 (240X240)"
                        "HE B  260 (260X260)"->"HE B  260 (260X260)"
                        "HE B  280 (280X280)"->"HE B  280 (280X280)"
                        "HE B  300 (300X300)"->"HE B  300 (300X300)"
                        "HE B  320 (320X300)"->"HE B  320 (320X300)"
                        "HE B  340 (340X300)"->"HE B  340 (340X300)"
                        "HE B  360 (360X300)"->"HE B  360 (360X300)"
                        "HE B  400 (400X300)"->"HE B  400 (400X300)"
                        "HE B  450 (450X300)"->"HE B  450 (450X300)"
                        "HE B  500 (500X300)"->"HE B  500 (500X300)"
                        "HE B  550 (550X300)"->"HE B  550 (550X300)"
                        "HE B  600 (600X300)"->"HE B  600 (600X300)"
                        "HE B  650 (650X300)"->"HE B  650 (650X300)"
                        "HE B  700 (700X300)"->"HE B  700 (700X300)"
                        "HE B  800 (800X300)"->"HE B  800 (800X300)"
                        "HE B  900 (900X300)"->"HE B  900 (900X300)"
                        "HE B  1000 (1000X300)"->"HE B  1000 (1000X300)"
                        "HE M 100 (120X106)"->"HE M 100 (120X106)"
                        "HE M 120 (140X126)"->	"HE M 120 (140X126)"
                        "HE M 140 (160X146)"->"HE M 140 (160X146)"
                        "HE M 160 (180X166)"->"HE M 160 (180X166)"
                        "HE M 180 (200X186)"->"HE M 180 (200X186)"
                        "HE M 200 (220X206)"->"HE M 200 (220X206)"
                        "HE M 220 (240X226)"->"HE M 220 (240X226)"
                        "HE M 240 (270X248)"->"HE M 240 (270X248)"
                        "HE M 260 (290X268)"->"HE M 260 (290X268)"
                        "HE M 280 (310X288)"->"HE M 280 (310X288)"
                        "HE M 300 (340X310)"->"HE M 300 (340X310)"
                        "HE M 320 (359X309)"->"HE M 320 (359X309)"
                        "HE M 340 (377X309)"->"HE M 340 (377X309)"
                        "HE M 360 (395X308)"->"HE M 360 (395X308)"
                        "HE M 400 (432X307)"->"HE M 400 (432X307)"
                        "HE M 450 (478X307)"->"HE M 450 (478X307)"
                        "HE M 500 (524X306)"->"HE M 500 (524X306)"
                        "HE M 550 (572X306)"->"HE M 550 (572X306)"
                        "HE M 600 (620X305)"->"HE M 600 (620X305)"
                        "HE M 650 (668X305)"->"HE M 650 (668X305)"
                        "HE M 700 (716X304)"->"HE M 700 (716X304)"
                        "HE M 800 (800X300)"->"HE M 800 (800X300)"
                        "HE M 900 (910X302)"->"HE M 900 (910X302)"
                        "HE M 1000 (1008X302)"->"HE M 1000 (1008X302)"


                        else -> "seçim yok"
                    }
                idetayList?.onIdetayChanged(idetaydemir)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

                idetaydemir = "IPE"

                idetayList?.onIdetayChanged(idetaydemir)

            }
        }
    }
    fun ekleIpeListesi() {
        idetayListesi.add("IPE 80 (80X46)")
        idetayListesi.add("IPE 100 (100X55)")
        idetayListesi.add("IPE 120 (120X64)")
        idetayListesi.add("IPE 140 (140X73)")
        idetayListesi.add("IPE 160 (160X82)")
        idetayListesi.add("IPE 180 (180X91)")
        idetayListesi.add("IPE 200 (200X100)")
        idetayListesi.add("IPE 220 (220X110)")
        idetayListesi.add("IPE 240 (240X120)")
        idetayListesi.add("IPE 270 (270X135)")
        idetayListesi.add("IPE 300 (300X150)")
        idetayListesi.add("IPE 330 (330X160)")
        idetayListesi.add("IPE 360 (360X170)")
        idetayListesi.add("IPE 400 (400X180)")
        idetayListesi.add("IPE 450 (450X190)")
        idetayListesi.add("IPE 500 (500X200)")
        idetayListesi.add("IPE 550 (550X210)")
        idetayListesi.add("IPE 600 (600X220)")


    }
    fun ekleIpnListesi(){
        idetayListesi.add("IPN 80 (80X42)")
        idetayListesi.add("IPN 100 (100X50)")
        idetayListesi.add("IPN 120 (120X58)")
        idetayListesi.add("IPN 140 (140X66)")
        idetayListesi.add("IPN 160 (160X74)")
        idetayListesi.add("IPN 180 (180X82)")
        idetayListesi.add("IPN 200 (200X90)")
        idetayListesi.add("IPN 220 (220X98)")
        idetayListesi.add("IPN 240 (240X106)")
        idetayListesi.add("IPN 260 (260X113)")
        idetayListesi.add("IPN 280 (260X119)")
        idetayListesi.add("IPN 300 (300X125)")
        idetayListesi.add("IPN 330 (320X131)")
        idetayListesi.add("IPN 340 (340X137)")
        idetayListesi.add("IPN 360 (360X143)")
        idetayListesi.add("IPN 380 (380X149)")
        idetayListesi.add("IPN 400 (400X155)")
        idetayListesi.add("IPN 450 (450X1170)")
        idetayListesi.add("IPN 500 (500X185)")
        idetayListesi.add("IPN 550 (550X200)")
        idetayListesi.add("IPN 600 (600X215)")

    }
    fun ekleHeaListesi(){
        idetayListesi.add("HE A 100 (100X96)")
        idetayListesi.add("HE A 120 (120X114)")
        idetayListesi.add("HE A 140 (140X133)")
        idetayListesi.add("HE A 160 (160X152)")
        idetayListesi.add("HE A 180 (180X171)")
        idetayListesi.add("HE A 200 (200X190)")
        idetayListesi.add("HE A 220 (220X210)")
        idetayListesi.add("HE A 240 (240X230)")
        idetayListesi.add("HE A 260 (260X250)")
        idetayListesi.add("HE A 280 (280X270)")
        idetayListesi.add("HE A 300 (300X290)")
        idetayListesi.add("HE A 320 (300X310)")
        idetayListesi.add("HE A 340 (300X330)")
        idetayListesi.add("HE A 360 (300X350)")
        idetayListesi.add("HE A 400 (300X390)")
        idetayListesi.add("HE A 450 (300X440)")
        idetayListesi.add("HE A 500 (300X490)")
        idetayListesi.add("HE A 550 (300X540)")
        idetayListesi.add("HE A 600 (300X590)")
        idetayListesi.add("HE A 650 (300X640)")
        idetayListesi.add("HE A 700 (300X690)")
        idetayListesi.add("HE A 800 (300X790)")
        idetayListesi.add("HE A 900 (300X890)")
        idetayListesi.add("HE A 1000 (300X990)")

    }

    fun ekleHebListesi(){
        idetayListesi.add("HE B  100 (100X100)")
        idetayListesi.add("HE B  120 (120X120)")
        idetayListesi.add("HE B  140 (140X140)")
        idetayListesi.add("HE B  160 (160X160)")
        idetayListesi.add("HE B  180 (180X180)")
        idetayListesi.add("HE B  200 (200X200)")
        idetayListesi.add("HE B  220 (220X220)")
        idetayListesi.add("HE B  240 (240X240)")
        idetayListesi.add("HE B  260 (260X260)")
        idetayListesi.add("HE B  280 (280X280)")
        idetayListesi.add("HE B  300 (300X300)")
        idetayListesi.add("HE B  320 (320X300)")
        idetayListesi.add("HE B  340 (340X300)")
        idetayListesi.add("HE B  360 (360X300)")
        idetayListesi.add("HE B  400 (400X300)")
        idetayListesi.add("HE B  450 (450X300)")
        idetayListesi.add("HE B  500 (500X300)")
        idetayListesi.add("HE B  550 (550X300)")
        idetayListesi.add("HE B  600 (600X300)")
        idetayListesi.add("HE B  650 (650X300)")
        idetayListesi.add("HE B  700 (700X300)")
        idetayListesi.add("HE B  800 (800X300)")
        idetayListesi.add("HE B  900 (900X300)")
        idetayListesi.add("HE B  1000 (1000X300)")

    }

    fun ekleHemListesi(){
        idetayListesi.add("HE M 100 (120X106)")
        idetayListesi.add("HE M 120 (140X126)")
        idetayListesi.add("HE M 140 (160X146)")
        idetayListesi.add("HE M 160 (180X166)")
        idetayListesi.add("HE M 180 (200X186)")
        idetayListesi.add("HE M 200 (220X206)")
        idetayListesi.add("HE M 220 (240X226)")
        idetayListesi.add("HE M 240 (270X248)")
        idetayListesi.add("HE M 260 (290X268)")
        idetayListesi.add("HE M 280 (310X288)")
        idetayListesi.add("HE M 300 (340X310)")
        idetayListesi.add("HE M 320 (359X309)")
        idetayListesi.add("HE M 340 (377X309)")
        idetayListesi.add("HE M 360 (395X308)")
        idetayListesi.add("HE M 400 (432X307)")
        idetayListesi.add("HE M 450 (478X307)")
        idetayListesi.add("HE M 500 (524X306)")
        idetayListesi.add("HE M 550 (572X306)")
        idetayListesi.add("HE M 600 (620X305)")
        idetayListesi.add("HE M 650 (668X305)")
        idetayListesi.add("HE M 700 (716X304)")
        idetayListesi.add("HE M 800 (800X300)")
        idetayListesi.add("HE M 900 (910X302)")
        idetayListesi.add("HE M 1000 (1008X302)")

    }
}