import java.util.Scanner;

public class Otobusbiletfiyatıhesaplamauygulaması {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Firma ismini giriniz: (Yeşil Varto,Lüks Havza İtimat,Tokat Yıldızı,Lider Muş,Pala Seyehat,Baba Turizim): ");
        String firma = scanner.nextLine().trim().toLowerCase();

        System.out.print("Mesafeyi (KM) girin: ");
        int mesafe = scanner.nextInt();

        System.out.print("Yaşınızı girin: ");
        int yas = scanner.nextInt();

        System.out.print("Yolculuk tipini seçin (1: Tek Yön, 2: Gidiş-Dönüş): ");
        int yolculukTipi = scanner.nextInt();

 
        double mesafeBasiUcret;
        switch (firma) {
            case "yeşil varto":
                mesafeBasiUcret = 0.49;
                break;
            case "lüks havza itimat":
                mesafeBasiUcret = 0.55;
                break;
            case "tokat yıldızı":
                mesafeBasiUcret = 0.60;
                break;
            case "lider muş":
                mesafeBasiUcret = 0.49;
                break;
            case "pala seyehat":
                mesafeBasiUcret = 0.55;
                break;
            case "baba turizim":
                mesafeBasiUcret = 0.21;
                break;
            default:
                System.out.println("Sistemimizde böyle bir firmamız bulunmamaktadır, otomatik ücret atacanacak (0.21 TL/km).");
                mesafeBasiUcret = 0.21;
        }

        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Yanlış Tercih Yaptınız !!!");
        } else {
            double toplamFiyat = mesafe * mesafeBasiUcret;
            double indirimOrani = 0;

            if (yas <=9) {
                indirimOrani += 1;
            } else if (yas >= 12 && yas <= 25) {
                indirimOrani += 0.25;
            } else if (yas > 65) {
                indirimOrani += 0.50;
            }

            if (yolculukTipi == 2) {
                indirimOrani += 0.20;
                toplamFiyat *= 2;
            }

            double indirimliFiyat = toplamFiyat * (1 - indirimOrani);

            System.out.println("\n--- Bilet Bilgisi ---");
            System.out.println("Seçilen Firma: " + firma.substring(0, 1).toUpperCase() + firma.substring(1));
            System.out.println("Mesafe Başı Ücret: " + mesafeBasiUcret + " TL/km");
            System.out.println("Toplam Bilet Fiyatı: " + String.format("%.2f", toplamFiyat) + " TL");

            if (indirimOrani > 0) {
                System.out.println("Uygulanan Toplam İndirim Oranı: %" + String.format("%.2f", indirimOrani * 100));
            }

            if (yolculukTipi == 2) {
                System.out.println("Gidiş-Dönüş İndirim Fiyatı Uygulandı!.");
                System.out.println("İndirimli Gidiş-Dönüş Bilet Fiyatı: " + String.format("%.2f", indirimliFiyat) + " TL");
            } else {
                System.out.println("İndirimli Tek Yön Bilet Fiyatı: " + String.format("%.2f", indirimliFiyat) + " TL");
            }
        }

        scanner.close();
    }
}
