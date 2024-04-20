package com.seyma.agirlikhesap_nav

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class OlcuListesi(mcontext: Context) {


    val olcuListesi: ArrayList<String> = ArrayList()
    var veriAdaptoru: ArrayAdapter<String>

    var olcu:String=""
    lateinit var secilenOge: String

    init {
        olcuListesi.add("mm")
        olcuListesi.add("cm")

        veriAdaptoru = ArrayAdapter(
            mcontext,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            olcuListesi)

    }
    interface OnOlcuChangeListener {
        fun onOlcuChanged(olcu: String)
    }

    private var olcuList: OnOlcuChangeListener? = null
    fun setOlcu(listener: OnOlcuChangeListener) {
        olcuList = listener
    }

   fun olcuFonk(spinnerOlcu: Spinner) {
        spinnerOlcu.adapter = veriAdaptoru
        spinnerOlcu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Spinner'ın seçili öğe değiştikçe tetiklenecek olan dinleyiciyi ayarlanması

            override fun onItemSelected( //spinnerdan veri secildiğinde tetiklenecek işlemler
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {

                secilenOge = olcuListesi[position]
                olcu =
                    when (secilenOge) {

                        "mm" -> "mm"
                        "cm" -> "cm"

                        else -> "mm"
                    }
                olcuList?.onOlcuChanged(olcu)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

                olcu = "mm"

               olcuList?.onOlcuChanged(olcu)

            }
        }
    }
}
