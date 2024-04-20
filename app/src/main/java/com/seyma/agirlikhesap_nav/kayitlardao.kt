package com.seyma.agirlikhesap_nav


import android.content.Context

class kayitlardao (mcontext: Context) {

    val database = mcontext.openOrCreateDatabase("Agirlik", Context.MODE_PRIVATE, null)
    fun sil(id: Int) {
        database.execSQL("CREATE TABLE IF NOT EXISTS records (id INTEGER PRIMARY KEY AUTOINCREMENT,malzeme VARCHAR,materyal VARCHAR,birim VARCHAR," +
                " birimAgirlik DOUBLE, toplamAgirlik DOUBLE, adet INT, uzunluk DOUBLE, etKalinligi DOUBLE, cap VARCHAR, en DOUBLE, yukseklik DOUBLE )")

        val sqlDelete = "DELETE FROM records WHERE id = ?"
        val statement = database.compileStatement(sqlDelete)
        statement.bindLong(1, id.toLong())
        statement.execute() // Sorguyu çalıştır

        // Gerekli temizlik işlemlerini yap
        statement.close()
        database.close()
    }
    fun isTableEmpty(): Boolean {
        val countQuery = "SELECT COUNT(*) FROM records"
        val cursor = database.rawQuery(countQuery, null)
        cursor.moveToFirst()
        val count = cursor.getInt(0)
        cursor.close()
        return count == 0
    }



    fun ekle(
        malzeme: String,
        materyal: String,
        birim: String,
        birimAgirlik: Double,
        toplamAgirlik: Double,
        adet: Int,
        uzunluk: Double,
        etKalinligi: Double,
        cap: Double,
        en: Double,
        yukseklik: Double
    ) {

        try {

            database.execSQL("CREATE TABLE IF NOT EXISTS records (id INTEGER PRIMARY KEY AUTOINCREMENT,malzeme VARCHAR,materyal VARCHAR,birim VARCHAR, birimAgirlik DOUBLE," +
                    " toplamAgirlik DOUBLE, adet INT, uzunluk DOUBLE, etKalinligi DOUBLE, cap VARCHAR, en DOUBLE, yukseklik DOUBLE )")

            val sqlInsert =
                "INSERT INTO records (malzeme,materyal,birim, birimAgirlik, toplamAgirlik, adet, uzunluk, etKalinligi, cap, en, yukseklik) VALUES (?,?,?,?,?,?,?,?,?,?,?)"
            val statement = database.compileStatement(sqlInsert)
            statement.bindString(1, malzeme)
            statement.bindString(2, materyal)
            statement.bindString(3, birim)
            statement.bindDouble(4, birimAgirlik)
            statement.bindDouble(5, toplamAgirlik)
            statement.bindLong(6, adet.toLong())
            statement.bindDouble(7, uzunluk)
            statement.bindDouble(8, etKalinligi)
            statement.bindDouble(9, cap)
            statement.bindDouble(10, en)
            statement.bindDouble(11, yukseklik)
            statement.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}


