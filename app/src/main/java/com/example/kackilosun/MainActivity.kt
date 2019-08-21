package com.example.kackilosun

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Gravity
import android.view.inputmethod.InputMethodManager


class MainActivity : AppCompatActivity() {


    val MARS = 0.3770
    val AY =0.166
    val MERKUR =0.378
    val JUPITER =2.528
    val SATURN=1.064
    val GUNES =27.072

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ekran yatay yada dik olunca sonuçları tekrar ekleyelim 108.satırla bağlantılı
        merkur_sonuc.text =savedInstanceState?.getString("merkur_sonuc")
        ay_sonucu.text =savedInstanceState?.getString("ay_sonucu")
        mars_sonucu.text=savedInstanceState?.getString("mars_sonucu")
        saturn_sonuc.text=savedInstanceState?.getString("saturn_sonuc")
        gunes_sonuc.text=savedInstanceState?.getString("gunes_sonuc")
        jupiter_sonuc.text=savedInstanceState?.getString("jupiter_sonuc")



             /*  //Butona basıldığında - Uzun kod
        btn_Hesapla.setOnClickListener (object :View.OnClickListener{
            override fun onClick(p0: View?) {

                Log.e("mesaj","butona basıldı")
            }

        })
            */


                //Butona basıldığında - KISA kod


        btn_Hesapla.setOnClickListener {
            keyboardHide()

            var kullaniciKilosu=editTextKilo.text





            if (!TextUtils.isEmpty(kullaniciKilosu) ){

            //kisi girilen kilo
            var kisiKilo =kullaniciKilosu.toString().toDouble()

            //kilo hesaplama ve  atama işlemleri
            var marsKilosu = ((kisiKilo* MARS).formatla()).toString()
            var ayKilosu = ((kisiKilo* AY).formatla()).toString()
            var merkurKilosu = ((kisiKilo* MERKUR).formatla()).toString()
            var jupiterKilosu = ((kisiKilo* JUPITER).formatla()).toString()
            var saturnKilosu = ((kisiKilo* SATURN).formatla()).toString()
            var gunesKilosu = ((kisiKilo* GUNES).formatla()).toString()


            //label'lara yazdırma işlemi
            merkur_sonuc.text =merkurKilosu +"kg"
            ay_sonucu.text =ayKilosu +"kg"
            mars_sonucu.text=marsKilosu+"kg"
            saturn_sonuc.text=saturnKilosu+"kg"
            gunes_sonuc.text=gunesKilosu+"kg"
            jupiter_sonuc.text=jupiterKilosu+"kg"

        }else{
                //eğer kullanıcı kilo değeri girmezse uygulama hata verip kapanmasın  - Uyarı versin !
                val toast = Toast.makeText(applicationContext, "Lütfen Önce Kilonuzu Girin !", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 180)
                toast.show()
            }

        }


    }
    //virgülden sonra sadece 1 basamak göstersin
    fun Double.formatla()= java.lang.String.format("%.1f",this)


    //Hesapla butonuna tıklanınca klavye Kapansın.
    fun keyboardHide(){
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    //Ekranı yatay yapınca veya yataydan dik yapınca sonuc değerlerini tekrar verelim
    //Sonuclar sıfırlanmasın diye !
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("merkur_sonuc",merkur_sonuc.text.toString())
        outState.putString("ay_sonucu",ay_sonucu.text.toString())
        outState.putString("mars_sonucu",mars_sonucu.text.toString())
        outState.putString("saturn_sonuc",saturn_sonuc.text.toString())
        outState.putString("gunes_sonuc",gunes_sonuc.text.toString())
        outState.putString("jupiter_sonuc",jupiter_sonuc.text.toString())

    }

}


