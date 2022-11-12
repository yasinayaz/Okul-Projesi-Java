package okulProje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {
static Scanner scan = new Scanner(System.in);
   static Map<String,String> ogrenciMap= new HashMap<>();

    public static void feykOgrenciEkle(){
        ogrenciMap.put("123456789112","Ali,Can,2008,3569,12,A");
        ogrenciMap.put("123456789113","Veli,Yan,2008,3563,12,B");
        ogrenciMap.put("123456789114","Ayse,Can,2007,32369,12,A");
        ogrenciMap.put("123456789115","Ali,San,2009,3578,11,A");
        ogrenciMap.put("123456789111","AlP,Can,2009,3561,11,A");



    }
    public static void ogrenciMenu() throws InterruptedException {
        String tercih="";

        do{
            System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                    "==========   OGRENCİ MENU   ======================\n"+
                    "\n"+
                    "\t   1-Ogrenci Listesi Yazdır\t\n" +
                    "\t   2-Soyisimden Ogrenci Bulma\n"+
                    "\t   3-Sınıf ve Şube ile Öğrenci Bulma \n"+
                    "\t   4-Bilgilerini Girerek Ogrenci Ekleme \n"+
                    "\t   5-Kimlik No Ile Kayıt Silme \t\n"+
                    "\t   A-ANAMENU\n"+
                    "\t   Q-ÇIKIŞ\n");
            tercih= scan.nextLine();

            switch (tercih){
                case "1":
                    ogrenciListeYazdır();
                    break;
                case "2":
                    soyisimdenOgrenciBulma();
                    break;
                case "3":
                    sinifveSubeileOgrenciBulma();
                    break;
                case "4":
                    ogrenciEkle();
                    break;
                case "5":
                    tcNoIleOgrenciSilme();
                    break;
                case "a":
                case "A":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    Depo.projeDurdur();
                    break;


            }

        }while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();



    }

    public static void tcNoIleOgrenciSilme() {

        System.out.println("Silinecek öğrenci kimlik no giriniz");
        String silinecekOgrnci=scan.nextLine();
        String silinecekValue=ogrenciMap.get(silinecekOgrnci);
        String sonucValue=ogrenciMap.remove(silinecekOgrnci);

        try {
            boolean sonuc= (sonucValue.equals(silinecekValue));
        } catch (Exception e) {
            System.out.println("İstenilen tc bulunamadı");        }

    }

    public static void ogrenciEkle() {
        System.out.println("Tc no giriniz");
        String tcNo=scan.nextLine();
        System.out.println("İsim giriniz");
        String isim=scan.nextLine();
        System.out.println("Soyisim giriniz");
        String soyisim=scan.nextLine();
        System.out.println("Doğum Yılı giriniz");
        String dogumYili=scan.nextLine();
        System.out.println("Okul no giriniz");
        String okulNo=scan.nextLine();
        System.out.println("Sınıf giriniz");
        String sinif=scan.nextLine();
        System.out.println("Şube giriniz");
        String sube=scan.nextLine();

        String key=tcNo;
        String value= isim+","+soyisim+","+dogumYili+","+okulNo+","+sinif+","+sube;

        ogrenciMap.put(key,value);



    }

    public static void sinifveSubeileOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrenciMap.entrySet();
        System.out.println("İstediğiniz öğrenci sınıfını yazınız");
        String istenilenSinif= scan.nextLine();
        System.out.println("İstediğiniz öğrenci şubesini yazınız");
        String istenilenSube= scan.nextLine();

        System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                "==========   OGRENCİ LİSTESİ   ======================\n"+
                "TC NO         İSİM    SOYİSİM    DYILI   OKUL NO  SINIF ŞUBE");

        for (Map.Entry<String,String> each: myEntrySet){

            String eachValue=each.getValue();
            String eachKey=each.getKey();
            String eachValueArr[]=eachValue.split(",");
            if(istenilenSinif.equalsIgnoreCase(eachValueArr[4])  &&  istenilenSube.equalsIgnoreCase(eachValueArr[5])){
                System.out.printf("%12s  %-6s  %-9s  %-7s  %-4s  %-5s  %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3],eachValueArr[4],eachValueArr[5]);
            }
        }
        Thread.sleep(5000);
    }

    private static void soyisimdenOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrenciMap.entrySet();
        System.out.println("İstediğiniz öğrenci soyismini yazınız");
        String istenilenSoyisim= scan.nextLine();
        System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                "==========   OGRENCİ LİSTESİ   ======================\n"+
                "TC NO         İSİM    SOYİSİM    DYILI   OKUL NO  SINIF ŞUBE");

        for (Map.Entry<String,String> each: myEntrySet){

            String eachValue=each.getValue();
            String eachKey=each.getKey();
            String eachValueArr[]=eachValue.split(",");
            if(istenilenSoyisim.equalsIgnoreCase(eachValueArr[1])){
                System.out.printf("%12s  %-6s  %-9s  %-7s  %-4s  %-5s  %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3],eachValueArr[4],eachValueArr[5]);
            }
        }
        Thread.sleep(5000);


    }

    public static void ogrenciListeYazdır() throws InterruptedException {

        Set<Map.Entry<String,String>> myEntrySet=ogrenciMap.entrySet();
        System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                "==========   OGRENCİ LİSTESİ   ======================\n"+
                "TC NO         İSİM    SOYİSİM    DYILI   OKUL NO  SINIF ŞUBE");

        for (Map.Entry<String,String> each: myEntrySet){

            String eachValue=each.getValue();
            String eachKey=each.getKey();
            String eachValueArr[]=eachValue.split(",");
                System.out.printf("%12s  %-6s  %-9s  %-7s  %-4s  %-5s  %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3],eachValueArr[4],eachValueArr[5]);
        }
                Thread.sleep(5000);

    }


}
