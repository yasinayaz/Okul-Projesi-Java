package okulProje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);

    static Map<String , String >ogretmenlerMap=new HashMap<>();
    public static void feykOgretmenEkle(){
        ogretmenlerMap.put("123456789411","Ali,Can,1980,Matematik");
        ogretmenlerMap.put("123456789412","Veli,Yan,1981,Fizik");
        ogretmenlerMap.put("123456789413","Ayse,Can,1982,Kimya");
        ogretmenlerMap.put("123456789414","Ali,San,1983,Kimya");
        ogretmenlerMap.put("123456789415","Alp,Yan,1984,Matematik");
       // System.out.println(ogretmenlerMap);
    }


    public static void ogretmenMenu() throws InterruptedException {
        String tercih="";
            do{
                System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                                   "==========   OGRETMEN MENU   ======================\n"+
                        "\n"+
                        "\t   1-Ogretmenler Listesini Yazdır\t\n" +
                        "\t   2-Soyisimden Ogretmen Bulma\n"+
                        "\t   3-Branstan Ogretmen Bulma \n"+
                        "\t   4-Bilgilerini Girerek Ogretmen Ekleme \n"+
                        "\t   5-Kimlik No Ile Kayıt Silme \t\n"+
                        "\t   A-ANAMENU\n"+
                        "\t   Q-ÇIKIŞ\n");

                tercih=scan.nextLine();

                switch (tercih){

                    case "1": //Ogretmenler Listesini Yazdır
                        ogretmenListesiYazdır();
                        break;
                    case "2":  //Soyisimden Ogretmen Bulma
                        soyisimdenOgretmenBulma();
                        break;
                    case "3":
                        bransdanOgretmenBulma();
                        break;
                    case "4":
                        ogretmenEkleme();
                        break;
                    case "5":
                        tcNoileOgretmenSil();
                        break;
                    case "a":
                    case "A":
                        Depo.anaMenu();
                        break;
                    case "q":
                    case "Q":
                        break;
                    default:
                        System.out.println("Lütfen geçerli tercih giriniz");




                }

            }while (!tercih.equalsIgnoreCase("q"));

            Depo.projeDurdur();



    }

    public static void tcNoileOgretmenSil() {
        System.out.println("Silinecek öğretmen kimlik no giriniz");
        String silinecekOgretmen=scan.nextLine();
        String silinecekValue=ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue=ogretmenlerMap.remove(silinecekOgretmen);

        try {
           boolean sonuc= (sonucValue.equals(silinecekValue));
        } catch (Exception e) {
            System.out.println("İstenilen tc bulunamadı");        }
    }

    private static void ogretmenEkleme() {
        System.out.println("tc no giriniz");
        String tcNo= scan.nextLine();
        System.out.println("isim giriniz");
        String isim= scan.nextLine();
        System.out.println("soyisim giriniz");
        String soyisim= scan.nextLine();
        System.out.println("doğum yılı giriniz");
        String dogumYili= scan.nextLine();
        System.out.println("branş giriniz");
        String brans= scan.nextLine();

        String eklenecekValue=isim +","+soyisim+","+dogumYili+","+brans;
        ogretmenlerMap.put(tcNo,eklenecekValue);

    }

    public static void bransdanOgretmenBulma() throws InterruptedException {
        System.out.printf("aradığınız Ogretmenin branşını giriniz");
        String istenenSoyisim= scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenEntrySet=ogretmenlerMap.entrySet();
        System.out.println("==========      YILDIZ KOLEJI   ======================\n"+
                "==========   BRANŞ İLE ÖĞRETMEN ARAMA  ======================\n"+
                "TC NO       İSİM        SOYİSİM       D.YILI     BRANS");


        for (Map.Entry<String,String> each:ogretmenEntrySet
        ) {String eachKey= each.getKey();
            String eachValue=each.getValue();

            String eachValuarr[]=eachValue.split(",");
            if(istenenSoyisim.equalsIgnoreCase(eachValuarr[3])){
                System.out.printf("%11s  %-6s  %-8s  %4s  %s \n",eachKey,eachValuarr[0],eachValuarr[1],eachValuarr[2],eachValuarr[3]);
            }

        }
        Thread.sleep(5000);
    }

    private static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.printf("aradığınız Ogretmenin soyismini giriniz");
        String istenenSoyisim= scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenEntrySet=ogretmenlerMap.entrySet();
        System.out.println("==========      YILDIZ KOLEJI   ======================\n"+
                "==========   SOYİSİM İLE ÖĞRETMEN ARAMA  ======================\n"+
                "TC NO       İSİM        SOYİSİM       D.YILI     BRANS");


        for (Map.Entry<String,String> each:ogretmenEntrySet
        ) {String eachKey= each.getKey();
            String eachValue=each.getValue();

            String eachValuarr[]=eachValue.split(",");
            if(istenenSoyisim.equalsIgnoreCase(eachValuarr[1])){
                System.out.printf("%11s  %-6s  %-8s  %4s  %s \n",eachKey,eachValuarr[0],eachValuarr[1],eachValuarr[2],eachValuarr[3]);
            }

        }
        Thread.sleep(5000);
    }

    public static void ogretmenListesiYazdır() throws InterruptedException {
        Set<Map.Entry<String,String>> ogretmenEntrySet=ogretmenlerMap.entrySet();
        System.out.println("==========      YILDIZ KOLEJI   ======================\n"+
                           "==========   OGRETMEN Listesi  ======================\n"+
                           "TC NO       İSİM        SOYİSİM       D.YILI     BRANS");


        for (Map.Entry<String,String> each:ogretmenEntrySet
             ) {String eachKey= each.getKey();
            String eachValue=each.getValue();

            String eachValuarr[]=eachValue.split(",");
            System.out.printf("%11s  %-6s  %-8s  %4s  %s \n",eachKey,eachValuarr[0],eachValuarr[1],eachValuarr[2],eachValuarr[3]);

        }
        Thread.sleep(5000);

    }
}
