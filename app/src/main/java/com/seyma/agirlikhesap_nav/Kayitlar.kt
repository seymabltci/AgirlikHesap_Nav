package com.seyma.agirlikhesap_nav

import java.io.Serializable

data class Kayitlar(
    val id : Int,
    val malzeme : String,
    val materyal : String,
    val birim : String,
    val birimAgirlik: Double,
    val toplamAgirlik: Double? = 0.0,
    val adet: Int? = 0,
    val uzunluk: Double ,
    val etKalinligi: Double? = 0.0,
    val cap : Double ?= 0.0,
    val en :Double? = 0.0,
    val yukseklik :Double? = 0.0
) : Serializable // verilerin serileştirilebilir oldugunu gösterir.
{

}



