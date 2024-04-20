package com.seyma.agirlikhesap_nav

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.seyma.agirlikhesap_nav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){ //MainActivity Sınıfı: Bu sınıf, AppCompatActivity sınıfından türemiş bir sınıf.
                                         // AppCompatActivity, Android uygulamaları için özellikler sunan bir temel sınıftır.

    private lateinit var binding: ActivityMainBinding //binding Özelliği: binding adında bir ActivityMainBinding türünde özellik (property)
                                                      // tanımlandı. Bu özellik, ViewBinding kullanılarak
                                                      // activity_main.xml adındaki layout dosyasının öğelerine erişimi için kullanılır.




    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?){ // bu metot activity ilk oluştugunda çagrılır.
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //ilk olarak binding kullanılarak inflate edilir. Binding özelligine atanır
        setContentView(binding.root)



        val navfragment =
            supportFragmentManager.findFragmentById(R.id.navfragment) as NavHostFragment //activitenin içindeki NavHostFragment ı bulmak için kullanılr.
        //"as NavHostFragment" bu ID li fragmenti NavHostFragment tipine dönüştürür.
        NavigationUI.setupWithNavController(binding.navView, navfragment.navController) //Bu satır, NavigationView'ı bir NavController ile bağlamak için kullanılır.
        // Yukarıdaki bu metot, NavigationView'ı bir NavController ile bağlamak ve gezinme işlemlerini bu bağlam üzerinden yönetmek için kullanılır.
        // Bu sayede, NavigationView'daki menü öğeleri tıklanınca doğru fragmentlere geçiş yapılabilir.

        val baslik = binding.navView.inflateHeaderView(R.layout.navigation_baslik) //navView içinde R klasörü altında layout klasörü içindeki navigation_baslik isimli xml dosyasına erişti.
        val textViewBaslik = baslik.findViewById(R.id.textViewBaslik) as TextView //R.layout.navigation_baslik bu klasör içindeki textViewBaslik adındaki textView e erişti
        textViewBaslik.text = "Malzeme Türleri" //yazıyı belirledi
        val ImageViewLogo = baslik.findViewById(R.id.imageViewLogo) as ImageView //R.layout.navigation_baslik bu klasör içindeki imageViewLogo adındaki ImageView e erişti
        ImageViewLogo.setImageDrawable(resources.getDrawable(R.drawable.hsmlogo, null)) // erişilen resmi ekledi


        binding.toolbar.title = ("Ağırlık Hesaplama") //toolbar ın başlıgı
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))


        //Navigation Drawer'ın (açılır menü) görünümünü, davranışını ve senkronizasyonunu yapılandırmak için kullanılır.
        val toggle = ActionBarDrawerToggle(this, binding.drawer, binding.toolbar, 0, 0)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

        binding.buttonPast.setOnClickListener{
            startActivity(Intent(this, HesapListesiActivity::class.java))
        }




    }
        @Deprecated("Deprecated in Java")
        override fun onBackPressed() { //telefondaki geri tusuna basıldıgında yapılacak işlemler
            super.onBackPressed()

            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer((GravityCompat.START))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }




    }















