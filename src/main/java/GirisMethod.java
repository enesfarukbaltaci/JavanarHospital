import javax.print.Doc;
import java.sql.SQLException;
import java.util.Scanner;

public class GirisMethod {

    DoctorTransactions doctorTransactions = new DoctorTransactions();

    public void anaMenu() throws SQLException, ClassNotFoundException {

        System.out.println("           JAVANAR HOSPITALE HOSGELDINIZ\n" +
                "      LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ");
        System.out.printf("%-3s %-30.30s %-3s %-30.30s\n", "1-)", "DOKTOR EKLE", "5-)", "HASTA EKLE");
        System.out.printf("%-3s %-30.30s %-3s %-30.30s\n", "2-)", "DOKTORLARI LISTELE", "6-)", "HASTALARI LISTELE");
        System.out.printf("%-3s %-30.30s %-3s %-30.30s\n", "3-)", "DOKTOR BILGILERINI GUNCELLE", "7-)", "HASTA BILGILERINI GUNCELLE");
        System.out.printf("%-3s %-30.30s %-3s %-30.30s\n", "4-)", "DOKTOR SIL", "8-)", "HASTA SIL");
        System.out.print("Seciminizi yapiniz -> : ");


        int input = secenekKadarGirisAl(8);

        switch (input) {
            case 1:
                doctorTransactions.add();
                break;
            case 2:
                doctorTransactions.read();
                break;
            case 3:
                doctorTransactions.update();
                break;
            case 4:
                doctorTransactions.delete();
                break;
            case 5:
                HastaBilgileriGir.HastaBilgileriGir();
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                System.out.println("kaybol");
        }

    }


    public int secenekKadarGirisAl(int i) {
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scan.next());  //integer giris yapilana kadar while
                if (input > 0 && input <= i) {
                    break;
                } else throw new Exception();

            } catch (Exception e) {
                System.out.println("Hatali giris yaptiniz lutfen tekrar giris yapiniz");
            }
        }
        return input;
    }

}
