package com.seyma.agirlikhesap_nav

//noinspection SuspiciousImport
import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class spinnerUdemir(mcontext: Context) {

    val uDemirListesi: ArrayList<String> = ArrayList()
    var veriAdaptoru: ArrayAdapter<String>

    var udemir:String=""
    lateinit var secilenOge: String

    init {
        uDemirListesi.add("U Demir Seçiniz")
        uDemirListesi.add("UPE")
        uDemirListesi.add("UPN")



        veriAdaptoru = ArrayAdapter(
            mcontext,
            R.layout.simple_list_item_1,
            R.id.text1,
            uDemirListesi)

    }
    interface OnUDemirChangeListener {
        fun onUDemirChanged(udemirturu: String)
    }

    private var uDemirList: OnUDemirChangeListener? = null
    fun setUDemir(listener: OnUDemirChangeListener) {
        uDemirList = listener
    }

    fun udemirFonk(spinnerUDemir: Spinner) {
        spinnerUDemir.adapter = veriAdaptoru
        spinnerUDemir.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Spinner'ın seçili öğe değiştikçe tetiklenecek olan dinleyiciyi ayarlanması

            override fun onItemSelected( //spinnerdan veri secildiğinde tetiklenecek işlemler
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {


                secilenOge = uDemirListesi[position]
                udemir =
                    when (secilenOge) {
                        "U Demir Seçiniz" -> "U Demir Seçiniz"
                        "UPE" -> "UPE"
                        "UPN" -> "UPN"

                        else -> "UPE"
                    }
                uDemirList?.onUDemirChanged(udemir)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

                udemir = "U Demir Seçiniz"

                uDemirList?.onUDemirChanged(udemir)

            }
        }
    }
}