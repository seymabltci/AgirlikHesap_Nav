package com.seyma.agirlikhesap_nav

//noinspection SuspiciousImport
import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class spinnerIdemir(mcontext: Context) {

        val iDemirListesi: ArrayList<String> = ArrayList()
        var veriAdaptoru: ArrayAdapter<String>

        var idemir:String=""
        lateinit var secilenOge: String

        init {
            iDemirListesi.add("I/H Demir Seçiniz")
            iDemirListesi.add("IPE")
            iDemirListesi.add("IPN")
            iDemirListesi.add("HE A")
            iDemirListesi.add("HE B")
            iDemirListesi.add("HE M")



            veriAdaptoru = ArrayAdapter(
                mcontext,
                R.layout.simple_list_item_1,
                R.id.text1,
                iDemirListesi)

        }
        interface OnIDemirChangeListener {
            fun onIDemirChanged(idemirturu: String)
        }

        private var iDemirList: OnIDemirChangeListener? = null
        fun setIDemir(listener: OnIDemirChangeListener) {
            iDemirList = listener
        }

        fun idemirFonk(spinnerIDemir: Spinner) {
            spinnerIDemir.adapter = veriAdaptoru
            spinnerIDemir.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                //Spinner'ın seçili öğe değiştikçe tetiklenecek olan dinleyiciyi ayarlanması

                override fun onItemSelected( //spinnerdan veri secildiğinde tetiklenecek işlemler
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long) {


                    secilenOge = iDemirListesi[position]
                    idemir =
                        when (secilenOge) {
                            "I/H Demir Seçiniz" -> "I/H Demir Seçiniz"
                            "IPE" -> "IPE"
                            "IPN" -> "IPN"
                            "HE A" -> "HE A"
                            "HE B" -> "HE B"
                            "HE M" -> "HE M"

                            else -> "IPE"
                        }
                    iDemirList?.onIDemirChanged(idemir)
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {

                    idemir = "I/H Demir Seçiniz"

                    iDemirList?.onIDemirChanged(idemir)

                }
            }
        }
    }

