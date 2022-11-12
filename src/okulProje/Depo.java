package okulProje;

import java.util.Scanner;

public class Depo {

    static Scanner scan =new Scanner(System.in );
    public static void anaMenu() throws InterruptedException {

         String tercih="";

        do {
        System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                           "==========      ANA MENÜ     ======================\n"+
                "\n"+
                "\t   1-OKUL BİLGİLERİ GÖRÜNTÜLE\n" +
                "\t   2- ÖĞRETMEN MENÜ\n"+
                "\t   3-ÖĞRENCİ MENÜ\t\t \n"+
                "\t   Q-ÇIKIŞ\n");

        System.out.println("LÜtfen menüden tercihinizi yapınız");
        tercih=scan.nextLine();

        switch (tercih){
            case "1":  //Okul bilgisi
                Depo.okulBilgileriniYazdır();
                break;
            case "2": //Öğretmen menü
                Ogretmen.ogretmenMenu();
                break;
            case "3": //Öğğrenci menü
                Ogrenci.ogrenciMenu();
                break;
            case "q":
            case "Q":
                break;
            default:
                System.out.println("geçerli bir tercih giriniz");
        }


        }while (!tercih.equalsIgnoreCase("q"));

        Depo.projeDurdur();
    }

    public static void okulBilgileriniYazdır() throws InterruptedException {

        System.out.println("==========   YILDIZ KOLEJI   ======================\n"+
                "\t\t Adres : " +Okul.adres+
                "\n\t\t Telefon : "+Okul.telefon);

        Thread.sleep(5000);

    }

    public static void projeDurdur() {
        System.out.println("Okul projesinden çıktınız");
        System.exit(0);
    }

}
