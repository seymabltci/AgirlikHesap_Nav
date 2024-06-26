package com.seyma.agirlikhesap_nav

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


class MateryalListesi(mcontext: Context) {
    //MateryalListesi sınıfı bir sınıfa baglı değildir bu yuzden dısarıdan context parametresi alarak cagrılır

    val materyalList: ArrayList<String> = ArrayList()  // Örnek bir ArrayList oluşturuldu
    var veriAdaptoru: ArrayAdapter<String>

    //veriAdaptoru adlı bir ArrayAdapter<String> öğesi, materyalList'i
    // bir Spinner veya başka bir liste görünümü ile bağlamak için kullanılır.
    // Bu adaptör, malzeme listesini içeren bir ArrayAdapter'dir.

    var yogunluk: Double = 0.0
    lateinit var secilenOge: String


    init { //init : sınıf başlatılınca yapılacak işlemlerde kullanılır.

        // olusturulan arrayListe materyaller eklenir
        materyalList.add("Çelik")
        materyalList.add("Krom")
        materyalList.add("Paslanmaz 304/310")
        materyalList.add("Paslanmaz 316/321")
        materyalList.add("Paslanmaz 410/430")
        materyalList.add("Alüminyum")
        materyalList.add("DKP Sac")

        veriAdaptoru = ArrayAdapter( // ArrayAdapter, bir veri kümesini bir Spinner, ListView veya diğer liste görünümleriyle bağlamak için kullanılan bir adaptör sınıfıdır.
            mcontext, //yukarıda sınıfı tanımlarken girilen parametreyi context olarak alır
            android.R.layout.simple_list_item_1, //basit bir liste öğesini göstermek için kullanılan bir sistem içi layout kaynağıdır.
            android.R.id.text1,  //Bu kaynak ID si, adaptörün her öğesinin gösterildiği metni temsil eden öğedir.
            materyalList) //baglanacak olan veri kümesi liste vb

    }
    // Array list'e öğe eklemek için bir metod
    // fun addItem(item: String) { materyalList.add(item) }
    interface OnYogunlukChangeListener {

        fun onYogunlukChanged(yogunluk: Double)
        // OnYogunlukChangeListener, bir tek metodu olan bir interface (onYogunlukChanged).
        // Bu arayüz, bir nesnenin yoğunluk değişikliklerini dinlemek için kullanılır.
        // Yani, bir sınıf bu arayüzü uygularsa, o sınıfa ait bir nesne üzerinde yoğunluk değişiklikleri dinlenebilir.

    }

    private var yogunlukList: OnYogunlukChangeListener? = null


    fun setYogunluk(listener: OnYogunlukChangeListener) {

        yogunlukList = listener

    }


    fun yogunlukFonk(spinnerIn: Spinner) {

        spinnerIn.adapter = veriAdaptoru



        spinnerIn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Spinner'ın seçili öğe değiştikçe tetiklenecek olan dinleyiciyi ayarlanması

            override fun onItemSelected( //spinnerdan veri secildiğinde tetiklenecek işlemler
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                secilenOge = materyalList[position]

                yogunluk =
                    when (secilenOge) {

                        "Çelik" -> 7.85
                        "Krom" -> 7.1
                        "Paslanmaz 304/310" -> 7.92
                        "Paslanmaz 316/321" -> 7.94
                        "Paslanmaz 410/430" -> 7.71
                        "Alüminyum" -> 2.73
                        "DKP Sac" -> 8.0


                        else -> 7.85

                    }
                // Yoğunluk değişikliği dinleyiciye bildirilir
                yogunlukList?.onYogunlukChanged(yogunluk)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { //spinnerdan bir deger seçilmezse

                yogunluk = 7.85

                // Yoğunluk değişikliği dinleyiciye bildirilir
                yogunlukList?.onYogunlukChanged(yogunluk)

            }
        }
    }
}










/*

        // Array list'e öğe eklemek için bir metod
        fun addItem(item: String) {
            materyalList.add(item)
        }

        // Array list'ten öğe silmek için bir metod
        fun removeItem(item: String) {
            materyalList.remove(item)
        }

        // Array list'i döndüren bir metod
        fun getArrayList(): ArrayList<String> {
            return materyalList
        }

*/
