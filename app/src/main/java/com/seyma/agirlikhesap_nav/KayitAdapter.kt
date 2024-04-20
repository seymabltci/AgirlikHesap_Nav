package com.seyma.agirlikhesap_nav


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.seyma.agirlikhesap_nav.databinding.RecyclerViewKayitBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class KayitAdapter (val mcontext: Context, val kayitList : ArrayList<Kayitlar>)
    : RecyclerView.Adapter<KayitAdapter.KayitlarHoler>() {

    lateinit var olcuListesi: OlcuListesi

   inner class KayitlarHoler(val binding: RecyclerViewKayitBinding) : RecyclerView.ViewHolder(binding.root){

        fun sendMail(
            topluMesaj: String,numara: String, isim: String, firma: String)
                      {

            val alici = "sbaltaci@hakansacmetal.com.tr"

            val gonderici = "sbaltaci@hakansacmetal.com.tr"
            val sifre = "3646192.s"
            val konu = "Teklif Al"
            val host = "smtp.gmail.com"
            val port = "465"

                          val liste = kayitList

                          // Liste içine veri ekleniyor


                          // Mesaj oluşturuluyor
            val mesaj = buildString {
             appendLine("Merhabalar, ")
             appendLine(" ")
             appendLine("İsim: $isim " )
             appendLine("Firma Adı: $firma ")
             appendLine("İletişim Numarası: $numara " )
             appendLine(" ")

             liste.forEachIndexed { index, sonuc ->
             appendLine("Malzeme: ${sonuc.malzeme}    Materyal: ${sonuc.materyal}")
             when (sonuc.malzeme) {
               "Mil" -> appendLine("Ölçüler: ${sonuc.cap?.toInt()}  ${sonuc.birim}")
               "Boru" -> appendLine("Ölçüler: ${sonuc.cap?.toInt()} X ${sonuc.etKalinligi}  ${sonuc.birim}")
               "Kare Demir" ->appendLine ("Ölçüler: ${sonuc.en?.toInt()}  ${sonuc.birim}")
               "Silme/Lama" -> appendLine("Ölçüler: ${sonuc.en?.toInt()} X ${sonuc.yukseklik?.toInt()}   ${sonuc.birim}")
               "Profil" -> appendLine("Ölçüler: ${sonuc.en?.toInt()} X ${sonuc.yukseklik?.toInt()} X ${sonuc.etKalinligi}   ${sonuc.birim}")
               "Köşebent" -> appendLine("Ölçüler: ${sonuc.en?.toInt()} X ${sonuc.yukseklik?.toInt()} X ${sonuc.etKalinligi}   ${sonuc.birim}")
             }

            val df = DecimalFormat("#.###")
            val symbols = DecimalFormatSymbols().apply {
                decimalSeparator = ',' // Virgülü ayarla
            }
            df.decimalFormatSymbols = symbols
            df.roundingMode = RoundingMode.CEILING
            val formattedValue = df.format(sonuc.birimAgirlik)
            val formattedValue2 = df.format(sonuc.toplamAgirlik)


            appendLine("Uzunluk: ${sonuc.uzunluk.toInt()}  ${sonuc.birim}")
            appendLine("Birim Ağırlık: $formattedValue Kg")


           if (sonuc.adet != 0 && sonuc.toplamAgirlik != 0.0) {

            appendLine("Toplam Ağırlık(${sonuc.adet} adet): $formattedValue2 Kg")

           }

           if (index < liste.size -1 ) {
            appendLine("***")
           }
        }
      }



                          val properties = System.getProperties()

                          properties["mail.smtp.host"] = host
                          properties["mail.smtp.port"] = port
                          properties["mail.smtp.ssl.enable"] = "true"
                          properties["mail.smtp.auth"] = "true"

                          val session = Session.getInstance(properties, object : Authenticator() {
                              override fun getPasswordAuthentication(): PasswordAuthentication {
                                  return PasswordAuthentication(gonderici, sifre)
                              }
                          })

                          Thread {
                              try {
                                  val mimeMessage = MimeMessage(session)
                                  mimeMessage.setRecipient(Message.RecipientType.TO, InternetAddress(alici))
                                  mimeMessage.subject =konu
                                  mimeMessage.setText(mesaj)
                                  Transport.send(mimeMessage)
                              } catch (e: MessagingException) {
                                  e.printStackTrace()
                              }
                          }.start()
                      }
      }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KayitlarHoler {
        val binding = RecyclerViewKayitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)


        return KayitlarHoler(binding)
    }

    override fun getItemCount(): Int {
       return kayitList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: KayitlarHoler, position: Int) {

        val kayit = kayitList.get(position)

        val doubleFormat = DecimalFormat("#.###")
        doubleFormat.roundingMode = RoundingMode.CEILING
        val formatAgirlik = doubleFormat.format(kayit.birimAgirlik)
        val formatToplam = doubleFormat.format(kayit.toplamAgirlik)

        olcuListesi = OlcuListesi(mcontext)
        olcuListesi.olcuFonk(holder.binding.spinnerOlcu)

        olcuListesi.setOlcu(object : OlcuListesi.OnOlcuChangeListener{
            override fun onOlcuChanged(olcu: String) {
                holder.binding.olcu2.text = kayit.birim
                holder.binding.olcu3.text = kayit.birim
            }
        })

        holder.binding.tvMalzeme.text = kayit.malzeme
        holder.binding.tvMateryal.text = kayit.materyal
        holder.binding.tvEn.text = kayit.en?.toInt().toString()
        holder.binding.tvCap.text = kayit.cap?.toInt().toString()
        holder.binding.tvYukseklik.text = kayit.yukseklik?.toInt().toString()
        holder.binding.tvEtKalinligi.text = kayit.etKalinligi?.toString()
        holder.binding.tvUzunluk.text = kayit.uzunluk.toInt().toString()
        holder.binding.tvBrAgirlik.text = formatAgirlik.toString()
        holder.binding.tvTpAgirlik.text = formatToplam.toString()
        holder.binding.tvTpAdet.text = kayit.adet.toString()
        holder.binding.olcu2.text = kayit.birim
        holder.binding.olcu3.text = kayit.birim

        if (kayit.adet == 0) {

            holder.binding.tvTpAdet.isVisible = false
            holder.binding.tvAdet.isVisible = false
            holder.binding.tvTp.isVisible = false
            holder.binding.tvTpAgirlik.isVisible = false
            holder.binding.tvTpKg.isVisible = false
        }

        if (kayit.malzeme == "Boru") {
            holder.binding.tvEn.visibility = View.GONE
            holder.binding.tvYukseklik.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
            holder.binding.enToYuk.isVisible = false

        }
        if (kayit.malzeme == "Kare Demir") {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.tvEtKalinligi.visibility = View.GONE
            holder.binding.tvYukseklik.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
            holder.binding.enToYuk.isVisible = false
            holder.binding.yukToEtk.isVisible = false
        }
        if (kayit.malzeme == "Mil") {
            holder.binding.tvEn.visibility = View.GONE
            holder.binding.tvYukseklik.visibility = View.GONE
            holder.binding.tvEtKalinligi.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
            holder.binding.enToYuk.isVisible = false
            holder.binding.yukToEtk.isVisible = false
        }
        if (kayit.malzeme == "Profil") {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
        }
        if (kayit.malzeme == "Köşebent") {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
        }
        if (kayit.malzeme == "Silme/Lama") {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.tvEtKalinligi.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
            holder.binding.yukToEtk.isVisible = false

        }
        if (kayit.malzeme == "Sac") {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.tvUzunluk.visibility = View.GONE
            holder.binding.tvTpUzunluk.visibility = View.GONE
            holder.binding.olcu3.visibility = View.GONE
            holder.binding.capToEn.isVisible = false

        }
        if (kayit.malzeme == "T Demir") {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.tvYukseklik.visibility = View.GONE
            holder.binding.capToEn.isVisible = false
            holder.binding.yukToEtk.isVisible = false
        }
        if (kayit.malzeme.contains("IPE", ignoreCase = true)) {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.capToEn.isVisible = false

        }
        if (kayit.malzeme.contains("IPN", ignoreCase = true)) {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.capToEn.isVisible = false


        }
        if (kayit.malzeme.contains("HE", ignoreCase = true)) {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.capToEn.isVisible = false

        }
        if (kayit.malzeme.contains("UP", ignoreCase = true)) {
            holder.binding.tvCap.visibility = View.GONE
            holder.binding.capToEn.isVisible = false

        }


        holder.binding.delete.setOnClickListener {

            kayitlardao(mcontext).sil(kayitList.get(position).id)
            kayitList.remove(kayitList[position])
            notifyDataSetChanged()
        }
    }

}



