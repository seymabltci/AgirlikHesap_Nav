package com.seyma.agirlikhesap_nav

data class IDemirProperties(
    val name: String,
    val height: Int,
    val width: Int,
    val thicknessS: Double,
    val thicknessT: Double,
    val radius: Double,
    val agirlik:Double

)

fun getIDemirProperties(idemir: String): IDemirProperties? {
    return when (idemir) {
        "IPE 80 (80X46)"   -> IDemirProperties("IPE 80 (80X46)", 80,  46,  5.2,  3.8, 5.0,0.006 )
        "IPE 100 (100X55)" -> IDemirProperties("IPE 100 (100X55)",100,  55,  5.7,  4.1, 7.0,0.0081)
        "IPE 120 (120X64)" -> IDemirProperties("IPE 120 (120X64)",120,  64,  6.3,  4.4,7.0 ,0.0104)
        "IPE 140 (140X73)" -> IDemirProperties("IPE 140 (140X73)",140,  73,  6.9,  4.7,7.0,0.0129 )
        "IPE 160 (160X82)" -> IDemirProperties("IPE 160 (160X82)",160,  82,  7.4,  5.0,9.0,0.0158 )
        "IPE 180 (180X91)" -> IDemirProperties("IPE 180 (180X91)",180,  91,  8.0,  5.3,9.0,0.0188 )
        "IPE 200 (200X100)" -> IDemirProperties("IPE 200 (200X100)",200,  100, 8.5,  5.6,12.0,0.0224 )
        "IPE 220 (220X110)" -> IDemirProperties("IPE 220 (220X110)",220,  110, 9.2,  5.9,12.0,0.0262 )
        "IPE 240 (240X120)" -> IDemirProperties("IPE 240 (240X120)",240,  120, 9.8,  6.2,15.0,0.0307 )
        "IPE 270 (270X135)" -> IDemirProperties("IPE 270 (270X135)",270,  135, 10.2, 6.6,15.0,0.0361 )
        "IPE 300 (300X150)" -> IDemirProperties("IPE 300 (300X150)",300,  150, 10.7, 7.1,15.0,0.0422 )
        "IPE 330 (330X160)" -> IDemirProperties("IPE 330 (330X160)",330,  160, 11.5, 7.5,18.0,0.0491 )
        "IPE 360 (360X170)" -> IDemirProperties("IPE 360 (360X170)",360,  170, 12.7, 8.0,18.0,0.0571 )
        "IPE 400 (400X180)" -> IDemirProperties("IPE 400 (400X180)",400,  180, 13.5, 8.6,21.0,0.0663 )
        "IPE 450 (450X190)" -> IDemirProperties("IPE 450 (450X190)",450,  190, 14.6, 9.4,21.0,0.0776 )
        "IPE 500 (500X200)" -> IDemirProperties("IPE 500 (500X200)",500,  200, 16.0, 10.2,21.0,0.0906 )
        "IPE 550 (550X210)" -> IDemirProperties("IPE 550 (550X210)",550,  210, 17.2, 11.1,24.0,0.106 )
        "IPE 600 (600X220)" -> IDemirProperties("IPE 600 (600X220)",600,  220, 18.0, 12.0,24.0,0.122 )

        "IPN 80 (80X42)"    -> IDemirProperties("IPN 80 (80X42)", 80 ,  42,  5.9,  3.9, 3.9, 0.0059 )
        "IPN 100 (100X50)"  -> IDemirProperties("IPN 100 (100X50)",100,  50,  6.8,  4.5,4.5,0.0083 )
        "IPN 120 (120X58)"  -> IDemirProperties("IPN 120 (120X58)",120,  58,  7.7,  5.1,5.1,0.011 )
        "IPN 140 (140X66)"  -> IDemirProperties("IPN 140 (140X66)",140,  66,  8.6,  5.7,5.7,0.014 )
        "IPN 160 (160X74)"  -> IDemirProperties("IPN 160 (160X74)",160,  74,  9.5,  6.3 ,6.3,0.017)
        "IPN 180 (180X82)"  -> IDemirProperties("IPN 180 (180X82)",180,  81,  10.4, 6.9,6.9,0.021 )
        "IPN 200 (200X90)"  -> IDemirProperties("IPN 200 (200X90)",200,  90,  11.3, 7.5,7.5,0.026 )
        "IPN 220 (220X98)"   -> IDemirProperties("IPN 220 (220X98)",220,  98,  12.2, 8.1,8.1,0.031 )
        "IPN 240 (240X106)"  -> IDemirProperties("IPN 240 (240X106)",240,  106, 13.1, 8.7,8.7,0.036 )
        "IPN 260 (260X113)"  -> IDemirProperties("IPN 260 (260X113)",260,  113, 14.1, 9.4,9.4,0.041 )
        "IPN 280 (280X119)"  -> IDemirProperties("IPN 280 (280X119)",280,  119, 15.2, 10.1,10.1,0.047 )
        "IPN 300 (300X125)"  -> IDemirProperties("IPN 300 (300X125)",300,  125, 16.2, 10.8,10.8,0.054 )
        "IPN 320 (330X131)"  -> IDemirProperties("IPN 320 (320X131)",320,  131, 17.3, 11.5,11.5,0.061 )
        "IPN 340 (340X137)"  -> IDemirProperties("IPN 340 (340X137)",340,  137, 18.3, 12.2,12.2,0.068 )
        "IPN 360 (360X143)"  -> IDemirProperties("IPN 360 (360X143)",360,  143, 19.5, 13.0,13.0,0.0761 )
        "IPN 380 (380X149)"  -> IDemirProperties("IPN 380 (380X149)",380,  149, 20.5, 13.7,13.7,0.0840 )
        "IPN 400 (400X155)"  -> IDemirProperties("IPN 400 (400X155)",400,  155, 21.6, 14.4 ,14.4,0.0924)
        "IPN 450 (450X170)"  -> IDemirProperties("IPN 450 (450X170)",450,  170, 24.3, 16.2 ,16.2,0.115)
        "IPN 500 (500X185)"  -> IDemirProperties("IPN 500 (500X185)",500,  180, 27.0, 18.0 ,18.0,0.128)
        "IPN 550 (550X200)"  -> IDemirProperties("IPN 550 (550X200)",5500,  200, 30.0, 19.0 ,19.0,0.141)
        "IPN 600 (600X215)"  -> IDemirProperties("IPN 600 (600X215)",600,  215, 32.4, 21.6 ,21.6,0.166)


        "HE A 100 (100X114)" ->	IDemirProperties("HE A 100 (100X96)",96,100,8.0,5.0,10.0,0.01670)
        "HE A 120 (120X114)" ->	IDemirProperties("HE A 120 (120X114)",114,120,8.0,5.0,12.0,0.01990)
        "HE A 140 (140X133)" ->	IDemirProperties("HE A 140 (140X133)",133,140,8.5,5.5,12.0,0.02470)
        "HE A 160 (160X152)" ->	IDemirProperties("HE A 160 (160X152)",152,160,9.0,6.0,15.0,0.03040)
        "HE A 180 (180X171)" ->	IDemirProperties("HE A 180 (180X171)",171,180,9.5,6.0,15.0,0.03550)
        "HE A 200 (200X190)" ->	IDemirProperties("HE A 200 (200X190)",190,200,10.0,6.5,18.0,0.04230)
        "HE A 220 (220X210)" ->	IDemirProperties("HE A 220 (220X210)",210,220,11.0,7.0,18.0,0.05050)
        "HE A 240 (240X230)" ->	IDemirProperties("HE A 240 (240X230)",230,240,12.0,7.5,21.0,0.06030)
        "HE A 260 (260X250)" ->	IDemirProperties("HE A 260 (260X250)",250,260,12.5,7.5,24.0,0.06820)
        "HE A 280 (280X270)" ->	IDemirProperties("HE A 280 (280X270)",270,280,13.0,8.0,24.0,0.07640)
        "HE A 300 (300X290)" ->	IDemirProperties("HE A 300 (300X290)",290,300,14.0,8.5,27.0,0.08830)
        "HE A 320 (300X310)" ->	IDemirProperties("HE A 320 (300X310)",310,300,15.5,9.0,27.0,0.09760)
        "HE A 340 (300X330)" ->	IDemirProperties("HE A 340 (300X330)",330,300,16.5,9.5,27.0,	0.105)
        "HE A 360 (300X350)" ->	IDemirProperties("HE A 360 (300X350)",350,300,17.5,10.0,27.0,0.112)
        "HE A 400 (300X390)" ->	IDemirProperties("HE A 400 (300X390)",390,300,19.0,11.0,27.0,0.125)
        "HE A 450 (300X440)" ->	IDemirProperties("HE A 450 (300X440)",440,300,21.0,11.5,27.0,0.140)
        "HE A 500 (300X490)" ->	IDemirProperties("HE A 500 (300X490)",490,300,23.0,12.0,27.0,0.155)
        "HE A 550 (300X540)" ->	IDemirProperties("HE A 550 (300X540)",540,300,24.0,12.5,27.0,0.166)
        "HE A 600 (300X590)" ->	IDemirProperties("HE A 600 (300X590)",590,300,25.0,13.0,27.0,0.178)
        "HE A 650 (300X640)" ->	IDemirProperties("HE A 650 (300X640)",640,300,26.0,13.5,27.0,0.190)
        "HE A 700 (300X690)" ->	IDemirProperties("HE A 700 (300X690)",690,300,27.0,14.5,27.0,0.204)
        "HE A 800 (300X790)" ->	IDemirProperties("HE A 800 (300X790)",790,300,28.0,15.0,30.0,0.224)
        "HE A 900 (300X890)" ->	IDemirProperties("HE A 900 (300X890)",890,300,30.0,16.0,30.0,0.252)
        "HE A 1000 (300X990)" ->IDemirProperties("HE A 1000 (300X990)",990,300,31.0,16.5,30.0,0.272)

        "HE B  100 (100X100)" ->IDemirProperties("HE B  100 (100X100)",100,100,10.0,6.0,12.0,0.0204)
        "HE B  120 (120X120)"->IDemirProperties("HE B  120 (120X120)",120,120,11.0,6.5,12.0,0.0267)
        "HE B  140 (140X140)" ->IDemirProperties("HE B  140 (140X140)",140,140,12.0,7.0,12.0,0.0337)
        "HE B  160 (160X160)" ->IDemirProperties("HE B  160 (160X160)",160,160,13.0,8.0,15.0,0.0426)
        "HE B  180 (180X180)" ->IDemirProperties("HE B  180 (180X180)",180,180,14.0,8.5,15.0,0.0512)
        "HE B  200 (200X200)" ->IDemirProperties("HE B  200 (200X200)",200,200,15.0,9.0,18.0,0.0613)
        "HE B  220 (220X220)" ->IDemirProperties("HE B  220 (220X220)",220,220,16.0,9.5,18.0,0.0715)
        "HE B  240 (240X240)" ->IDemirProperties("HE B  240 (240X240)",240,240,17.0,10.0,21.0,0.0832)
        "HE B  260 (260X260)" ->IDemirProperties("HE B  260 (260X260)",260,260,17.5,10.0,24.0,0.0932)
        "HE B  280 (280X280)" ->IDemirProperties("HE B  280 (280X280)",280,280,18.0,10.5,24.0,0.103)
        "HE B  300 (300X300)" ->IDemirProperties("HE B  300 (300X300)",300,300,19.0,11.0,27.0,0.117)
        "HE B  320 (320X300)" ->IDemirProperties("HE B  320 (320X300)",320,300,20.5,11.5,27.0,0.127)
        "HE B  340 (340X300)" ->IDemirProperties("HE B  340 (340X300)",340,30,21.5,12.0,27.0,0.134)
        "HE B  360 (360X300)" ->IDemirProperties("HE B  360 (360X300)",360,300,22.5,12.5,27.0,0.142)
        "HE B  400 (400X300)" ->IDemirProperties("HE B  400 (400X300)",400,300,24.0,13.5,27.0,0.155)
        "HE B  450 (450X300)" ->IDemirProperties("HE B  450 (450X300)",450,300,26.0,14.0,27.0,0.171)
        "HE B  500 (500X300)" ->IDemirProperties("HE B  500 (500X300)",500,300,28.0,14.5,27.0,0.187)
        "HE B  550 (550X300)" ->IDemirProperties("HE B  550 (550X300)",550,300,29.0,15.0,27.0,0.199)
        "HE B  600 (600X300)" ->IDemirProperties("HE B  600 (600X300)",600,300,30.0,15.5,27.0,0.212)
        "HE B  650 (650X300)" ->IDemirProperties("HE B  650 (650X300)",650,300,31.0,16.0,27.0,0.225)
        "HE B  700 (700X300)" ->IDemirProperties("HE B  700 (700X300)",700,300,32.0,17.0,27.0,0.241)
        "HE B  800 (800X300)" ->IDemirProperties("HE B  800 (800X300)",800,300,33.0,17.5,30.0,0.262)
        "HE B  900 (900X300)" ->IDemirProperties("HE B  900 (900X300)",900,300,35.0,18.5,30.0,0.291)
        "HE B  1000 (1000X300)" ->IDemirProperties("HE B  1000 (1000X300)",1000,300,36.0,19.0,30.0,0.314)

        "HE M 100 (120X106)" ->IDemirProperties("HE M 100 (120X106)",120,106,20.0,12.0,12.0,0.0418)
        "HE M 120 (140X126)" ->IDemirProperties("HE M 120 (140X126)",140,126,21.0,12.5,12.0,0.0521)
        "HE M 140 (160X146)" ->IDemirProperties("HE M 140 (160X146)",160,146,22.0,13.0,12.0,0.0632)
        "HE M 160 (180X166)" ->IDemirProperties("HE M 160 (180X166)",180,166,23.0,14.0,15.0,0.0762)
        "HE M 180 (200X186)" ->IDemirProperties("HE M 180 (200X186)",200,186,24.0,14.5,15.0,0.0889)
        "HE M 200 (220X206)" ->IDemirProperties("HE M 200 (220X206)",220,206,25.0,15.0,18.0,0.103)
        "HE M 220 (240X226)" ->IDemirProperties("HE M 220 (240X226)",240,226,26.0,15.5,18.0,0.117)
        "HE M 240 (270X248)" ->IDemirProperties("HE M 240 (270X248)",270,248,32.0,18.0,21.0,0.157)
        "HE M 260 (290X268)" ->IDemirProperties("HE M 260 (290X268)",290,268,32.5,18.0,24.0,0.172)
        "HE M 280 (310X288)" ->IDemirProperties("HE M 280 (310X288)",310,288,33.0,18.5,24.0,0.189)
        "HE M 300 (340X310)" ->IDemirProperties("HE M 300 (340X310)",340,310,39.0,21.0,27.0,0.238)
        "HE M 320 (359X309)" ->IDemirProperties("HE M 320 (359X309)",359,309,40.0,21.0,27.0,0.245)
        "HE M 340 (377X309)" ->IDemirProperties("HE M 340 (377X309)",377,309,40.0,21.0,27.0,0.248)
        "HE M 360 (395X308)" ->IDemirProperties("HE M 360 (395X308)",395,308,40.0,21.0,27.0,0.250)
        "HE M 400 (432X307)" ->IDemirProperties("HE M 400 (432X307)",432,307,40.0,21.0,27.0,0.256)
        "HE M 450 (478X307)" ->IDemirProperties("HE M 450 (478X307)",478,307,40.0,21.0,27.0,0.263)
        "HE M 500 (524X306)" ->IDemirProperties("HE M 500 (524X306)",524,306,40.0,21.0,27.0,0.270)
        "HE M 550 (572X306)" ->IDemirProperties("HE M 550 (572X306)",572,306,40.0,21.0,27.0,0.278)
        "HE M 600 (620X305)" ->IDemirProperties("HE M 600 (620X305)",620,305,40.0,21.0,27.0,0.285)
        "HE M 650 (668X305)" ->IDemirProperties("HE M 650 (668X305)",668,305,40.0,21.0,27.0,0.293)
        "HE M 700 (716X304)" ->IDemirProperties("HE M 700 (716X304)",716,304,40.0,21.0,27.0,0.301)
        "HE M 800 (800X300)" ->IDemirProperties("HE M 800 (800X300)",800,300,33.0,17.5,30.0,0.317)
        "HE M 900 (910X302)" ->IDemirProperties("HE M 900 (910X302)",910,302,40.0,21.0,30.0,0.333)
        "HE M 1000 (1008X302)" ->IDemirProperties("HE M 1000 (1008X302)",1008,302,40.0,21.0,30.0,0.349)









        else -> null
    }
}





































/*
if (ipedemir == "IPE 80 (80X46)")    { yukseklik = 80.0 ; genislik = 46.0;  etKalinligis = 5.2;  etKalinligit = 3.8 }
if (ipedemir == "IPE 100 (100X55)")  { yukseklik = 100.0; genislik = 55.0;  etKalinligis = 5.7;  etKalinligit = 4.1 }
if (ipedemir == "IPE 120 (120X64)")  { yukseklik = 120.0; genislik = 64.0;  etKalinligis = 6.3;  etKalinligit = 4.4 }
if (ipedemir == "IPE 140 (140X73)")  { yukseklik = 140.0; genislik = 73.0;  etKalinligis = 6.9;  etKalinligit = 4.7 }
if (ipedemir == "IPE 160 (160X82)")  { yukseklik = 160.0; genislik = 82.0;  etKalinligis = 7.4;  etKalinligit = 5.0 }
if (ipedemir == "IPE 180 (180X91)")  { yukseklik = 180.0; genislik = 91.0;  etKalinligis = 8.0;  etKalinligit = 5.3 }
if (ipedemir == "IPE 200 (200X100)") { yukseklik = 200.0; genislik = 100.0; etKalinligis = 8.5;  etKalinligit = 5.6 }
if (ipedemir == "IPE 220 (220X110)") { yukseklik = 220.0; genislik = 110.0; etKalinligis = 9.2;  etKalinligit = 5.9 }
if (ipedemir == "IPE 240 (240X120)") { yukseklik = 240.0; genislik = 120.0; etKalinligis = 9.8;  etKalinligit = 6.2 }
if (ipedemir == "IPE 270 (270X135)") { yukseklik = 270.0; genislik = 135.0; etKalinligis = 10.2; etKalinligit = 6.6 }
if (ipedemir == "IPE 300 (300X150)") { yukseklik = 300.0; genislik = 150.0; etKalinligis = 10.7; etKalinligit = 7.1 }
if (ipedemir == "IPE 330 (330X160)") { yukseklik = 330.0; genislik = 160.0; etKalinligis = 11.5; etKalinligit = 7.5 }
if (ipedemir == "IPE 360 (360X170)") { yukseklik = 360.0; genislik = 170.0; etKalinligis = 12.7; etKalinligit = 8.0 }
if (ipedemir == "IPE 400 (400X180)") { yukseklik = 400.0; genislik = 180.0; etKalinligis = 13.5; etKalinligit = 8.6 }
if (ipedemir == "IPE 450 (450X190)") { yukseklik = 450.0; genislik = 190.0; etKalinligis = 14.6; etKalinligit = 9.4 }
if (ipedemir == "IPE 500 (500X200)") { yukseklik = 500.0; genislik = 200.0; etKalinligis = 16.0; etKalinligit = 10.2 }
if (ipedemir == "IPE 550 (550X210)") { yukseklik = 550.0; genislik = 210.0; etKalinligis = 17.2; etKalinligit = 11.1 }
if (ipedemir == "IPE 600 (600X220)") { yukseklik = 600.0; genislik = 220.0; etKalinligis = 18.0; etKalinligit = 12.0 }

if (ipndemir == "IPN 80 (80X42)")    { yukseklik = 80.0 ; genislik = 42.0;  etKalinligis = 5.9;  etKalinligit = 3.9 }
if (ipndemir == "IPN 100 (100X50)")  { yukseklik = 100.0; genislik = 50.0;  etKalinligis = 6.8;  etKalinligit = 4.5 }
if (ipndemir == "IPN 120 (120X58)")  { yukseklik = 120.0; genislik = 58.0;  etKalinligis = 7.7;  etKalinligit = 5.1 }
if (ipndemir == "IPN 140 (140X66)")  { yukseklik = 140.0; genislik = 66.0;  etKalinligis = 8.6;  etKalinligit = 5.7 }
if (ipndemir == "IPN 160 (160X74)")  { yukseklik = 160.0; genislik = 74.0;  etKalinligis = 9.5;  etKalinligit = 6.3 }
if (ipndemir == "IPN 180 (180X82)")  { yukseklik = 180.0; genislik = 81.0;  etKalinligis = 10.4; etKalinligit = 6.9 }
if (ipndemir == "IPN 200 (200X90)")  { yukseklik = 200.0; genislik = 90.0;  etKalinligis = 11.3; etKalinligit = 7.5 }
if (ipndemir == "IPN 220 (220X98)")  { yukseklik = 220.0; genislik = 98.0;  etKalinligis = 12.2; etKalinligit = 8.1 }
if (ipndemir == "IPN 240 (240X106)") { yukseklik = 240.0; genislik = 106.0; etKalinligis = 13.1; etKalinligit = 8.7 }
if (ipndemir == "IPN 260 (260X113)") { yukseklik = 260.0; genislik = 113.0; etKalinligis = 14.1; etKalinligit = 9.4 }
if (ipndemir == "IPN 280 (280X119)") { yukseklik = 280.0; genislik = 119.0; etKalinligis = 15.2; etKalinligit = 10.1 }
if (ipndemir == "IPN 300 (300X125)") { yukseklik = 300.0; genislik = 125.0; etKalinligis = 16.2; etKalinligit = 10.8 }
if (ipndemir == "IPN 330 (330X131)") { yukseklik = 330.0; genislik = 131.0; etKalinligis = 17.3; etKalinligit = 11.5 }
if (ipndemir == "IPN 340 (340X137)") { yukseklik = 340.0; genislik = 137.0; etKalinligis = 18.3; etKalinligit = 12.2 }
if (ipndemir == "IPN 360 (360X143)") { yukseklik = 360.0; genislik = 143.0; etKalinligis = 19.5; etKalinligit = 13.0 }
if (ipndemir == "IPN 380 (380X149)") { yukseklik = 380.0; genislik = 149.0; etKalinligis = 20.5; etKalinligit = 13.7 }
if (ipndemir == "IPN 400 (400X155)") { yukseklik = 400.0; genislik = 155.0; etKalinligis = 21.6; etKalinligit = 14.4 }
if (ipndemir == "IPN 450 (450X170)") { yukseklik = 450.0; genislik = 170.0; etKalinligis = 24.3; etKalinligit = 16.2 }
if (ipndemir == "IPN 500 (500X185)") { yukseklik = 500.0; genislik = 180.0; etKalinligis = 27.0; etKalinligit = 18.0 }
if (ipndemir == "IPN 550 (550X200)") { yukseklik = 550.0; genislik = 200.0; etKalinligis = 30.0; etKalinligit = 19.0 }
if (ipndemir == "IPN 600 (600X215)") { yukseklik = 600.0; genislik = 215.0; etKalinligis = 32.4; etKalinligit = 21.6 }

 */