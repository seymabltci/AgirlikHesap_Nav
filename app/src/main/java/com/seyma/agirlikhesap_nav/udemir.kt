package com.seyma.agirlikhesap_nav
data class UDemirProperties(
    val name: String,
    val height: Double,
    val width: Double,
    val thicknessS: Double,
    val thicknessT: Double,
    val radius: Double,
    val agirlik:Double

)

fun getUDemirProperties(UDemir: String): UDemirProperties? {
    return when (UDemir) {
        "UPE 80 (80X50)"  ->UDemirProperties("UPE 80 (80X50)" ,80.0,50.0,4.0,7.0,10.0,0.0079)
        "UPE 100 (100X55)"  ->UDemirProperties("UPE 100 (100X55)" ,100.0,55.0,4.5,7.5,10.0,0.00982)
        "UPE 120 (120X60)"  ->UDemirProperties("UPE 120 (120X60)" ,120.0,60.0,5.0,8.0,12.0,0.0121)
        "UPE 140 (140X65)"  ->UDemirProperties("UPE 140 (140X65)" ,140.0,65.0,5.0,9.0,12.0,0.0145)
        "UPE 160 (160X70)"  ->UDemirProperties("UPE 160 (160X70)" ,160.0,70.0,5.5,9.0,12.0,0.017)
        "UPE 180 (180X75)"  ->UDemirProperties("UPE 180 (180X75)" ,180.0,75.0,5.5,10.5,12.0,0.0197)
        "UPE 200 (200X80)"  ->UDemirProperties("UPE 200 (200X80)" ,200.0,80.0,6.0,11.0,13.0,0.0228)
        "UPE 220 (220X85)"  ->UDemirProperties("UPE 220 (220X85)" ,220.0,85.0,6.5,12.0,13.0,0.0266)
        "UPE 240 (240X90)"  ->UDemirProperties("UPE 240 (240X90)" ,240.0,90.0,7.0,12.5,15.0,0.0302)
        "UPE 270 (270X95)"  ->UDemirProperties("UPE 270 (270X95)" ,270.0,95.0,7.5,13.5,15.0,0.0352)
        "UPE 300 (300X100)"  ->UDemirProperties("UPE 300 (300X100)" ,300.0,100.0,9.5,15.0,15.0,0.0444)
        "UPE 330 (330X105)"  ->UDemirProperties("UPE 330 (330X105)" ,330.0,105.0,11.0,16.0,18.0,0.0532)
        "UPE 360 (360X110)"  ->UDemirProperties("UPE 360 (360X110)" ,360.0,110.0,12.0,17.0,18.0,0.0612)
        "UPE 400 (400X115)"  ->UDemirProperties("UPE 400 (400X115)" ,400.0,115.0,13.5,18.0,18.0,0.0722)


        "UPN 80 (80X45)"  ->UDemirProperties("UPN 80 (80X45)" ,80.0,45.0,6.0,8.0,8.0,0.00865)
        "UPN 100 (100X50)"  ->UDemirProperties("UPN 100 (100X50)" ,100.0,50.0,6.0,8.5,8.5,0.0106)
        "UPN 120 (120X55)"  ->UDemirProperties("UPN 120 (120X55)" ,120.0,55.0,7.0,9.0,9.0,0.0134)
        "UPN 140 (140X60)"  ->UDemirProperties("UPN 140 (140X60)" ,140.0,60.0,7.0,10.0,10.0,0.016)
        "UPN 160 (160X65)"  ->UDemirProperties("UPN 160 (160X65)" ,160.0,65.0,7.5,10.5,10.5,0.0188)
        "UPN 180 (180X70) " ->UDemirProperties("UPN 180 (180X70)" ,180.0,70.0,8.0,11.0,11.0,0.022)
        "UPN 200 (200X75)"  ->UDemirProperties("UPN 200 (200X75)" ,200.0,75.0,8.5,11.5,11.5,0.0253)
        "UPN 220 (220X80)"  ->UDemirProperties("UPN 220 (220X80)" ,220.0,80.0,9.0,12.5,12.5,0.0294)
        "UPN 240 (240X85)"  ->UDemirProperties("UPN 240 (240X85)" ,240.0,85.0,9.5,13.0,13.0,0.0332)
        "UPN 260 (260X90)"  ->UDemirProperties("UPN 260 (260X90)" ,260.0,90.0,10.0,14.0,14.0,0.0379)
        "UPN 280 (280X95)"  ->UDemirProperties("UPN 280 (280X95)" ,280.0,95.0,10.0,15.0,15.0,0.0418)
        "UPN 300 (300X100)"  ->UDemirProperties("UPN 300 (300X100)" ,300.0,100.0,10.0,16.0,16.0,0.0462)
        "UPN 320 (320X100)"  ->UDemirProperties("UPN 320 (320X100)" ,320.0,100.0,14.0,17.5,17.5,0.0595)
        "UPN 350 (350X100)"  ->UDemirProperties("UPN 350 (350X100)" ,350.0,100.0,14.0,16.0,16.0,0.0606)
        "UPN 380 (380X102)"  ->UDemirProperties("UPN 380 (380X102)" ,380.0,102.0,13.5,16.0,16.0,0.0631)
        "UPN 400 (400X110)"  ->UDemirProperties("UPN 400 (400X110)" ,400.0,110.0,14.0,18.0,18.0,0.0718)









        else -> null
    }
}





































/*
if (UPEdemir == "UPE 80 (80X46)")    { yukseklik = 80.0 ; genislik = 46.0;  etKalinligis = 5.2;  etKalinligit = 3.8 }
if (UPEdemir == "UPE 100 (100X55)")  { yukseklik = 100.0; genislik = 55.0;  etKalinligis = 5.7;  etKalinligit = 4.1 }
if (UPEdemir == "UPE 120 (120X64)")  { yukseklik = 120.0; genislik = 64.0;  etKalinligis = 6.3;  etKalinligit = 4.4 }
if (UPEdemir == "UPE 140 (140X73)")  { yukseklik = 140.0; genislik = 73.0;  etKalinligis = 6.9;  etKalinligit = 4.7 }
if (UPEdemir == "UPE 160 (160X82)")  { yukseklik = 160.0; genislik = 82.0;  etKalinligis = 7.4;  etKalinligit = 5.0 }
if (UPEdemir == "UPE 180 (180X91)")  { yukseklik = 180.0; genislik = 91.0;  etKalinligis = 8.0;  etKalinligit = 5.3 }
if (UPEdemir == "UPE 200 (200X100)") { yukseklik = 200.0; genislik = 100.0; etKalinligis = 8.5;  etKalinligit = 5.6 }
if (UPEdemir == "UPE 220 (220X110)") { yukseklik = 220.0; genislik = 110.0; etKalinligis = 9.2;  etKalinligit = 5.9 }
if (UPEdemir == "UPE 240 (240X120)") { yukseklik = 240.0; genislik = 120.0; etKalinligis = 9.8;  etKalinligit = 6.2 }
if (UPEdemir == "UPE 270 (270X135)") { yukseklik = 270.0; genislik = 135.0; etKalinligis = 10.2; etKalinligit = 6.6 }
if (UPEdemir == "UPE 300 (300X150)") { yukseklik = 300.0; genislik = 150.0; etKalinligis = 10.7; etKalinligit = 7.1 }
if (UPEdemir == "UPE 330 (330X160)") { yukseklik = 330.0; genislik = 160.0; etKalinligis = 11.5; etKalinligit = 7.5 }
if (UPEdemir == "UPE 360 (360X170)") { yukseklik = 360.0; genislik = 170.0; etKalinligis = 12.7; etKalinligit = 8.0 }
if (UPEdemir == "UPE 400 (400X180)") { yukseklik = 400.0; genislik = 180.0; etKalinligis = 13.5; etKalinligit = 8.6 }
if (UPEdemir == "UPE 450 (450X190)") { yukseklik = 450.0; genislik = 190.0; etKalinligis = 14.6; etKalinligit = 9.4 }
if (UPEdemir == "UPE 500 (500X200)") { yukseklik = 500.0; genislik = 200.0; etKalinligis = 16.0; etKalinligit = 10.2 }
if (UPEdemir == "UPE 550 (550X210)") { yukseklik = 550.0; genislik = 210.0; etKalinligis = 17.2; etKalinligit = 11.1 }
if (UPEdemir == "UPE 600 (600X220)") { yukseklik = 600.0; genislik = 220.0; etKalinligis = 18.0; etKalinligit = 12.0 }

if (UPNdemir == "UPN 80 (80X42)")    { yukseklik = 80.0 ; genislik = 42.0;  etKalinligis = 5.9;  etKalinligit = 3.9 }
if (UPNdemir == "UPN 100 (100X50)")  { yukseklik = 100.0; genislik = 50.0;  etKalinligis = 6.8;  etKalinligit = 4.5 }
if (UPNdemir == "UPN 120 (120X58)")  { yukseklik = 120.0; genislik = 58.0;  etKalinligis = 7.7;  etKalinligit = 5.1 }
if (UPNdemir == "UPN 140 (140X66)")  { yukseklik = 140.0; genislik = 66.0;  etKalinligis = 8.6;  etKalinligit = 5.7 }
if (UPNdemir == "UPN 160 (160X74)")  { yukseklik = 160.0; genislik = 74.0;  etKalinligis = 9.5;  etKalinligit = 6.3 }
if (UPNdemir == "UPN 180 (180X82)")  { yukseklik = 180.0; genislik = 81.0;  etKalinligis = 10.4; etKalinligit = 6.9 }
if (UPNdemir == "UPN 200 (200X90)")  { yukseklik = 200.0; genislik = 90.0;  etKalinligis = 11.3; etKalinligit = 7.5 }
if (UPNdemir == "UPN 220 (220X98)")  { yukseklik = 220.0; genislik = 98.0;  etKalinligis = 12.2; etKalinligit = 8.1 }
if (UPNdemir == "UPN 240 (240X106)") { yukseklik = 240.0; genislik = 106.0; etKalinligis = 13.1; etKalinligit = 8.7 }
if (UPNdemir == "UPN 260 (260X113)") { yukseklik = 260.0; genislik = 113.0; etKalinligis = 14.1; etKalinligit = 9.4 }
if (UPNdemir == "UPN 280 (280X119)") { yukseklik = 280.0; genislik = 119.0; etKalinligis = 15.2; etKalinligit = 10.1 }
if (UPNdemir == "UPN 300 (300X125)") { yukseklik = 300.0; genislik = 125.0; etKalinligis = 16.2; etKalinligit = 10.8 }
if (UPNdemir == "UPN 330 (330X131)") { yukseklik = 330.0; genislik = 131.0; etKalinligis = 17.3; etKalinligit = 11.5 }
if (UPNdemir == "UPN 340 (340X137)") { yukseklik = 340.0; genislik = 137.0; etKalinligis = 18.3; etKalinligit = 12.2 }
if (UPNdemir == "UPN 360 (360X143)") { yukseklik = 360.0; genislik = 143.0; etKalinligis = 19.5; etKalinligit = 13.0 }
if (UPNdemir == "UPN 380 (380X149)") { yukseklik = 380.0; genislik = 149.0; etKalinligis = 20.5; etKalinligit = 13.7 }
if (UPNdemir == "UPN 400 (400X155)") { yukseklik = 400.0; genislik = 155.0; etKalinligis = 21.6; etKalinligit = 14.4 }
if (UPNdemir == "UPN 450 (450X170)") { yukseklik = 450.0; genislik = 170.0; etKalinligis = 24.3; etKalinligit = 16.2 }
if (UPNdemir == "UPN 500 (500X185)") { yukseklik = 500.0; genislik = 180.0; etKalinligis = 27.0; etKalinligit = 18.0 }
if (UPNdemir == "UPN 550 (550X200)") { yukseklik = 550.0; genislik = 200.0; etKalinligis = 30.0; etKalinligit = 19.0 }
if (UPNdemir == "UPN 600 (600X215)") { yukseklik = 600.0; genislik = 215.0; etKalinligis = 32.4; etKalinligit = 21.6 }

 */